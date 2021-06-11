package com.cognizant.dailyshareprice.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.dailyshareprice.exception.StockNotFoundException;
import com.cognizant.dailyshareprice.model.Stock;
import com.cognizant.dailyshareprice.service.StockService;

@Api(value = "/dailySharePrice" , tags = {"SharePrice Controller"})
@RestController
public class StockController {

	@Autowired
	StockService service;

	@ApiOperation(value = "Returns details of a Stock.", notes = "Details of a Stock is provided as JSON", response = Stock.class)
	@ApiResponses(value = {@ApiResponse(code=404, message="Resource Not Found")})
	@GetMapping("/dailySharePrice/{stockName}")
	public Stock getDailySharePrice(@ApiParam(value="Name of the stock", required = true) @PathVariable String stockName) throws StockNotFoundException{
		
			return service.getStockByName(stockName);
	}
}
