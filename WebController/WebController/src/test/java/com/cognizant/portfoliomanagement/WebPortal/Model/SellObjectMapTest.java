package com.cognizant.portfoliomanagement.WebPortal.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author saumy
 *
 */
class SellObjectMapTest {

	SellObjectMap sellobj=new SellObjectMap();
	
	@Test
	void testSetStockIdList() {
		sellobj.setStockIdList(null);
		assertEquals(null,sellobj.getStockIdList());
	}

	@Test
	void testSetMfAssetList() {
		sellobj.setMfAssetList(null);
		assertEquals(null,sellobj.getMfAssetList());
	}

	@Test
	void testSellObjectMap() {
		SellObjectMap sell1=new SellObjectMap();
	}
	@Test
	void testSellObjectMapIntMapOfStringIntegerMapOfStringInteger() {
		SellObjectMap sell= new SellObjectMap(0, null, null);
	}

	@Test
	void testToString() {
		SellObjectMap sell2=new SellObjectMap(0, null, null);
		assertEquals("SellObjectMap [pid=0, stockIdList=null, mfAssetList=null]",sell2.toString());
	}

}
