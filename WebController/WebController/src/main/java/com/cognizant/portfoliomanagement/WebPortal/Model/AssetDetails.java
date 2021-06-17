package com.cognizant.portfoliomanagement.WebPortal.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author saumy
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetDetails {

	
	private int id;
	private int portfolioId;
	private String assetId;
	private String assettype;
	private int assetcount;

	
}
