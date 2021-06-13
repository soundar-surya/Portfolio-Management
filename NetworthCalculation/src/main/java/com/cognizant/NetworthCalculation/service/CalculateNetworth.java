package com.cognizant.NetworthCalculation.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cognizant.NetworthCalculation.exception.SellCountOverLimitException;
import com.cognizant.NetworthCalculation.model.AssetDetails;
import com.cognizant.NetworthCalculation.model.SellAssetDetails;
import com.cognizant.NetworthCalculation.model.StockDetails;
import com.cognizant.NetworthCalculation.repository.AssetRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@Service
public class CalculateNetworth {

	@Autowired
	AssetRepository assetRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;
    
	@Transactional
	public List<AssetDetails> getAllAssetForPortfolio(int id){
		return assetRepository.findByPortfolioIdOrderByAssetId(id);
	}

	public List<Double> getSharePriceById(List<String> stockList) throws JsonMappingException, JsonProcessingException {
		
		Application application = eurekaClient.getApplication("stock-service");
		InstanceInfo instanceInfo = application.getInstances().get(0);
		List<Double> stockValueList = new ArrayList<>();
		for(String stockId:stockList)
		{
        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "dailySharePriceById/" +stockId;
        double stockPrice=restTemplate.getForObject(url, Double.class);
        stockValueList.add(stockPrice);
        System.out.println("URL" + url);
		}
       System.out.println("RESPONSE " + stockValueList);
        return stockValueList;
	}

	public List<Double> getMutualFundUnitsById(List<String> mutualFundList) {
		
		Application application = eurekaClient.getApplication("dailymutualfundnav-service");
		InstanceInfo instanceInfo = application.getInstances().get(0);
		List<Double> mutualFundUnitsList = new ArrayList<>();
		for(String mutualFundId:mutualFundList)
		{
        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "dailyMutualFundValueById/" +mutualFundId;
        double mutualFundValue=restTemplate.getForObject(url, Double.class);
        mutualFundUnitsList.add(mutualFundValue);
        System.out.println("URL" + url);
		}
       System.out.println("RESPONSE " + mutualFundUnitsList);
		return mutualFundUnitsList;
	}

	@Transactional
	public void sellAsset(SellAssetDetails sellAssetDetails) throws SellCountOverLimitException {
		
		int portfolioId = sellAssetDetails.getId();
		String assetId = sellAssetDetails.getAssetId();
		var assetDetails = assetRepository.findByPortfolioIdAndAssetId(portfolioId, assetId);
		int existingCount = assetDetails.getAssetcount();
		int sellCount = sellAssetDetails.getAssetcount();
		if (sellCount > existingCount) {
			throw new SellCountOverLimitException("Asset sale count can't exceed the available quantity...");
		}
		if (existingCount == sellCount) {
			assetRepository.deleteByPortfolioIdAndAssetId(portfolioId, assetId);
		} else {
			existingCount -= sellCount;
		}
		assetDetails.setAssetcount(existingCount);
		assetRepository.save(assetDetails);
	}


	
}
