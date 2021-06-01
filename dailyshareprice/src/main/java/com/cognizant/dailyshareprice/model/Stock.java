package com.cognizant.dailyshareprice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stockdetails")
public class Stock {
	

	@Id
	@Column(name="stock_id")
	private String stockId;
	
	@Column(name="stock_name")
	private String stockName;
	
	@Column(name="stock_value")
	private double stockValue;
	
	

	public Stock(String stockId, String stockName, double stockValue) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.stockValue = stockValue;
	}
	
	

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public double getStockValue() {
		return stockValue;
	}

	public void setStockValue(double stockValue) {
		this.stockValue = stockValue;
	}

	@Override
	public String toString() {
		return "MutualFundDetails [stockId=" + stockId + ", stockName=" + stockName + ", stockValue=" + stockValue
				+ "]";
	}
	
		
}
