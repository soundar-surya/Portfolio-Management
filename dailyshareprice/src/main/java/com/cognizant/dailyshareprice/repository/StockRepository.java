package com.cognizant.dailyshareprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.dailyshareprice.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock,String>{

	public Stock findByStockName(String stockName);
}
