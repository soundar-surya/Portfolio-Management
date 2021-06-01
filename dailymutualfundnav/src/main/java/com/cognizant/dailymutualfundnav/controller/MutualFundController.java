package com.cognizant.dailymutualfundnav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.dailymutualfundnav.exception.MutualFundNotFoundException;
import com.cognizant.dailymutualfundnav.model.MutualFundDetails;
import com.cognizant.dailymutualfundnav.service.MutualFundService;

@RestController
public class MutualFundController {

	@Autowired
	MutualFundService service;
	
	@GetMapping("/dailyMutualFundNav/{mutualFundName}")
	public MutualFundDetails getDailyMutualFundNav(@PathVariable String mutualFundName) throws MutualFundNotFoundException{
		
			return service.getMutualFundByName(mutualFundName);
	}
}
