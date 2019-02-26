/**
 * 
 */
package com.abhishek.projects.companies_service.model;

import java.util.List;

/**
 * @author ABHISHEK
 *
 */
public class CharityReponse {
	String code;
	String msg;
	List<CharityInfo> data;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<CharityInfo> getData() {
		return data;
	}
	public void setData(List<CharityInfo> data) {
		this.data = data;
	}
	
	

}
