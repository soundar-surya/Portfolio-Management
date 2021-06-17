package com.cognizant.portfoliomanagement.WebPortal.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author saumy
 *
 */
public class AssetDetailsTest {
	AssetDetails assetdetail=new AssetDetails();
	
	@Test
	void testSetTid() {
		assetdetail.setId(1);
		assertEquals(1,assetdetail.getId());
	}

	@Test
	void testSetAssetid() {
		assetdetail.setAssetId("101");
		assertEquals("101",assetdetail.getAssetId());
	}

	@Test
	void testSetPortfolioid() {
		assetdetail.setPortfolioId(11);
		assertEquals(11,assetdetail.getPortfolioId());
	}

	@Test
	void testSetType() {
		assetdetail.setAssettype("MF");
		assertEquals("MF",assetdetail.getAssettype());
	}

	@Test
	void testSetUnits() {
		assetdetail.setAssetcount(10);
		assertEquals(10,assetdetail.getAssetcount());
	}

	@Test
	void testAssetDetailsAllArgs() {
		AssetDetails assetdetail1=new AssetDetails(1, 11, "101", "MF", 10);
	}


	@Test
	void testToString() {
		AssetDetails assetdetail3=new AssetDetails(1, 11, "101", "MF", 10);
		assertEquals("AssetDetails [tid=0 assetid=null, portfolioid=0, type=null, units=0]",assetdetail3.toString());
	}


}
