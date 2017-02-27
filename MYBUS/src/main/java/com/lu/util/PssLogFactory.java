package com.lu.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PssLogFactory {

	private static final Log ACCESS = LogFactory.getLog("ACCESS");

	private static final Log OPERATION = LogFactory.getLog("OPERATION");

	private static final Log BUSINESS = LogFactory.getLog("BUSINESS");

	private static final Log ERROR = LogFactory.getLog("ERROR");

	private static final Log DEBUG = LogFactory.getLog("DEBUG");

	private static final Log MAIL = LogFactory.getLog("MAIL");

	/**
	 * 
	 * @return
	 */
	public static Log getAccessLog() {

		return ACCESS;
	}

	/**
	 * 
	 * @return
	 */
	public static Log getOperationLog() {
		return OPERATION;
	}

	/**
	 * 
	 * @return
	 */
	public static Log getBusinessLog() {
		return BUSINESS;
	}

	/**
	 * 
	 * @return
	 */
	public static Log getErrorLog() {
		return ERROR;
	}

	/**
	 * 
	 * @return
	 */
	public static Log getDebugLog() {

		return DEBUG;
	}

	/**
	 * 
	 * @return
	 */
	public static Log getMailLog() {

		return MAIL;
	}

}
