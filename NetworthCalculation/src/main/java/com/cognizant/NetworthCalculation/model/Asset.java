package com.cognizant.NetworthCalculation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Asset {

	@Id
	@Column
	private int aid;

	@Column
	private String assetId;
	@Column
	private int portfolioId;
	@Column
	private String type;
	@Column
	private int units;

	public Asset() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Asset(int aid, String assetId, int portfolioId, String type, int units) {
		super();
		this.aid = aid;
		this.assetId = assetId;
		this.portfolioId = portfolioId;
		this.type = type;
		this.units = units;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public int getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(int portfolioId) {
		this.portfolioId = portfolioId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}
}
