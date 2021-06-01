package com.cognizant.dailyshareprice.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dailyshareprice.exception.StockNotFoundException;
import com.cognizant.dailyshareprice.model.Stock;
import com.cognizant.dailyshareprice.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	StockRepository repository;
	
	@Transactional
	public Stock getStockByName(String stockName) throws StockNotFoundException{
		if(repository.findByStockName(stockName)==null)
			throw new StockNotFoundException("Mutual Fund Not Found");
		return repository.findByStockName(stockName);
	}
}
