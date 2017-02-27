package com.lu.util;

import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;

public class In implements ConditionExp {

	private String property;

	private Object[] value;

	private In(String property, Object[] value) {

		this.property = property;

		this.value = value;
	}

	public static In as(String property, Object[] value) {

		In like = new In(property, value);
		return like;

	}

	public static In as(String property, Collection<?> value) {
		Object[] val = null;
		if (CollectionUtils.isNotEmpty(value)) {
			val = value.toArray();
		}

		return as(property, val);

	}

	public boolean isSkip() {

		return ArrayUtils.isEmpty(value);
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
	public Object[] getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(Object[] value) {
		this.value = value;
	}

}
