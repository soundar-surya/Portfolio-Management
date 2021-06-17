package com.cognizant.portfoliomanagement.WebPortal.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.portfoliomanagement.WebPortal.Model.AuthResponse;
import com.cognizant.portfoliomanagement.WebPortal.Model.AuthToken;
import com.cognizant.portfoliomanagement.WebPortal.Model.LoginUser;
import com.cognizant.portfoliomanagement.WebPortal.Model.UserData;

/**
 * @author saumy
 *
 */
@FeignClient(name = "authenticationandauthorization-service", url = "http://localhost:8000")
public interface AuthClient {

	/**to register the login data to generate token
	 * @param loginUser
	 * @return token
	 */
	@RequestMapping(value = "/token/generate-token", method = RequestMethod.POST)
	public AuthToken register(@RequestBody LoginUser loginUser);
	
	/** to verify the user credentials
	 * @param Header
	 * @return boolean value
	 */
	@GetMapping("/validate")
    public Boolean verify(@RequestHeader("Authorization") String Header);

}

		