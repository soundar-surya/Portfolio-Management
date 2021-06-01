package com.cognizant.dailyshareprice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.dailyshareprice.exception.StockNotFoundException;
import com.cognizant.dailyshareprice.model.Stock;
import com.cognizant.dailyshareprice.service.StockService;

@RestController
public class StockController {

	@Autowired
	StockService service;
	
	@GetMapping("/dailySharePrice/{stockName}")
	public Stock getDailySharePrice(@PathVariable String stockName) throws StockNotFoundException{
		
			return service.getStockByName(stockName);
	}
}
