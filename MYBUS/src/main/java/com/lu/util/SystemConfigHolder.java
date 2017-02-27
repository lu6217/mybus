package com.lu.util;

import java.io.InputStream;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SystemConfigHolder {


	private static final String POP_ASSIGN_FEEDBACK_CHECK = "POP.ASSIGN.FEEDBACK.CHECK";

	private static final String POP_TASK_MYSCOPE_CHECK = "POP.TASK.MYSCOPE.CHECK";

	private static final String POP_TASK_CACHE = "POP.TASK.CACHE";

	private static final String EXCEL_STRIM_EHANCE = "EXCEL.TRIM.EHANCE";

	private static final String SYSTEM_DEV = "SYSTEM.DEV";

	private static final String SYSTEM_LEVEL = "SYSTEM.LEVEL";

	/**
	 * The Enum SystemLeve.
	 */
	public static enum SystemLeve {

		PSSDEV, PSSUAT, PSSPRD
	}

	/**
	 * 
	 * @return
	 */
	public static boolean isWindowsOS() {

		String os = System.getProperty("os.name");
		// System.out.println(os);

		return null != os && os.startsWith("Windows");
	}

	/**
	 * 
	 * @return
	 */
	public static String getCurrentOS() {

		return System.getProperty("os.name");
	}

	/**
	 * 
	 */
	private static Log log = LogFactory.getLog(SystemConfigHolder.class);

	/**
	 * 		Project Source Code
	 * @author William Shen
	 * @date 2011-3-14
	 */
	private static class MyHolder {

		private static final SystemConfigHolder instance = new SystemConfigHolder();
	}

	/**
	 * 
	 */
	private Properties properties = new Properties();

	/**
	 * Instance.
	 * 
	 * @return the system config holder
	 */
	public static SystemConfigHolder instance() {

		return MyHolder.instance;
	}

	private SystemConfigHolder() {

		load();
		
		load("interface-setting.properties");
	}

	private void load() {
		InputStream is = null;

		try {

			is = SystemConfigHolder.class.getClassLoader().getResourceAsStream("system-base.properties");
			properties.load(is);
			is.close();

		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.toString());
			}
		} finally {
			IOCloseUtils.close(is);
		}
	}
	
	private void load(String fileName) {
		InputStream is = null;

		try {

			is = SystemConfigHolder.class.getClassLoader().getResourceAsStream(fileName);
			properties.load(is);
			is.close();

		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e.toString());
			}
		} finally {
			IOCloseUtils.close(is);
		}
	}

	/**
	 * Gets the value.
	 * 
	 * @param key
	 *            the key
	 * @return the value
	 */
	public String getValue(String key) {
		
		

		return properties.getProperty(key);
	}
	
	/**
	 * 
	 * @param key
	 * @param defalutVal
	 * @return
	 */
	public String getValue(String key, String defalutVal){
		
		return properties.getProperty(key, defalutVal);
	}

	/**
	 * Gets the long.
	 * 
	 * @param key
	 *            the key
	 * @return the long
	 */
	public Long getLong(String key) {

		return Long.valueOf(properties.getProperty(key));

	}

	/**
	 * Gets the interger.
	 * 
	 * @param key
	 *            the key
	 * @return the interger
	 */
	public Integer getInterger(String key) {

		return Integer.valueOf(properties.getProperty(key));
	}
	
	
	public Integer getInterger(String key, int defaultValue){
		
		return Integer.valueOf(properties.getProperty(key,"100"));
	}

	/**
	 * Gets the boolean.
	 * 
	 * @param key
	 *            the key
	 * @return the boolean
	 */
	public boolean getBoolean(String key) {

		if (null == properties.get(key)) {
			return true;
		}

		return Boolean.valueOf(properties.getProperty(key));
	}

	/**
	 * 
	 * @param key
	 * @param defval
	 * @return
	 */
	public boolean getBoolean(String key, boolean defval) {

		if (null == properties.get(key)) {
			return defval;
		}

		return Boolean.valueOf(properties.getProperty(key));

	}

	/**
	 * Gets the float.
	 * 
	 * @param key
	 *            the key
	 * @return the float
	 */
	public Float getFloat(String key) {

		return Float.valueOf(properties.getProperty(key));
	}

	/**
	 * Gets the date.
	 * 
	 * @param key
	 *            the key
	 * @return the date
	 */
	public Date getDate(String key) {

		return PssDateUtils.parseDate(properties.getProperty(key));
	}

	/**
	 * Gets the values.
	 * 
	 * @param key
	 *            the key
	 * @return the values
	 */
	public String[] getValues(String key) {

		return properties.getProperty(key).split(",");
	}

	/**
	 * The Enum ReleaseType.
	 */
	public static enum ReleaseType {

		External, Internal
	}
	
	
	public static final String SYSTEM_MACHINE_LIST="System.Machine.List";
	
	/**
	 * 
	 * @return
	 */
	public String getSystemFullName() {
		
		String prefix = getReleaseType().name();
		String hostname = "dummy";

		try {
			hostname = java.net.InetAddress.getLocalHost().getHostName();

		} catch (UnknownHostException e) {

			PssLogFactory.getErrorLog().error(this.getClass().getName(), e);
		}
		
		return prefix+"_"+hostname;
	}

	/**
	 * Gets the release type.
	 * 
	 * @return the release type
	 */
	public ReleaseType getReleaseType() {

		String ts = getValue("RELEASE_TYPE");
		if (ts.equalsIgnoreCase("WAP")) {
			return ReleaseType.External;
		} else {
			return ReleaseType.Internal;
		}
	}

	/**
	 * Checks if is dev mode.
	 * 
	 * @return true, if is dev mode
	 */
	public boolean isDevMode() {

		String dev = getValue(SYSTEM_DEV);

		if (StringUtils.isBlank(dev)) {
			return false;
		} else {
			return getBoolean(SYSTEM_DEV);
		}

	}

	/**
	 * Checks if is powerfull trim.
	 * 
	 * @return true, if is powerfull trim
	 */
	public boolean isPowerfullTrim() {

		String dev = getValue(EXCEL_STRIM_EHANCE);

		if (StringUtils.isBlank(dev)) {
			return false;
		} else {
			return getBoolean(EXCEL_STRIM_EHANCE);
		}
	}

	/**
	 * Checks if is pop task cached.
	 * 
	 * @return true, if is pop task cached
	 */
	public boolean isPopTaskCached() {

		String dev = getValue(POP_TASK_CACHE);

		if (StringUtils.isBlank(dev)) {
			return false;
		} else {
			return getBoolean(POP_TASK_CACHE);
		}
	}

	/**
	 * Checks if is pop task item in my scope check.
	 * 
	 * @return true, if is pop task item in my scope check
	 */
	public boolean isPopTaskItemInMyScopeCheck() {

		String dev = getValue(POP_TASK_MYSCOPE_CHECK);

		if (StringUtils.isBlank(dev)) {
			return false;
		} else {
			return getBoolean(POP_TASK_MYSCOPE_CHECK);
		}
	}

	/**
	 * Checks if is pop assign feed back check.
	 * 
	 * @return true, if is pop assign feed back check
	 */
	public boolean isPopAssignFeedBackCheck() {

		String dev = getValue(POP_ASSIGN_FEEDBACK_CHECK);

		if (StringUtils.isBlank(dev)) {
			return false;
		} else {
			return getBoolean(POP_ASSIGN_FEEDBACK_CHECK);
		}

	}

	/**
	 * Gets the system level.
	 * 
	 * @return the system level
	 */
	public SystemLeve getSystemLevel() {

		String level = getValue(SYSTEM_LEVEL);
		SystemLeve sl = SystemLeve.PSSPRD;
		try {
			sl = SystemLeve.valueOf(level);
		} catch (Exception e) {
			PssLogFactory.getDebugLog().debug(e);
		}
		return sl;

	}

	/**
	 * Reload properties.
	 */
	public void reloadProperties() {
		this.properties.clear();
		this.load();
	}

	/**
	 * Gets the Long values.
	 * 
	 * @param key
	 *            the key
	 * @return the values
	 */
	public Long[] getValuesOfLong(String key) {
		String[] strValues = this.getValues(key);
		if (strValues != null && strValues.length > 0) {
			Long[] longValues = new Long[strValues.length];
			for (int i = 0; i < strValues.length; i++) {
				longValues[i] = Long.valueOf(strValues[i]);
			}
			return longValues;
		} else {
			return new Long[0];
		}

	}
}
