package com.cognizant.NetworthCalculation;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.controller.NetworthController;

@SpringBootTest
@AutoConfigureMockMvc
class NetworthCalculationApplicationTests {

	@Autowired
    private NetworthController networthController;

 

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    void contextLoads() {
        assertNotNull(networthController);
    }
    
    /*@Test
	void testCalculateNetworthGetNetworth() throws Exception {
		ResultActions actions = mockMvc.perform(get("/calculateNetworth/101"));
		actions.andExpect(status().isMethodNotAllowed());

	}


	@Test
	void testCalculateNetworthSellAssets() throws Exception {
		ResultActions actions = mockMvc.perform(get("/sellassets"));
		actions.andExpect(status().isNotFound());
	}*/

}
