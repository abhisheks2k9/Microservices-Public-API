/**
 * 
 */
package com.abhishek.projects.companies_service.clients;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.abhishek.projects.companies_service.model.CharityReponse;

/**
 * @author ABHISHEK
 *
 */
@Component
public class CharityAPIInvokeClient {
	/*Does not work with Spring Boot >=1.4*/
	/*@Autowired
	RestTemplate restTemplate;*/
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	private static final Logger logger = LoggerFactory.getLogger(CharityAPIInvokeClient.class);

	public CharityReponse getCharityByZip(String zipCode) {
		logger.info("In Charity API, zipCode is {}",zipCode);
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		Map map = new HashMap<String, String>();
		map.put("Content-Type", "application/json");

		headers.setAll(map);

		Map<String, String> req_payload = new HashMap<>();
		req_payload.put("user_key", "2fef0cf7d22f853831a40ea32ea71946");
		req_payload.put("zipCode", zipCode);

		HttpEntity<?> request = new HttpEntity<>(req_payload, headers);
		StringBuilder url = new StringBuilder("http://data.orghunter.com/v1/charitysearch");
		url.append("?user_key=2fef0cf7d22f853831a40ea32ea71946&zipCode=").append(zipCode);
		
		

		//ResponseEntity<?> response = restTemplate().postForEntity(url, request, String.class);
		ResponseEntity<CharityReponse> response = restTemplate().postForEntity(url.toString(), null, CharityReponse.class);
		CharityReponse entityResponse = (CharityReponse) response.getBody();
		logger.info("In Charity API response received");
		return entityResponse;
	}

}
