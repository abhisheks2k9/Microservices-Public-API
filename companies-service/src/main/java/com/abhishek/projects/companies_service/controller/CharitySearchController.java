/**
 * 
 */
package com.abhishek.projects.companies_service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.projects.companies_service.model.CharityInfo;
import com.abhishek.projects.companies_service.services.CharityService;

/**
 * @author ABHISHEK
 *
 */
@RestController
@RequestMapping(value="companies/byStates")
public class CharitySearchController {
	
	@Autowired
	CharityService charityService;
	
	private static final Logger logger = LoggerFactory.getLogger(CharitySearchController.class);
	
    @RequestMapping(value="/{zipCode}",method = RequestMethod.POST)
	public List<CharityInfo> getCharityByStates(@PathVariable("zipCode") String zipCode){
    	logger.info("Charity Controller zip Code is {}", zipCode);
    	return charityService.getCharityFromExternalClient(zipCode);
	}
	
}
