package com.cognizant.dailymutualfundnav.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dailymutualfundnav.exception.MutualFundNotFoundException;
import com.cognizant.dailymutualfundnav.model.MutualFundDetails;
import com.cognizant.dailymutualfundnav.repository.MutualFundRepository;

@Service
public class MutualFundService {

	@Autowired
	MutualFundRepository repository;
	
	@Transactional
	public MutualFundDetails getMutualFundByName(String mutualFundName) throws MutualFundNotFoundException{
		if(repository.findByMutualFundName(mutualFundName)==null)
			throw new MutualFundNotFoundException("Mutual Fund Not Found");
		return repository.findByMutualFundName(mutualFundName);
	}
}
