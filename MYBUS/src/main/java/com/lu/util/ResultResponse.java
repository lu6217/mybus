package com.lu.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;


public class ResultResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5430466806414716443L;
	private Boolean result = true;

	private String message;

	private List<String> fields = Lists.newArrayList();
	
	private Map<String, Object> data = new HashMap<String, Object>();
	
	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public void addAttribute(String key, Object value) {
		this.data.put(key, value);
	}

	public Object getAttribute(String key) {
		return this.data.get(key);
	}

	public ResultResponse(boolean result) {
		super();
		this.result = result;
	}

	public ResultResponse() {
		super();
	}

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getFields() {
		return fields;
	}

	public void setFields(List<String> fields) {
		this.fields = fields;
	}

	public void addField(String field) {
		this.fields.add(field);
	}

}
