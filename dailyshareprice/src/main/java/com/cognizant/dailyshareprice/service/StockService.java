package com.cognizant.dailyshareprice.service;

import java.util.ArrayList;
import java.util.List;

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
	public List<Stock> getAllShares(){
		return repository.findAll();
	}
	
	@Transactional
	public Stock getStockByName(String stockName) throws StockNotFoundException{
		if(repository.findByStockName(stockName)==null)
			throw new StockNotFoundException("Stock Not Found");
		return repository.findByStockName(stockName);
	}
	
	@Transactional
	public Stock getShareById(String stockId) throws StockNotFoundException {
		 
		if(repository.findByStockId(stockId)==null)
		{
			
			throw new StockNotFoundException("Stock Not Found");
	}
		return repository.findByStockId(stockId);
	}

	public double getSharePriceById(String stockId) {
			System.out.println(stockId);
		return repository.findStockValueById(stockId);//stockValueList;
	}
}
