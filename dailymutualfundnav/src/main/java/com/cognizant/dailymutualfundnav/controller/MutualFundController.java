package com.cognizant.dailymutualfundnav.controller;

import com.cognizant.dailymutualfundnav.exception.MutualFundNotFoundException;
import com.cognizant.dailymutualfundnav.model.MutualFundDetails;
import com.cognizant.dailymutualfundnav.service.MutualFundService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "/dailyMutualFundNav" , tags = {"MutualFund Controller"})
@SwaggerDefinition(tags = {
		@Tag(name = "MutualFund Controller", description = "returns details of a MutualFund.")
})
@RestController
public class MutualFundController {

	@Autowired
	MutualFundService service;

	@ApiOperation(value = "Returns details of a MutualFund.", notes = "Details of a MutualFund is provided as JSON")
	@ApiResponses(value = {@ApiResponse(code=404, message="Resource Not Found")})
	@GetMapping("/dailyMutualFundNav/{mutualFundName}")
	public MutualFundDetails getDailyMutualFundNav(  @ApiParam(value = "Name of the MutualFund", required = true)
														 @PathVariable String mutualFundName) throws MutualFundNotFoundException{
		
			return service.getMutualFundByName(mutualFundName);
	}
}
