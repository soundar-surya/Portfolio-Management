package com.cognizant.dailymutualfundnav.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.dailymutualfundnav.model.MutualFundDetails;

@Repository
public interface MutualFundRepository extends JpaRepository<MutualFundDetails,String>{

	public MutualFundDetails findByMutualFundName(String mutualFundName);
}
