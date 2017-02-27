package com.lu.util;

import java.util.Calendar;
import java.util.Date;

public class DateTools {

	public static final int WEEK = 4;

	public static final int DAY = 0;

	public static final int HOUR = 1;

	public static final int MIN = 2;

	public static final int SECOND = 3;

	/**
	 * 
	 * @param date
	 * @param hour
	 * @return
	 */
	public static Date addHour(Date date, int hour) {

		return getNewDate(date, hour, HOUR);
	}

	/**
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date addDay(Date date, int day) {
		return getNewDate(date, day, DAY);
	}

	/**
	 * 
	 * @param date
	 * @param min
	 * @return
	 */
	public static Date addMinites(Date date, int min) {

		return getNewDate(date, min, MIN);
	}

	/**
	 * 
	 * @param date
	 * @param sec
	 * @return
	 */
	public static Date addSeconds(Date date, int sec) {

		return getNewDate(date, sec, SECOND);
	}

	/**
	 * 
	 * @param date
	 * @param week
	 * @return
	 */
	public static Date addWeeks(Date date, int week) {

		return getNewDate(date, week, WEEK);
	}

	/**
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static Date getDateFromZero(Date date) {

		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(date);

		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar1.get(Calendar.YEAR), calendar1.get(Calendar.MONTH),
				calendar1.get(Calendar.DATE));
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();

	}

	/**
	 * 
	 * @param date
	 * @param n
	 * @param type
	 * @return
	 */
	protected static Date getNewDate(Date date, int n, int type) {
		Date mydate = date;

		if (null == date) {
			mydate = new Date();
		}

		long ms = mydate.getTime();
		ms += getMillSecond(type) * n;

		return new Date(ms);
	}

	private static long getMillSecond(int type) {
		if (type == HOUR) {
			return 3600 * 1000;
		}

		if (type == MIN) {
			return 60 * 1000;
		}

		if (type == SECOND) {
			return 1000;
		}

		if (type == DAY) {
			return 24 * 3600 * 1000;
		}

		if (type == WEEK) {

			return 24 * 3600 * 1000 * 7;
		}

		return 0;
	}
}
