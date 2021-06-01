package com.cognizant.dailymutualfundnav;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.dailyshareprice.controller.StockController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class DailymutualfundnavApplicationTests {

	@Autowired
    private MockMvc mvc;
	
	 @Autowired
	    private StockController stockController;
	 
	@Test
	void contextLoads() {
		assertNotNull(stockController);
	}
	
	@Test
    public void testGetDailyMutualFundNavByName() throws Exception {
        ResultActions actions = mvc.perform(get("/dailySharePrice/Axis"));
        actions.andExpect(status().isOk());
        actions.andExpect(jsonPath("$.stockId").exists());
        actions.andExpect(jsonPath("$.stockId").value("A"));
        
        actions.andExpect(jsonPath("$.stockName").exists());
        actions.andExpect(jsonPath("$.stockName").value("Axis"));
        
        actions.andExpect(jsonPath("$.stockValue").exists());
        actions.andExpect(jsonPath("$.stockValue").value("6000.0"));
    }
	

}
