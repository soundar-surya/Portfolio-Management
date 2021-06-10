package com.cognizant.NetworthCalculation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.NetworthCalculation.model.Asset;

public interface AssetRepository extends JpaRepository<Asset, Integer> {

	@Query("FROM Asset WHERE portfolioId = ?1")
	public List<Asset> findAssetUsingPortfolioId(int portfolioId);
}
