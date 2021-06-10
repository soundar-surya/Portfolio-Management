package com.cognizant.NetworthCalculation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.NetworthCalculation.model.Asset;
import com.cognizant.NetworthCalculation.repository.AssetRepository;

@Service
public class CalculateNetworth {

	@Autowired
	AssetRepository assetRepository;

	// After completing the project, add a parameter presentValue
	public double calculateNetworth(int portfolioId) {
		// Giving a temporary presentValue
		int presentValue = 100;
		double netWorth = 0.0;

		List<Asset> assetList = assetRepository.findAssetUsingPortfolioId(portfolioId);

		for (Asset a : assetList) {
			netWorth += (a.getUnits() * presentValue);
		}

		/*
		 * Asset asset = assetRepository.getById(101);
		 * 
		 * System.out.println(asset);
		 */

		return netWorth;
	}
}
