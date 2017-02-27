package com.lu.util;

import org.apache.commons.lang.StringUtils;

public class Like implements ConditionExp {

	private String property;

	private String value;

	private Like(String property, String value) {

		this.property = property;
		this.value = value;
	}

	public static Like as(String porperty, String value) {

		Like like = new Like(porperty, value);
		return like;

	}

	public boolean isSkip() {

		return StringUtils.isBlank(value);
	}

	/**
	 * @return the property
	 */
	public String getProperty() {
		return property;
	}

	/**
	 * @param property
	 *            the property to set
	 */
	public void setProperty(String property) {
		this.property = property;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
