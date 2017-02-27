package com.lu.util;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

public final class PssDateWrapper {

	/**
	 * 		Project Source Code
	 * @author William Shen
	 * @date 2011-3-14
	 */
	public static enum DateType {

		Day, Hour, Min, Sec, Week;

		public int getValue() {
			if (this == Day) {
				return DateTools.DAY;
			}
			if (this == Hour) {
				return DateTools.HOUR;
			}

			if (this == Min) {
				return DateTools.MIN;
			}

			if (this == Sec) {
				return DateTools.SECOND;
			}

			if (this == Week) {
				return DateTools.WEEK;
			}

			return -1;
		}

	}

	private Date date;

	/**
	 * static factory method to create a new PssDateWrapper instance
	 * 
	 * @param date
	 * @return
	 */
	public final static PssDateWrapper instance(Date date) {

		return new PssDateWrapper(date);
	}

	/**
	 * static factory method to create a new PssDateWrapper by current time
	 * 
	 * @return
	 */
	public final static PssDateWrapper instance() {

		return PssDateWrapper.instance((Calendar.getInstance().getTime()));

	}

	/**
	 * 
	 * @param date
	 */
	private PssDateWrapper(final Date date) {

		if (null == date) {

			this.date = new Date();

		} else {

			this.date = new Date(date.getTime());
		}

	}

	/**
	 * 
	 * @return
	 */
	public PssDateWrapper toNoon() {

		date = DateTools.getDateFromZero(date);
		date = DateTools.addHour(date, 12);
		return this;

	}

	/**
	 * to time 00:00 from initial time
	 * 
	 * @return
	 */
	public PssDateWrapper toMiddleNight() {

		date = DateTools.getDateFromZero(date);
		return this;
	}

	/**
	 * to time 8:30 AM from initial time
	 * 
	 * @return
	 */
	public PssDateWrapper toTime830() {
		date = DateTools.getDateFromZero(date);
		date = DateTools.addHour(date, 8);
		date = DateTools.addMinites(date, 30);
		return this;
	}

	/**
	 * to next day with the same time by inital time
	 * 
	 * @return
	 */
	public PssDateWrapper toNextDay() {

		return add(1, DateType.Day);
	}

	/**
	 * 
	 * @return
	 */
	public PssDateWrapper toNextFourWeeks() {
		return add(4, DateType.Week);
	}

	public PssDateWrapper toPreviousFourWeeks() {
		return add(-4, DateType.Week);
	}
	
	/**
	 * 
	 * @return
	 * @author shine
	 * @date Oct 29, 2013
	 */
	public PssDateWrapper toNextWeek() {
		return add(1, DateType.Week);
	}

	public PssDateWrapper toPreviousWeek() {
		return add(-1, DateType.Week);
	}

	/**
	 * 
	 * @return
	 */
	public PssDateWrapper toNextMonth() {
		date = DateUtils.addMonths(date, 1);
		return this;
	}

	/**
	 * to previous day with the same time by inital time
	 * 
	 * @return
	 */
	public PssDateWrapper toPreviousDay() {

		return add(-1, DateType.Day);
	}

	/**
	 * 
	 * @return
	 */
	public PssDateWrapper toPreviousMonth() {
		date = DateUtils.addMonths(date, -1);
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public PssDateWrapper toPreviousYear() {

		date = DateUtils.addYears(date, -1);
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public PssDateWrapper toYearBegin() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_YEAR, 1);
		date = calendar.getTime();
		toMiddleNight();
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public PssDateWrapper toYearEnd() {

		date = DateUtils.addYears(date, 1);
		toYearBegin().toPreviousDay().toLastPoint();
		return this;
	}

	/**
	 * to standard time
	 * 
	 * @return
	 */
	public PssDateWrapper toStandardTime() {

		final Date the830 = PssDateWrapper.instance(date).toTime830().toDate();
		if (date.after(the830)) {
			toNoon();
		} else {
			toPreviousDay().toNoon();
		}

		return this;
	}

	/**
	 * 
	 * @return
	 */
	public PssDateWrapper toBusinessDayBegin() {
		toTime830();
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public PssDateWrapper toBusinessDayEnd() {
		toMiddleNight().toNextDay().toTime830();
		Long sk = date.getTime();
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(sk - 1);
		date = cal.getTime();
		return this;
	}

	/**
	 * date and time calculation
	 * 
	 * @param value
	 * @param type
	 * @return
	 */
	public PssDateWrapper add(final int value, final PssDateWrapper.DateType type) {

		date = DateTools.getNewDate(date, value, type.getValue());

		return this;
	}

	/**
	 * 
	 * @return
	 */
	public PssDateWrapper toOneMonthBegin() {

		return toMonthBegin();
	}

	/**
	 * 
	 * @return
	 */
	public PssDateWrapper toOneDayBegin() {
		toMiddleNight();
		return this;
	}

	/**
	 * replace with {@link PssDateWrapper#toLastPoint()}
	 * 
	 * @return
	 */
	@Deprecated
	public PssDateWrapper toOneDayEnd() {

		add(1, DateType.Day);
		toMiddleNight();

		return this;
	}

	/**
	 * 
	 * @return
	 */
	public PssDateWrapper toLastPoint() {

		toOneDayEnd();
		date = new Date(date.getTime() - 1L);
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public PssDateWrapper toMonthBegin() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		date = calendar.getTime();
		toMiddleNight();
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public PssDateWrapper toMonthEnd() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int myEnd = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, myEnd);
		date = calendar.getTime();
		toLastPoint();
		return this;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public PssDateWrapper toWeekBegin() {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		date = calendar.getTime();
		toOneDayBegin();
		return this;

	}
	
	/**
	 * 
	 * @return
	 */
	public PssDateWrapper toWeekEnd(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		date = calendar.getTime();
		toLastPoint();
		return this;
	}

	/**
	 * get date
	 * 
	 * @see java.util.Date
	 * @return java.util.Date
	 */
	public Date toDate() {

		return this.date;
	}

	/**
	 * 
	 * @param dateStr
	 * @return
	 */
	public static PssDateWrapper instanceObject(Object ds) {

		try {

			String dateStr = StringUtils.trim(String.valueOf(ds));

			Date dt = PssDateUtils.parseDate(dateStr);
			return PssDateWrapper.instance(dt);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * @return
	 */
	public PssDateWrapper toFinanceYearBegin() {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		int month = calendar.get(Calendar.MONTH);

		if (month < Calendar.APRIL) {

			calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);
		}

		calendar.set(Calendar.MONTH, Calendar.APRIL);
		date = calendar.getTime();
		return toMonthBegin();
	}

	/**
	 * 
	 * @return
	 */
	public PssDateWrapper toFinanceYearEnd() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		int month = calendar.get(Calendar.MONTH);

		if (month >= Calendar.APRIL) {
			calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + 1);
		}

		calendar.set(Calendar.MONTH, Calendar.MARCH);
		date = calendar.getTime();
		return toMonthEnd();
	}

	/**
	 * Previous Month 15th 
	 * @return
	 */
	public PssDateWrapper toPreviousMonthMiddle() {
		Calendar calendar = Calendar.getInstance();
		date = DateUtils.addMonths(date, -1);
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 15);
		date = calendar.getTime();
		return this;
	}
	
	/**
	 * This Month 15th 
	 * @return
	 */
	public PssDateWrapper toThisMonthMiddle() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 15);
		date = calendar.getTime();
		return this;
	}
	
	/***
	 * 
	 * @param month
	 * @return
	 * @author Evan
	 * @date 2013-10-11
	 */
	public PssDateWrapper addMonths( int month){
		
		date = DateUtils.addMonths(date, month);
		return this;
	}
	
	
}

