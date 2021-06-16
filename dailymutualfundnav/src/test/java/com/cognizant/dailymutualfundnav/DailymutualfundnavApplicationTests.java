package com.cognizant.dailymutualfundnav;

//import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import org.junit.runner.RunWith;
import com.cognizant.dailymutualfundnav.controller.MutualFundController;
import com.cognizant.dailymutualfundnav.model.MutualFundDetails;
import com.cognizant.dailymutualfundnav.repository.MutualFundRepository;
import com.cognizant.dailymutualfundnav.service.MutualFundService;

@AutoConfigureMockMvc
@SpringBootTest
public class DailymutualfundnavApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private MutualFundController mutualFundController;

	@Autowired
	private MutualFundService mutualFundService;

	@Test
	void contextLoads() {
		assertNotNull(mutualFundController);
	}
	
	/*
	 mockMvc.perform(get("/form"))
     .andExpect(status().isOk())
     .andExpect(content().mimeType("text/html"))
     .andExpect(forwardedUrl("/WEB-INF/layouts/main.jsp")); 
	 */

	@Test
	public void testGetDailyMutualFundNavByName() throws Exception {
		ResultActions actions = mvc.perform(get("/dailyMutualFundName/AxisMutualFund"));
		actions.andExpect(status().isOk());
		actions.andExpect(jsonPath("$.mutualFundId").exists());
		actions.andExpect(jsonPath("$.mutualFundId").value("AXIS"));

		actions.andExpect(jsonPath("$.mutualFundName").exists());
		actions.andExpect(jsonPath("$.mutualFundName").value("AxisMutualFund"));

		actions.andExpect(jsonPath("$.mutualFundValue").exists());
		actions.andExpect(jsonPath("$.mutualFundValue").value("6000.0"));
	}

	@Test
	public void testGetDailyMutualFundById() throws Exception {
		ResultActions actions = mvc.perform(get("/dailyMutualFundId/AXIS"));
		actions.andExpect(status().isOk());
		actions.andExpect(jsonPath("$.mutualFundId").exists());
		actions.andExpect(jsonPath("$.mutualFundId").value("AXIS"));

		actions.andExpect(jsonPath("$.mutualFundName").exists());
		actions.andExpect(jsonPath("$.mutualFundName").value("AxisMutualFund"));

		actions.andExpect(jsonPath("$.mutualFundValue").exists());
		actions.andExpect(jsonPath("$.mutualFundValue").value("6000.0"));
	}
	
	@Test
	public void testSetMutualFundId() {
		MutualFundDetails mfd = new MutualFundDetails();
		mfd.setMutualFundId("G");
		assertTrue(mfd.getMutualFundId() == "G");
	}

	@Test
	public void testSetMutualFundName() {
		MutualFundDetails mfd = new MutualFundDetails();
		mfd.setMutualFundName("DLF");
		assertTrue(mfd.getMutualFundName() == "DLF");
	}

	@Test
	public void testSetMutualValue() {
		MutualFundDetails mfd = new MutualFundDetails();
		mfd.setMutualFundValue(6000.00);
		assertTrue(mfd.getMutualFundValue() == 6000.00);
	}

	@Test
	public void testSetMutualFund() {
		MutualFundDetails mfd = new MutualFundDetails("AXIS", "AxisMutualFund", 6000.0);
		assertTrue(mfd.getMutualFundId() == "AXIS");
	}

	@Test
	public void testSetMutualFundtoString() {
		MutualFundDetails mfd = new MutualFundDetails("AX", "AxisMutualFund", 6000.0);
		assertFalse(mfd.toString() == "G");
	}

	@Test
	public void testFindOne() throws Exception {
		MutualFundDetails item = mutualFundService.getMutualFundByName("AxisMutualFund");
		boolean value = item.getMutualFundValue() == 6000.0 ? true : false;
		assertTrue(value);
	}

	@Test
	public void testFindTwo() throws Exception {
		MutualFundDetails item = mutualFundService.getMutualFundById("AXIS");
		boolean value = item.getMutualFundValue() == 6000.0 ? true : false;
		assertTrue(value);
	}

	@Test
	public void testFindThree() throws Exception {
		MutualFundDetails item = mutualFundService.getMutualFundById("AXIS");
		boolean value = item.getMutualFundValue() == 6000.0 ? true : false;
		assertTrue(value);
	}

}