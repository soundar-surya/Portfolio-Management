package com.cognizant.NetworthCalculation.model;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MutualFundDetails {

	private String mutualFundId;
	private String mutualFundName;
	private double mutualFundValue;
}
