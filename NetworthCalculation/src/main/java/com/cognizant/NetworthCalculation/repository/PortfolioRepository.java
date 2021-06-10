package com.cognizant.NetworthCalculation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.NetworthCalculation.model.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio, Integer> {

}
