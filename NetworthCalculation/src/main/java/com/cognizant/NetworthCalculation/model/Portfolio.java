package com.cognizant.NetworthCalculation.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Portfolio {

	@Id
	private int portfolioId;

	public Portfolio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Portfolio(int portfolioId) {
		super();
		this.portfolioId = portfolioId;
	}

	public int getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(int portfolioId) {
		this.portfolioId = portfolioId;
	}
}
