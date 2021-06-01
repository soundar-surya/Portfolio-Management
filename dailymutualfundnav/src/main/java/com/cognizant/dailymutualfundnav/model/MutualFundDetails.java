package com.cognizant.dailymutualfundnav.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mutualfunddetails")
public class MutualFundDetails {

	@Id
	@Column(name="mutualfund_id")
	private String mutualFundId;
	
	@Column(name="mutualfund_name")
	private String mutualFundName;
	
	@Column(name="mutualfund_value")
	private double MutualFundValue;
	
	public MutualFundDetails(String mutualFundId, String mutualFundName, double mutualFundValue) {
		super();
		this.mutualFundId = mutualFundId;
		this.mutualFundName = mutualFundName;
		MutualFundValue = mutualFundValue;
	}
	
	public MutualFundDetails() {
		super();
	}
	
	public String getMutualFundId() {
		return mutualFundId;
	}
	public void setMutualFundId(String mutualFundId) {
		this.mutualFundId = mutualFundId;
	}
	public String getMutualFundName() {
		return mutualFundName;
	}
	public void setMutualFundName(String mutualFundName) {
		this.mutualFundName = mutualFundName;
	}
	public double getMutualFundValue() {
		return MutualFundValue;
	}
	public void setMutualFundValue(double mutualFundValue) {
		MutualFundValue = mutualFundValue;
	}
	
	@Override
	public String toString() {
		return "MutualFundDetails [mutualFundId=" + mutualFundId + ", mutualFundName=" + mutualFundName
				+ ", MutualFundValue=" + MutualFundValue + "]";
	}
	
	
}
