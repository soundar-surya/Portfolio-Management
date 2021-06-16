package com.cognizant.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.SellCountException;
import com.cognizant.feignclient.CalculateNetworthClient;
import com.cognizant.model.AssetDetails;
import com.cognizant.model.SellAssetDetails;
import com.cognizant.repository.AssetRepository;
import com.cognizant.service.CalculateNetworth;

@Api(value = "/home", tags = { "Networth Controller" })
@RestController
@Slf4j
public class NetworthController {

	@Autowired
	AssetRepository assetRepository;

	@Autowired
	CalculateNetworth calculateNetworth;

	@Autowired
	CalculateNetworthClient calculateNetworthClient;

	@ApiOperation(value = "Returns details of Assets.", notes = "Details of a Stock is provided as JSON", response = AssetDetails.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Resource Not Found") })
	@GetMapping("/home")
	public List<AssetDetails> listAll(HttpServletRequest req) {
		
		List<AssetDetails> assetList = assetRepository.findAll();
		String BearerToken = req.getHeader("Authorization");
		if (calculateNetworth.AuthorizeUser(BearerToken)) {

			for (AssetDetails a : assetList) {
				System.out.println(a);
			}
			return assetList;
		}
		
		return assetList;
	}

	@ApiOperation(value = "Returns Networth of a stakeholder bases on ID", notes = "Networth is provided as Double")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Resource Not Found") })
	@GetMapping("/calculateNetworth/{id}")
	public double calculateNetworth(
			@ApiParam(value = "ID of the Stakeholder", required = true) @PathVariable(value = "id") int id,
			HttpServletRequest req) {
		
		double netWorth = 0.0;
		String bearerToken = req.getHeader("Authorization");
		if (calculateNetworth.AuthorizeUser(bearerToken)) {

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

			List<Double> stockPriceList = calculateNetworth.getSharePriceById(stockList, bearerToken);
			List<Double> mutualFundUnitsList = calculateNetworth.getMutualFundUnitsById(mutualFundList, bearerToken);
			int stock = 0;
			int mutualFund = 0;
			for (AssetDetails asset : assets) {
				if (asset.getAssettype().equals("Share")) {
					netWorth += asset.getAssetcount() * stockPriceList.get(stock);
					stock++;
				} else {
					netWorth += asset.getAssetcount() * mutualFundUnitsList.get(mutualFund);
					mutualFund++;
				}
			}

			/*log.info("assets:{}", assets);
			log.info("Stock{}", stockPriceList);
			log.info("MutualFundNAV{}", mutualFundUnitsList);
			log.info("netWorth{}", netWorth);*/

			return netWorth;
		}
		return netWorth;

	}

	@ApiOperation(value = "Returns Networth of a stakeholder bases on ID", notes = "Networth is provided as Double")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Resource Not Found") })
	@PostMapping("/sellassets")
	public double sellPortfolioAssets(
			@ApiParam(value = "Assest to be sold", required = true) @RequestBody SellAssetDetails sellAssetDetails,
			HttpServletRequest req) throws SellCountException {

		String bearerToken = req.getHeader("Authorization");
		if (calculateNetworth.AuthorizeUser(bearerToken)) {

			System.out.println(sellAssetDetails);
			calculateNetworth.sellAsset(sellAssetDetails);
			double networth = calculateNetworthClient.calculateNetworth(bearerToken, sellAssetDetails.getId());

			return networth;
		}
		return 0;

	}
}
