package com.cognizant.NetworthCalculation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.NetworthCalculation.model.PortfolioDetails;

public interface PortfolioRepository extends JpaRepository<PortfolioDetails, Integer> {

}
