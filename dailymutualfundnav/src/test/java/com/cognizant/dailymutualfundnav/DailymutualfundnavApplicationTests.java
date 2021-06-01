package com.cognizant.dailymutualfundnav;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.cognizant.dailymutualfundnav.controller.MutualFundController;

@AutoConfigureMockMvc
@SpringBootTest
class DailymutualfundnavApplicationTests {

	@Autowired
    private MockMvc mvc;
	
	 @Autowired
	    private MutualFundController mutualFundController;
	 
	@Test
	void contextLoads() {
		assertNotNull(mutualFundController);
	}
	
	@Test
    public void testGetDailyMutualFundNavByName() throws Exception {
        ResultActions actions = mvc.perform(get("/dailyMutualFundNav/Axis Mutual Fund"));
        actions.andExpect(status().isOk());
        actions.andExpect(jsonPath("$.mutualFundId").exists());
        actions.andExpect(jsonPath("$.mutualFundId").value("AXIS"));
        
        actions.andExpect(jsonPath("$.mutualFundName").exists());
        actions.andExpect(jsonPath("$.mutualFundName").value("Axis Mutual Fund"));
        
        actions.andExpect(jsonPath("$.mutualFundValue").exists());
        actions.andExpect(jsonPath("$.mutualFundValue").value("6000.0"));
    }
	

}
