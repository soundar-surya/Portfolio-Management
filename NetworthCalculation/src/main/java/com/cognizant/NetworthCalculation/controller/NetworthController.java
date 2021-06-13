package com.cognizant.NetworthCalculation.controller;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.NetworthCalculation.exception.SellCountOverLimitException;
import com.cognizant.NetworthCalculation.model.AssetDetails;
import com.cognizant.NetworthCalculation.model.SellAssetDetails;
import com.cognizant.NetworthCalculation.repository.AssetRepository;
import com.cognizant.NetworthCalculation.service.CalculateNetworth;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@Api(value="/home", tags={"Networth Controller"})
@RestController
public class NetworthController {

	@Autowired
	AssetRepository assetRepository;
	
	@Autowired
	CalculateNetworth calculateNetworth;

	@ApiOperation(value = "Returns details of Assets.", notes="Details of a Stock is provided as JSON",
			response = AssetDetails.class, responseContainer = "List")
	@ApiResponses(value = {@ApiResponse(code=404, message="Resource Not Found")})
	@GetMapping("/home")
	public List<AssetDetails> listAll() {
		List<AssetDetails> assetList = assetRepository.findAll();
		for (AssetDetails a : assetList) {
			System.out.println(a);
		}
		return assetList;
	}

	@ApiOperation(value = "Returns Networth of a stakeholder bases on ID", notes="Networth is provided as Double")
	@ApiResponses(value = {@ApiResponse(code=404, message="Resource Not Found")})
	@GetMapping("/calculateNetworth/{id}")
	public double getAsset(@ApiParam(value="ID of the Stakeholder", required = true) @PathVariable(value = "id") int id) throws JsonMappingException, JsonProcessingException
	{
		double netWorth = 0.0;
		List<AssetDetails> assets = calculateNetworth.getAllAssetForPortfolio(id);
		List<String> stockList = new ArrayList<>();
		List<String> mutualFundList = new ArrayList<>();
		for (AssetDetails a : assets) {
			if (a.getAssettype().equals("MutualFund")) {
				mutualFundList.add(a.getAssetId());
			} else {
				
				stockList.add(a.getAssetId());
			}
		}
		
		List<Double> stockPriceList = new ArrayList<>();
		List<Double> mutualFundUnitsList = new ArrayList<>();
		if (!stockList.isEmpty()) {
			stockPriceList = calculateNetworth.getSharePriceById(stockList);
			System.out.println(stockPriceList);
			//log.info("found stock Value List");
		}
		if (!mutualFundList.isEmpty()) {
			mutualFundUnitsList = calculateNetworth.getMutualFundUnitsById(mutualFundList);
			//log.info("found mutual Value List");
		}
		System.out.println("assets:"+assets);
		System.out.println("Stock"+stockPriceList);
		System.out.println("MutualFundNAV"+mutualFundUnitsList);
		int stockCounter = 0;
		int mutualFundCounter = 0;
		for (AssetDetails asset : assets) {
			if (asset.getAssettype().equals("Share")) {
				netWorth += asset.getAssetcount() * stockPriceList.get(stockCounter);
				stockCounter++;
			} else {
				netWorth += asset.getAssetcount() * mutualFundUnitsList.get(mutualFundCounter);
				mutualFundCounter++;
			}
		}
		return netWorth;

	}

	@ApiOperation(value = "Returns Networth of a stakeholder bases on ID", notes="Networth is provided as Double")
	@ApiResponses(value = {@ApiResponse(code=404, message="Resource Not Found")})
	@PostMapping("/sell-assets")
	public double sellPortfolioAssets(@ApiParam(value="Assest to be sold", required = true)@RequestBody SellAssetDetails sellAssetDetails) throws SellCountOverLimitException, JsonMappingException, JsonProcessingException {
		//log.info("Starting sellPortfolioAssets");
		System.out.println(sellAssetDetails);
			calculateNetworth.sellAsset(sellAssetDetails);
			double networth =getAsset(sellAssetDetails.getId());
			//log.info("Ending sellPortfolioAssets");
			return networth;

	}
}
