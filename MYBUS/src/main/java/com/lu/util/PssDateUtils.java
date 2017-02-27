package com.lu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.quartz.CronExpression;

import com.lu.util.PssDateWrapper.DateType;

public final class PssDateUtils {

	/** The Constant _9999_12_31. */
	private static final String _9999_12_31 = "9999-12-31";

	/** The Constant _1972_1_1. */
	private static final String _1972_1_1 = "1972-1-1";

	/** The Constant DEFAULT_DATE_FORMAT. */
	private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

	/** The Constant DATE_FORMAT2. */
	private static final String DATE_FORMAT2 = "yyyy/MM/dd";

	/** The Constant DATE_YYYY_MM. */
	private static final String DATE_YYYY_MM = "yyyy-MM";

	/** The Constant DEFAULT_DATE_FORMAT_FULL. */
	public static final String DATE_FORMAT_TO_MINUTE = "yyyy-MM-dd HH:mm";

	/** The Constant DEFAULT_DATE_FORMAT_FULL. */
	public static final String DEFAULT_DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";

	/** The Constant DATE_FORMAT_MDY_BACKSLASH. */
	public static final String DATE_FORMAT_MDY_BACKSLASH = "MM/dd/yyyy";

	/** The Constant DATE_FORMAT_MDYAPMarker_BACKSLASH. */
	public static final String DATE_FORMAT_MDYAPMarker_BACKSLASH = "MM/dd/yyyy hh:mm a";
	
	/** The Constant DATE_FORMAT_MDYAPMarker_BACKSLASH. */
	public static final String DATE_FORMAT_MDYAPMarker = "yyyy/MM/dd hh:mm";
	

	public static final String DATE_FORMAT_TO_MINUTE_BACKSLASH = "MM/dd/yyyy HH:mm";
	

	/** The Constant TIME_FORMAT_MDYAPMarker. */
	public static final String TIME_FORMAT_MDYAPMarker = "hh:mm a";

	/**
	 * Parses the date.
	 * 
	 * @param dateStr
	 *            the date str
	 * @return the date
	 */
	public static Date parseDate(String dateStr) {

		if (StringUtils.isEmpty(dateStr)) {
			return null;
		}

		Calendar cal = Calendar.getInstance();

		try {

			Date toDate = DateUtils.parseDate(dateStr, new String[] {DATE_FORMAT_MDYAPMarker, DATE_FORMAT_TO_MINUTE,DEFAULT_DATE_FORMAT, DATE_FORMAT2, DEFAULT_DATE_FORMAT_FULL,
					DATE_YYYY_MM });
			String[] ss = dateStr.split("(-)|(/)");

			int year = Integer.valueOf(ss[0]);
			int month = Integer.valueOf(ss[1]);

			cal.setTime(toDate);

			int year2 = cal.get(Calendar.YEAR);
			int month2 = cal.get(Calendar.MONTH) + 1;

			if (year2 < 1900)
				throw new BusinessRuntimeException("输入年份小于1900");

			if (year != year2 || month != month2) {
				throw new RuntimeException("error input date");
			}

			return toDate;
		} catch (ParseException e) {

			throw new RuntimeException(e);
		}
	}

	/**
	 * Checks if is date string.
	 * 
	 * @param dateStr
	 *            the date str
	 * @return true, if is date string
	 */
	public static boolean isDateString(String dateStr) {

		boolean ok = true;
		try {
			parseDate(dateStr);
		} catch (Exception e) {
			PssLogFactory.getErrorLog().error(PssDateUtils.class.getName(), e);
			ok = false;
		}
		return ok;
	}

	/**
	 * Parses the date after2000.
	 * 
	 * @param dateStr
	 *            the date str
	 * @return the date
	 */
	public static Date parseDateAfter2000(String dateStr) {
		Date date = parseDate(dateStr);

		if (null != date) {

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			int year = calendar.get(Calendar.YEAR);
			if (year < 100) {
				calendar.set(Calendar.YEAR, 2000 + year);
			}

			return calendar.getTime();
		} else {
			return date;
		}
	}

	/**
	 * Parses the full date. DEFAULT_DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";
	 * 
	 * @param dateStr
	 *            the date str
	 * @return the date
	 */
	public static Date parseDateToMinute(String dateStr) {

		return parse(dateStr, DATE_FORMAT_TO_MINUTE);
	}

	/**
	 * Parses the full date. DEFAULT_DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";
	 * 
	 * @param dateStr
	 *            the date str
	 * @return the date
	 */
	public static Date parseFullDate(String dateStr) {

		return parse(dateStr, DEFAULT_DATE_FORMAT_FULL);
	}

	/**
	 * Parses the.
	 * 
	 * @param dateStr
	 *            the date str
	 * @param pattern
	 *            the pattern
	 * @return the date
	 */
	public static Date parse(String dateStr, String pattern) {
		try {
			return DateUtils.parseDate(StringUtils.trim(dateStr), new String[] { pattern });
		} catch (ParseException e) {
			throw new BusinessRuntimeException(e);
		}
	}

	/**
	 * Parses the date with A/P marker.
	 *
	 * @param dateStr
	 *            the date str
	 * @param pattern
	 *            the pattern
	 * @return the date
	 */
	public static Date parseDateWithAPMarker(String dateStr, String pattern) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.US);
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			throw new BusinessRuntimeException(e);
		}
	}

	/**
	 * Parses the date with A/P marker.
	 *
	 * @param date the date
	 * @param pattern            the pattern
	 * @return the date
	 */
	public static String formatWithAPMarker(Date date, String pattern) {

		SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.US);
		return sdf.format(date);

	}

	/**
	 * Time abstract.
	 * 
	 * @param date
	 *            the date
	 * @return the string
	 */
	public static String timeAbstract(Date date) {
		return format(date, "HH:mm");
	}

	/**
	 * Format.
	 * 
	 * @param date
	 *            the date
	 * @return the string
	 */
	public static String format(Date date) {
		return format(date, "yyyyMMdd_HHmm");
	}

	/**
	 * Format short.
	 * 
	 * @param date
	 *            the date
	 * @return the string
	 */
	public static String formatShort(Date date) {
		return format(date, DEFAULT_DATE_FORMAT);
	}

	/**
	 * Format long.
	 * 
	 * @param date
	 *            the date
	 * @return the string
	 */
	public static String formatLong(Date date) {
		return format(date, "yyyy/MM/dd HH:mm");
	}

	/**
	 * Format full.
	 *
	 * @author shine
	 * @param date
	 *            the date
	 * @return the string
	 * @date Jan 14, 2014
	 */
	public static String formatFull(Date date) {
		return format(date, DEFAULT_DATE_FORMAT_FULL);
	}

	/**
	 * Format.
	 * 
	 * @param date
	 *            the date
	 * @param pattern
	 *            the pattern
	 * @return the string
	 */
	public static String format(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * Gets the finance year.
	 * 
	 * @param date
	 *            the date
	 * @return the finance year
	 */
	public static int getFinanceYear(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int month = calendar.get(Calendar.MONTH);
		if (month < Calendar.APRIL) {
			return calendar.get(Calendar.YEAR) - 1;
		} else {
			return calendar.get(Calendar.YEAR);
		}

	}

	/**
	 * Gets the week index.
	 * 
	 * @param date
	 *            the date
	 * @return the week index
	 */
	public static int getWeekIndex(Date date) {

		Calendar calendar = Calendar.getInstance();

		calendar.setFirstDayOfWeek(Calendar.MONDAY);

		calendar.setTime(date);

		return calendar.get(Calendar.WEEK_OF_YEAR);

	}

	/**
	 * Find day of week.
	 * 
	 * @param date
	 *            the date
	 * @param field
	 *            the field
	 * @param adjust
	 *            the adjust
	 * @return the date
	 */
	public static final Date findDayOfWeek(Date date, int field, int adjust) {

		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, adjust * Calendar.DAY_OF_WEEK);
		cal.set(Calendar.DAY_OF_WEEK, field);
		return cal.getTime();
	}

	/**
	 * Find day of week.
	 *
	 * @author shine
	 * @param date
	 *            the date
	 * @return the int
	 * @since 4.11.0
	 * @date 2013-2-28
	 */
	public static final int findDayOfWeek(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int tmp = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (tmp == 0) {
			tmp = 7;
		}
		return tmp;
	}

	/**
	 * Find day of week sunday first.
	 *
	 * @author Aaron
	 * @param date
	 *            the date
	 * @return the int
	 * @since 4.16.0
	 * @date 2013-5-25
	 */
	public static final int findDayOfWeekSundayFirst(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * Finds the day of week when first day is Monday.
	 *
	 * @author shine
	 * @param date
	 *            the date
	 * @return the int
	 * @since 4.12.0
	 * @date 2013-3-19
	 */
	public static final int findDayOfWeekFirstMon(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int day = cal.get(Calendar.DAY_OF_WEEK);

		if (day == Calendar.SUNDAY) {
			day = 7;
		} else {
			day = day - 1;
		}

		return day;
	}

	/**
	 * Find monday.
	 * 
	 * @param adjust
	 *            the adjust
	 * @return the date
	 */
	public static final Date findMonday(int adjust) {
		return findDayOfWeek(Calendar.getInstance().getTime(), Calendar.MONDAY, adjust);
	}

	/**
	 * Find Monday by date.
	 *
	 * @author shine
	 * @param date
	 *            the date
	 * @return the date
	 * @since 4.11.0
	 * @date 2013-2-28
	 */
	public static final Date findMonday(Date date) {
		if (date == null) {
			date = PssDateWrapper.instance().toDate();
		}
		return findDayOfWeek(date, Calendar.MONDAY, 0);
	}

	/**
	 * Find sunday.
	 * 
	 * @param adjust
	 *            the adjust
	 * @return the date
	 */
	public static final Date findSunday(int adjust) {
		return findDayOfWeek(Calendar.getInstance().getTime(), Calendar.SUNDAY, adjust);
	}

	/**
	 * Round date.
	 * 
	 * @param date
	 *            the date
	 * @return the date
	 */
	public static Date roundDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * Lead days.
	 *
	 * @param start
	 *            the start
	 * @param end
	 *            the end
	 * @return the int
	 */
	public static int leadDays(Date start, Date end) {
		long endLong = end.getTime();
		long startLong = start.getTime();
		long lead = endLong - startLong;
		double sk = (double) lead / (3600 * 24 * 1000);
		return (int) Math.floor(sk);

	}

	/** The Constant MAX_DATE. */
	public static final Date MAX_DATE = PssDateUtils.parseDate(_9999_12_31);

	/** The Constant MIN_DATE. */
	public static final Date MIN_DATE = PssDateUtils.parseDate(_1972_1_1);

	/**
	 * Finance year begin date.
	 *
	 * @param year
	 *            the year
	 * @return the date
	 */
	public static Date financeYearBeginDate(int year) {

		assert (year > 1990);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);

		calendar.set(Calendar.MONTH, Calendar.APRIL);

		return PssDateWrapper.instance(calendar.getTime()).toMonthBegin().toDate();
	}

	/**
	 * Finance year end date.
	 *
	 * @param year
	 *            the year
	 * @return the date
	 */
	public static Date financeYearEndDate(int year) {

		assert (year > 1990);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year + 1);

		calendar.set(Calendar.MONTH, Calendar.MARCH);

		return PssDateWrapper.instance(calendar.getTime()).toMonthEnd().toDate();
	}

	/**
	 * Checks if is satisfied by.
	 *
	 * @param expression
	 *            The crontab expression
	 * @param date
	 *            the date
	 * @return true, if is satisfied by
	 */
	public static boolean isSatisfiedBy(String expression, Date date) {

		String[] expressions = expression.split("\\|");

		try {
			boolean ok = false;

			for (String single : expressions) {
				if (StringUtils.isNotBlank(single)) {
					CronExpression cronExpression = new CronExpression(single);
					if (cronExpression.isSatisfiedBy(date)) {
						ok = true;
					}
				}
			}

			return ok;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * Gets the year.
	 *
	 * @param date
	 *            the date
	 * @return the year
	 */
	public static int getYear(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * Gets the month.
	 *
	 * @param date
	 *            the date
	 * @return the month
	 */
	public static int getMonth(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * Gets the hour.
	 *
	 * @author shine
	 * @param date
	 *            the date
	 * @return the hour
	 * @date Nov 6, 2013
	 */
	public static int getHour(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/** The one day milliseconds. */
	private static long ONE_DAY_MILLISECONDS = 1000 * 24 * 60 * 60;

	/**
	 * Gets the days between two.
	 *
	 * @author Evan 2013、4、26
	 * @param startDate
	 *            the start date
	 * @param endDate
	 *            the end date
	 * @return the days between two
	 */
	public static long getDaysBetweenTwo(Date startDate, Date endDate) {

		if (startDate == null || endDate == null) {
			throw new BusinessRuntimeException("日期不合法");
		}

		startDate = PssDateWrapper.instance(startDate).toOneDayBegin().toDate();
		endDate = PssDateWrapper.instance(endDate).toOneDayBegin().toDate();

		Long start = startDate.getTime();
		Long end = endDate.getTime();
		Long value = end - start;
		return value / ONE_DAY_MILLISECONDS;

	}

	/**
	 * Gets the days with decimal.
	 *
	 * @author shine
	 * @param startDate
	 *            the start date
	 * @param endDate
	 *            the end date
	 * @return the days with decimal
	 * @date Oct 16, 2013
	 */
	public static double getDaysWithDecimal(Date startDate, Date endDate) {

		if (startDate == null || endDate == null) {
			throw new BusinessRuntimeException("日期不合法");
		}

		double start = startDate.getTime();
		double end = endDate.getTime();
		double value = end - start;

		return value / ONE_DAY_MILLISECONDS;
	}

	/** The one minute milliseconds. */
	private static long ONE_MINUTE_MILLISECONDS = 1000 * 60;

	/**
	 * Gets the minutes between two.
	 *
	 * @author Evan 2013-6-4
	 * @param startDate
	 *            the start date
	 * @param endDate
	 *            the end date
	 * @return the minutes between two
	 */
	public static long getMinutesBetweenTwo(Date startDate, Date endDate) {

		if (startDate == null || endDate == null) {
			throw new BusinessRuntimeException("日期不合法");
		}

		Long start = startDate.getTime();
		Long end = endDate.getTime();
		Long value = end - start;

		return value / ONE_MINUTE_MILLISECONDS;

	}

	/**
	 * Compare date.
	 *
	 * @author Aaron
	 * @param day1
	 *            the day1
	 * @param day2
	 *            the day2
	 * @return true, if successful
	 * @date 2013-6-3
	 */
	public static boolean compareDate(Date day1, Date day2) {
		return day1.getTime() == day2.getTime();
	}

	/**
	 * *.
	 *
	 * @author Evan
	 * @param date
	 *            the date
	 * @return the days of month
	 * @date 2013-10-11
	 */
	public static long getDaysOfMonth(Date date) {

		if (date == null) {
			throw new BusinessRuntimeException("日期不合法");
		}

		Date startDate = PssDateWrapper.instance(date).toMonthBegin().toDate();
		Date endDate = PssDateWrapper.instance(date).toMonthEnd().add(1, DateType.Day).toDate();

		return getDaysBetweenTwo(startDate, endDate);
	}

	/**
	 * Max.
	 *
	 * @author Evan
	 * @param one
	 *            the one
	 * @param two
	 *            the two
	 * @return the date
	 * @date 2013-10-12
	 */
	public static Date max(Date one, Date two) {

		if (one == null || two == null) {
			throw new BusinessRuntimeException("日期不合法");
		}

		return one.compareTo(two) > 0 ? one : two;
	}

	/**
	 * *.
	 *
	 * @author Evan
	 * @param one
	 *            the one
	 * @param two
	 *            the two
	 * @return the date
	 * @date 2013-10-12
	 */
	public static Date min(Date one, Date two) {

		if (one == null || two == null) {
			throw new BusinessRuntimeException("日期不合法");
		}

		return one.compareTo(two) < 0 ? one : two;
	}
	
	public static Date addMonthsToDate(Date date,int months,int days){
		
		  Calendar c = Calendar.getInstance();
		  c.setTime(date);
		  c.add(Calendar.MONTH,months);
		  c.roll(Calendar.DATE, days);
		  return c.getTime();
	 }
	
	public static Date addYearsToDate(Date date,int year,int months,int days){
		
		  Calendar c = Calendar.getInstance();
		  c.setTime(date);
		  c.add(Calendar.YEAR, year);
		  c.add(Calendar.MONTH,months);
		  c.roll(Calendar.DATE, days);
		  return c.getTime();
	 }
	
	public static Date addYearsToDate(Date date,int year,int days){
		
		  Calendar c = Calendar.getInstance();
		  c.setTime(date);
		  c.add(Calendar.YEAR, year);//加一年
		  c.add(Calendar.DAY_OF_MONTH, days);//减一天
		  return c.getTime();
	 }
	
	/**
	 * 
	 * @param one
	 * @param two
	 * @param pattern
	 * @return
	 */
	public static int compareDateByPattern(Date one, Date two, String pattern){
		String oneStr = format(one, pattern);
		String twoStr = format(two, pattern);
		
		return oneStr.compareTo(twoStr);
	}

}
