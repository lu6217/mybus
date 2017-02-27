package com.lu.util;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.google.common.collect.Lists;

public class Eq implements ConditionExp {

	private String property;

	private Object value;

	private List<Object> skipValues = Lists.newArrayList();

	private Eq(String property, Object value) {
		this.property = property;

		this.value = value;
	}

	public static Eq as(String property, Object value) {
		Eq eq = new Eq(property, value);

		return eq;
	}

	public static Eq as(String property, Object value, List<Object> skipValues) {
		Eq eq = new Eq(property, value);
		eq.skipValues = skipValues;

		return eq;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dragonsoftbravo.utils.hibernate.ConditionExp#isSkip()
	 */
	@Override
	public boolean isSkip() {

		if (this.value == null) {
			return true;
		}

		if (this.skipValues.contains(this.value)) {
			return true;
		}

		if (this.value.getClass().equals(String.class)) {

			String v = (String) value;

			return StringUtils.isBlank(v);
		}

		return false;
	}

	@Override
	public String getProperty() {
		return this.property;
	}

	@Override
	public Object getValue() {
		return this.value;
	}

}
