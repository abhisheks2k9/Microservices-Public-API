/**
 * 
 */
package com.abhishek.projects.companies_service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhishek.projects.companies_service.clients.CharityAPIInvokeClient;
import com.abhishek.projects.companies_service.model.CharityInfo;
import com.abhishek.projects.companies_service.model.CharityReponse;

/**
 * @author ABHISHEK
 *
 */
@Service
public class CharityService {
	@Autowired
	CharityAPIInvokeClient charityAPIInvokeClient;
	
	public List<CharityInfo> getCharityFromExternalClient(String zipCode){
		CharityReponse res = charityAPIInvokeClient.getCharityByZip(zipCode);
		if(res!=null && res.getCode().equalsIgnoreCase("200"))
			return res.getData();
		return null;
	}

}
