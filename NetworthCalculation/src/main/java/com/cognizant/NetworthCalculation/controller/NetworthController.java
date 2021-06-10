package com.cognizant.NetworthCalculation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.NetworthCalculation.model.Asset;
import com.cognizant.NetworthCalculation.repository.AssetRepository;
import com.cognizant.NetworthCalculation.service.CalculateNetworth;

@Controller
public class NetworthController {

	@Autowired
	AssetRepository assetRepository;

	@Autowired
	CalculateNetworth calculateNetworth;

	@RequestMapping("/home")
	public void listAll() {
		List<Asset> assetList = assetRepository.findAll();
		for (Asset a : assetList) {
			System.out.println(a);
		}
	}

	@RequestMapping("/profile")
	public ModelAndView postPresentNetworth(@RequestParam int portfolioId)
	{
		System.out.println("DAMN");
		
		double networth = calculateNetworth.calculateNetworth(portfolioId);
		System.out.println("networth: " + networth);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("portfolio");
		modelAndView.addObject("networth", networth);
		modelAndView.addObject("portfolioId", portfolioId);

		return modelAndView;
	}

}
