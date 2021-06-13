package com.cognizant.dailyshareprice.controller;

import com.cognizant.dailyshareprice.exception.StockNotFoundException;
import com.cognizant.dailyshareprice.model.Stock;
import com.cognizant.dailyshareprice.service.StockService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value="/dailySharePrice", tags={"SharePrice Controller"})
@RestController
public class StockController {

	@Autowired
	StockService service;

	@ApiOperation(value = "Returns details of all Stock.", notes="Details of a Stock is provided as JSON",
	response = Stock.class, responseContainer = "List")
	@ApiResponses(value = {@ApiResponse(code=404, message="Resource Not Found")})
	@GetMapping("/dailyAllSharePrice")
	public List<Stock> getAllDailySharePrice() throws StockNotFoundException{
		
			return service.getAllShares();
	}

	@ApiOperation(value = "Returns details of Stock based on Stock name.", notes="Details of a Stock is provided as JSON",
			response = Stock.class)
	@ApiResponses(value = {@ApiResponse(code=404, message="Resource Not Found")})
	@GetMapping("/dailySharePrice/{stockName}")
	public Stock getDailySharePrice(@ApiParam(value="Name of the stock", required = true) @PathVariable String stockName) throws StockNotFoundException{
		
			return service.getStockByName(stockName);
	}

	@ApiOperation(value = "Returns details of a Stock based on Stock Id.", notes="Details of a Stock is provided as JSON",
			response = Stock.class)
	@ApiResponses(value = {@ApiResponse(code=404, message="Resource Not Found")})
	@GetMapping("/dailyShareId/{stockId}")
	public Stock getDailyShareById(@ApiParam(value="ID of the stock", required = true) @PathVariable(value="stockId") String stockId) throws StockNotFoundException{
		
			return service.getShareById(stockId);
	}

	@ApiOperation(value = "Returns daily price of a Stock.", notes="Price of a Stock is provided as double",
			response = Stock.class, responseContainer = "List")
	@ApiResponses(value = {@ApiResponse(code=404, message="Resource Not Found")})
	@GetMapping("/dailySharePriceById/{stockId}")
	public double getDailySharePriceStock(@ApiParam(value="ID of the stock", required = true) @PathVariable("stockId") String stockId) throws StockNotFoundException{
		System.out.println(stockId);
		System.out.println(service.getSharePriceById(stockId));
			return service.getSharePriceById(stockId);
	}
	
}
