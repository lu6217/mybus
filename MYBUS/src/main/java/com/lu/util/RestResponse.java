package com.lu.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class RestResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3173636013509844551L;

	private Boolean result = true;

	private String msg = "²Ù×÷³É¹¦!";

	private Map<String, Object> data = new HashMap<String, Object>();

	/**
	 * 
	 * @return
	 */
	public static RestResponse instance() {
		RestResponse rr = new RestResponse(false);
		return rr;
	}

	public RestResponse(boolean result) {
		super();
		this.result = result;
	}

	public RestResponse() {
		super();
	}

	public Boolean getResult() {
		return result;
	}

	public RestResponse setResult(Boolean result) {
		this.result = result;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public RestResponse setMessage(String message) {
		this.msg = message;
		return this;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	public void addAttribute(String key,Object value){
		this.data.put(key, value);
	}

	public Object getAttribute(String key){
		return this.data.get(key);
	}
	
	/**
	 * 
	 * @param br
	 */
	public void join(BindingResult br) {

		StringBuilder sbr = new StringBuilder();
		for (ObjectError oe : br.getAllErrors()) {
			sbr.append(oe.getDefaultMessage()).append("\n");
		}

		this.msg = sbr.toString();
	}

}
