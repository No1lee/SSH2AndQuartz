package com.rj.bd.utils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtils {

	// 默认显示日期的格式
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String YEAR_S_MONTH = "yyyy-MM";
	public static final String YEAR_MONTH = "yyyyMM";
	public static final String TIMEF_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// 默认显示日期时间毫秒格式
	public static final String MSEL_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
	// 默认显示简体中文日期的格式
	public static final String ZHCN_DATE_FORMAT = "yyyy年MM月dd日";
	// 默认显示简体中文日期时间的格式
	public static final String ZHCN_TIME_FORMAT = "yyyy年MM月dd日HH时mm分ss秒";
	// 默认显示简体中文日期时间毫秒格式
	public static final String ZHCN_MSEL_FORMAT = "yyyy年MM月dd日HH时mm分ss秒SSS毫秒";
	// 获取日期串格式
	public static final String DATE_STR_FORMAT = "yyyyMMdd";
	// 获取日期时间串格式
	public static final String TIME_STR_FORMAT = "yyyyMMddHHmmss";
	// 获取日期时间毫秒串格式
	public static final String MSEL_STR_FORMAT = "yyyyMMddHHmmssSSS";

	// 默认显示日期时间分钟格式
	public static final String MSEL_MIU_FORMAT = "yyyy-MM-dd HH:mm";

	public static final String MS_MIU_FORMAT = "yyyyMMddHH";

	private static DateFormat dateFormat = null;
	private static DateFormat dateTimeFormat = null;
	private static DateFormat zhcnDateFormat = null;
	private static DateFormat zhcnDateTimeFormat = null;
	private static DateFormat timeStrFormat = null;
	static {
		dateFormat = new SimpleDateFormat(DATE_FORMAT);
		dateTimeFormat = new SimpleDateFormat(TIMEF_FORMAT);
		zhcnDateFormat = new SimpleDateFormat(ZHCN_DATE_FORMAT);
		zhcnDateTimeFormat = new SimpleDateFormat(ZHCN_TIME_FORMAT);
		timeStrFormat = new SimpleDateFormat(TIME_STR_FORMAT);
	}

	/**
	 * 获取今天的日期，格式如：2006-11-09
	 * 
	 * @return String - 返回今天的日期
	 */
	public static String getToday() {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(now.getTime()));
	}

	/**
	 * 获取今天的日期，格式自定
	 * 
	 * @param pattern
	 *            - 设定显示格式
	 * @return String - 返回今天的日期
	 */
	public static String getToday(String pattern) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(pattern);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(now.getTime()));
	}

	/**
	 * 得到当前时间的前/后若干天的时间 例如当前时间2006-05-16 间隔天数30天，则返回2006-04-16
	 * 
	 * @param days
	 *            - 间隔天数
	 * @return String - 返回当时的时间
	 */
	public static String getInternalTimeByDay(int days) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		sdf.setTimeZone(TimeZone.getDefault());
		now.add(Calendar.DATE, days);
		return (sdf.format(now.getTime()));
	}

	/**
	 * 得到当前时间的前/后若干天的时间 例如当前时间2006-05-16 间隔天数30天，则返回2006-04-16
	 * 
	 * @param days
	 *            - 间隔天数
	 * @param pattern
	 *            - 设定显示格式
	 * @return String - 根据显示格式返回当时的时间
	 */
	public static String getInternalTimeByDay(int days, String pattern) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(pattern);
		sdf.setTimeZone(TimeZone.getDefault());
		now.add(Calendar.DATE, days);
		return (sdf.format(now.getTime()));
	}

	/**
	 * 得到当前时间的前/后若干月的时间 例如当前时间2006-05-16 间隔月数3月，则返回2006-02-16
	 * 
	 * @param months
	 *            - 间隔月数
	 * @return - 返回当时的时间
	 */
	public static String getInternalTimeByMonth(int months) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		sdf.setTimeZone(TimeZone.getDefault());
		now.add(Calendar.MONTH, months);
		return (sdf.format(now.getTime()));
	}

	/**
	 * 得到当前时间的前/后若干月的时间 例如当前时间2006-05-16 间隔月数3月，则返回2006-02-16
	 * 
	 * @param months
	 *            - 间隔月数
	 * @param pattern
	 *            - 设定显示格式
	 * @return - 根据显示格式返回当时的时间
	 */
	public static String getInternalTimeByMonth(int months, String pattern) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(pattern);
		sdf.setTimeZone(TimeZone.getDefault());
		now.add(Calendar.MONTH, months);
		return (sdf.format(now.getTime()));
	}

	/**
	 * 得到当前时间的前/后若干月的时间 例如当前时间2018-07-16 间隔1年，则返回2019-07-16
	 * 
	 * @param years
	 * @param pattern
	 * @return
	 */
	public static String getInternalTimeByYear(int years, String pattern) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(pattern);
		sdf.setTimeZone(TimeZone.getDefault());
		now.add(Calendar.YEAR, years);
		return (sdf.format(now.getTime()));
	}

	/**
	 * 得到当前时间的前/后若干月的时间 例如当前时间2018-07-16 间隔1.5年，则返回2021-01-16
	 * 
	 * @param years
	 * @param pattern
	 * @return
	 */
	public static String getInternalTimeByYm(int years, int months, String pattern) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(pattern);
		sdf.setTimeZone(TimeZone.getDefault());
		now.add(Calendar.YEAR, years);
		now.add(Calendar.MONTH, months);
		return (sdf.format(now.getTime()));
	}

	/**
	 * 得到中文日期
	 * 
	 * @param dateStr
	 *            - 日期串，格式为“yyyy-MM-dd”
	 * @return String - 返回中文日期，格式为“yyyy年MM月dd日”
	 */
	public static String chinaDate(String dateStr) {
		if (dateStr == null || dateStr.equals("null") || dateStr.equals("")) {
			return "";
		}
		java.util.Date d = getDate(dateStr, DATE_FORMAT);
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(ZHCN_DATE_FORMAT);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(d));
	}

	/**
	 * 得到中文日期,自定设置格式
	 * 
	 * @param dateStr
	 *            - 需要改变格式的时间串
	 * @param inPattern
	 *            - 时间串的格式
	 * @param outPattern
	 *            - 改为时间串的格式
	 * @return String - 根据outPattern格式返回时间
	 */
	public static String alterDateByDynamic(String dateStr, String inPattern, String outPattern) {
		if (dateStr == null || dateStr.equals("null") || dateStr.equals("")) {
			return "";
		}
		java.util.Date d = getDate(dateStr, inPattern);
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(outPattern);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(d));
	}

	/**
	 * 比较当前日期和指定日期 return boolean 如果当前日期在指定日期之后返回true否则返回flase
	 * 
	 * @param dateStr
	 *            指定日期
	 * @param pattern
	 *            指定日期的格式
	 * @return boolean
	 */
	public static boolean dateCompare(String dateStr, String pattern) {
		boolean bea = false;
		SimpleDateFormat sdf_d = new SimpleDateFormat(pattern);
		String isDate = sdf_d.format(new java.util.Date());
		java.util.Date date1;
		java.util.Date date0;
		try {
			date1 = sdf_d.parse(dateStr);
			date0 = sdf_d.parse(isDate);
			if (date0.after(date1)) {
				bea = true;
			}
		} catch (ParseException e) {
			bea = false;
		}
		return bea;
	}

	/**
	 * 比较指定两日期,如果dateStr1晚于dateStr2则return true;
	 * 
	 * @param dateStr1
	 *            指定日期
	 * @param dateStr2
	 *            指定日期
	 * @param pattern
	 *            指定日期的格式
	 * @return boolean
	 */
	public static boolean dateCompare(String dateStr1, String dateStr2, String pattern) {
		boolean bea = false;
		SimpleDateFormat sdf_d = new SimpleDateFormat(pattern);
		java.util.Date date1;
		java.util.Date date0;
		try {
			date1 = sdf_d.parse(dateStr1);
			date0 = sdf_d.parse(dateStr2);
			if (date0.after(date1)) {
				bea = true;
			}
		} catch (ParseException e) {
			bea = false;
		}
		return bea;
	}

	/**
	 * 设置间隔数后返回时间
	 * 
	 * @param type
	 *            间隔类型 秒或者天 秒的类型为s,天的类型为d
	 * @param 间隔数字
	 *            比如1秒或者一天
	 * @return String 返回时间格式为“yyyy-MM-dd HH:mm:ss”
	 */
	public static String dateAdd(String type, int i) {
		return dateAdd(type, i, TIMEF_FORMAT);
	}

	public static String dateAdd(String type, int i, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		String str = getToday(format);
		Calendar c = Calendar.getInstance(); // 当时的日期和时间
		if (type.equals("s")) {
			int s = c.get(Calendar.SECOND);
			s = s + i;
			c.set(Calendar.SECOND, s);
			str = df.format(c.getTime());
		} else if (type.equals("d")) {
			int d = c.get(Calendar.DAY_OF_MONTH); // 取出“日”数
			d = d + i;
			c.set(Calendar.DAY_OF_MONTH, d); // 将“日”数设置回去
			str = df.format(c.getTime());
		} else if (type.equals("h")) {
			int d = c.get(Calendar.HOUR_OF_DAY); // 取出“日”数
			d = d + i;
			c.set(Calendar.HOUR_OF_DAY, d); // 将“日”数设置回去
			str = df.format(c.getTime());
		} else if (type.equals("m")) {
			int d = c.get(Calendar.MINUTE); // 取出“分钟”数
			d = d + i;
			c.set(Calendar.MINUTE, d); // 将“日”数设置回去
			str = df.format(c.getTime());
		}
		return str;
	}

	public static String dateAdd(String date, String type, int i, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		String str = date;
		Calendar c = Calendar.getInstance(); // 当时的日期和时间
		c.setTime(getDate(date, format));
		if (type.equals("s")) {
			int s = c.get(Calendar.SECOND);
			s = s + i;
			c.set(Calendar.SECOND, s);
			str = df.format(c.getTime());
		} else if (type.equals("d")) {
			int d = c.get(Calendar.DAY_OF_MONTH); // 取出“日”数
			d = d + i;
			c.set(Calendar.DAY_OF_MONTH, d); // 将“日”数设置回去
			str = df.format(c.getTime());
		} else if (type.equals("h")) {
			int d = c.get(Calendar.HOUR_OF_DAY); // 取出“日”数
			d = d + i;
			c.set(Calendar.HOUR_OF_DAY, d); // 将“日”数设置回去
			str = df.format(c.getTime());
		} else if (type.equals("m")) {
			int d = c.get(Calendar.MINUTE); // 取出“分钟”数
			d = d + i;
			c.set(Calendar.MINUTE, d); // 将“日”数设置回去
			str = df.format(c.getTime());
		}
		return str;
	}

	/**
	 * 得到当前日期，如"2001-03-16".
	 *
	 * @version 1.0
	 */
	public static String curDate() {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		String DATE_FORMAT = "yyyy-MM-dd";
		// String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
		// String DATE_FORMAT = "yyyyMMdd";
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(now.getTime()));
	}

	/**
	 * 得到当前详细日期、时间，如"2001-03-16 20:34:20".
	 */
	public static String curTime() {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(TIMEF_FORMAT);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(now.getTime()));
	}

	/**
	 * 得到当前详细日期、时间，如"2001-03-16 20:34:20".
	 *
	 * @version 1.0
	 */
	public static String getTimeAfter(int n) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.add(Calendar.MINUTE, n);
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(TIMEF_FORMAT);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(now.getTime()));
	}

	/**
	 * 得到当前时间的前/后若干天的时间
	 * 
	 * @param day
	 *            - 间隔时间
	 * @return - 返回当时的时间 例如当前时间2003-05-16 间隔天数30天，则返回2003-04-16
	 */
	public static String getInternalTime(int days) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(TIMEF_FORMAT);
		sdf.setTimeZone(TimeZone.getDefault());
		now.add(Calendar.DATE, days);
		return (sdf.format(now.getTime()));
	}

	/**
	 * 得到当前时间的前/后若干天的时间
	 * 
	 * @param currentTime
	 *            - 当前时间
	 * @param iHour
	 *            - 间隔时间
	 * @return - 返回当时的时间 例如当前时间2003-05-16 08:10:10 间隔时间3小时，则返回2003-05-16
	 *         05:10:10
	 */
	public static String getTimeOut(String currentTime, int iHour) {
		String Time = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(TIMEF_FORMAT);
			java.util.Date result = sdf.parse(currentTime);
			Calendar cal = Calendar.getInstance();
			cal.setTime(result);
			cal.add(Calendar.HOUR, iHour);
			Time = sdf.format(cal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return Time;
	}

	/**
	 * 得到当前月底的前/后若干天的时间
	 * 
	 * @param day
	 *            - 间隔时间
	 * @return - 返回当时的时间
	 */
	public static String getInternalTimeByLastDay(int days) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		String DATE_FORMAT = "yyyy-MM-dd";
		// String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
		// String DATE_FORMAT = "yyyyMMdd";
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		sdf.setTimeZone(TimeZone.getDefault());
		int maxDay = now.getActualMaximum(Calendar.DAY_OF_MONTH);
		now.set(Calendar.DATE, maxDay);
		now.add(Calendar.DATE, days);
		return (sdf.format(now.getTime()));
	}

	/**
	 * 得到时间串
	 * 
	 * @param dateStr
	 *            String 时间字符串
	 * @param fmt
	 *            String 时间格式
	 * @return String 返回值
	 */
	public static String getDateStr(String dateStr, String fmt) {
		try {
			if (dateStr == null || dateStr.equals("")) {
				return "";
			}
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(fmt);
			java.util.Date d = sdf.parse(dateStr);
			String newDate = sdf.format(d);
			return newDate;
		} catch (Exception e) {
			// log.debug("\n" + e.getMessage());
		}
		return "";
	}

	/**
	 * 得到时间串
	 * 
	 * @param dateStr
	 *            String 时间字符串
	 * @param fmt
	 *            String 时间格式
	 * @return String 返回值
	 */
	public static java.util.Date getDate(String dateStr) {
		try {
			if (dateStr == null || dateStr.equals("")) {
				return null;
			}
			// Calendar now = Calendar.getInstance(TimeZone.getDefault());
			String DATE_FORMAT = "yyyyMMddHHmmss";
			// java.text.SimpleDateFormat sdf = new
			// java.text.SimpleDateFormat(DATE_FORMAT);
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
			// sdf.setTimeZone(TimeZone.getDefault());
			java.util.Date d = sdf.parse(dateStr);
			// java.text.DateFormat df =
			// java.text.DateFormat.getDateTimeInstance();
			// java.util.Date d= df.parse(dateStr);
			return d;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @return 得到当前时间目录例如 030524
	 */
	public static String getCurrTimeDir() {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		String DATE_FORMAT = "yyMMdd";
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(now.getTime()));
	}

	/**
	 * @return 得到上个月月份 如200505
	 */
	public static String getYesterM() {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.add(Calendar.MONTH, -2);
		String DATE_FORMAT = "yyyyMM";
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(now.getTime()));
	}

	/**
	 * @return 得到本年度年份 如2005
	 */
	public static String getYear() {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		// now.add(Calendar.MONTH,-1);
		String DATE_FORMAT = "yyyy";
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(now.getTime()));
	}

	/**
	 * @return 得到本月月份 如09
	 */
	public static String getMonth() {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		String DATE_FORMAT = "MM";
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(now.getTime()));
	}

	/**
	 * 得到下一个月分，包括年，例如： 2003－1 月份的上一个月份是2002－12
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static String[] getBeforeMonth(String year, String month) {
		String[] time = new String[2];
		if (month.equals("12")) {
			time[1] = "1";
			time[0] = String.valueOf(Integer.parseInt(year) + 1);
		} else {
			time[1] = String.valueOf(Integer.parseInt(month) + 1);
			time[0] = year;
		}
		return time;
	}

	/**
	 * 得到上一个月
	 * 
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @return String[] 0为年,1为月 TODO
	 */
	public static String[] beforeMonth(String year, String month) {
		String[] time = new String[2];
		if (month.equals("1")) {
			time[1] = "12";
			time[0] = String.valueOf(Integer.parseInt(year) - 1);
		} else {
			time[1] = String.valueOf(Integer.parseInt(month) - 1);
			time[0] = year;
		}
		return time;
	}

	/**
	 * 得到当前日期，按照页面日期控件格式，如"2001-3-16".
	 * 
	 * @return String TODO
	 */
	public static String curSingleNumDate() {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		String DATE_FORMAT = "yyyy-M-d";
		// String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
		// String DATE_FORMAT = "yyyyMMdd";
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(now.getTime()));
	}

	/**
	 * 取自当前日期后的第n天的日期
	 * 
	 * @param day
	 *            int 之后n天
	 * @return String
	 */
	public static String getDateAfter(int n) {
		String Time = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance(TimeZone.getDefault());
			cal.add(Calendar.DAY_OF_MONTH, n);
			Time = sdf.format(cal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return Time;
	}

	/**
	 * 得到半年前的日期
	 * 
	 * @return String
	 */
	public static String getHalfYearBeforeStr() {
		java.util.GregorianCalendar cal = new java.util.GregorianCalendar();
		/** @todo 取当前日期 */
		String month = "";
		int tMonth = cal.get(GregorianCalendar.MONTH) + 1;
		if (tMonth < 10) {
			month = "0" + tMonth;
		} else {
			month = "" + tMonth;
		}
		int tDay = cal.get(GregorianCalendar.DATE);
		String day = "";
		if (tDay < 10) {
			day = "0" + tDay;
		} else {
			day = "" + tDay;
		}
		// String endDate = "" + cal.get(GregorianCalendar.YEAR) + month + day;
		/** @todo 取半年前日期 */
		cal.add(GregorianCalendar.MONTH, -6);
		tMonth = cal.get(GregorianCalendar.MONTH) + 1;
		if (tMonth < 10) {
			month = "0" + tMonth;
		} else {
			month = "" + tMonth;
		}
		tDay = cal.get(GregorianCalendar.DATE);
		day = "";
		if (tDay < 10) {
			day = "0" + tDay;
		} else {
			day = "" + tDay;
		}
		String beginDate = "" + cal.get(GregorianCalendar.YEAR) + month + day;
		return beginDate;
	}

	/**
	 * 返回比当前日期晚几分钟的一个yyyy-MM-dd HH:mm:ss的日期串晚的分钟数可由输入参数minute控制
	 * 
	 * @param minute
	 * @return 返回延迟N分钟后的时间串
	 */
	public static String getCurrentNextMinute(int minute) {
		String chargeStartTime = "";
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(new java.util.Date());
			cal.add(Calendar.MINUTE, minute);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			chargeStartTime = sdf.format(cal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chargeStartTime;
	}

	/**
	 * 得到当前分钟
	 * 
	 * @return int
	 */
	public static int getCurMin() {
		java.util.Date date = new java.util.Date();
		java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("mm");
		int currentTime = Integer.parseInt(simpleDateFormat.format(date));
		return currentTime;
	}

	/**
	 * @param formatStr
	 * @return
	 */
	private static DateFormat getDateFormat(String formatStr) {
		if (formatStr.equalsIgnoreCase(DATE_FORMAT)) {
			return dateFormat;
		} else if (formatStr.equalsIgnoreCase(TIMEF_FORMAT)) {
			return dateTimeFormat;
		} else if (formatStr.equalsIgnoreCase(ZHCN_DATE_FORMAT)) {
			return zhcnDateFormat;
		} else if (formatStr.equalsIgnoreCase(ZHCN_TIME_FORMAT)) {
			return zhcnDateTimeFormat;
		} else {
			return new SimpleDateFormat(formatStr);
		}
	}

	/**
	 * 按照默认formatStr的格式，转化dateTimeStr为Date类型 dateTimeStr必须是formatStr的形式
	 * 
	 * @param dateTimeStr
	 * @param formatStr
	 * @return
	 */
	public static Date getDate(String dateTimeStr, String formatStr) {
		try {
			if (dateTimeStr == null || dateTimeStr.equals("")) {
				return null;
			}
			DateFormat sdf = getDateFormat(formatStr);
			java.util.Date d = sdf.parse(dateTimeStr);
			return d;
		} catch (ParseException e) {
			// throw new LangException(e);
		}
		return null;
	}

	/**
	 * 将Date转换成字符串“yyyy-mm-dd hh:mm:ss”的字符串
	 * 
	 * @param date
	 *            日期
	 * @return String 字符串 TODO
	 */
	public static String dateToDateString(Date date) {
		return dateToDateString(date, TIMEF_FORMAT);
	}

	/**
	 * 将Date转换成formatStr格式的字符串
	 * 
	 * @param date
	 * @param formatStr
	 * @return
	 */
	public static String dateToDateString(Date date, String formatStr) {
		DateFormat df = getDateFormat(formatStr);
		return df.format(date);
	}

	/**
	 * 返回一个yyyy-MM-dd HH:mm:ss 形式的日期时间字符串中的HH:mm:ss
	 * 
	 * @param dateTime
	 * @return
	 */
	public static String getTimeString(String dateTime) {
		return getTimeString(dateTime, TIMEF_FORMAT);
	}

	/**
	 * 返回一个formatStr格式的日期时间字符串中的HH:mm:ss
	 * 
	 * @param dateTime
	 * @param formatStr
	 * @return
	 */
	public static String getTimeString(String dateTime, String formatStr) {
		Date d = getDate(dateTime, formatStr);
		String s = dateToDateString(d);
		return s.substring(TIMEF_FORMAT.indexOf('H'));
	}

	/**
	 * 获取当前日期yyyy-MM-dd的形式
	 * 
	 * @return
	 */
	public static String getCurDate() {
		return dateToDateString(new Date(), DATE_FORMAT);
	}

	/**
	 * 获取当前日期yyyy年MM月dd日的形式
	 * 
	 * @return
	 */
	public static String getCurZhCNDate() {
		return dateToDateString(new Date(), ZHCN_DATE_FORMAT);
	}

	/**
	 * 获取当前日期时间yyyy-MM-dd HH:mm:ss的形式
	 * 
	 * @return
	 */
	public static String getCurDateTime() {
		return dateToDateString(new Date(), TIMEF_FORMAT);
	}

	/**
	 * 获取当前日期时间yyyy年MM月dd日HH时mm分ss秒的形式
	 * 
	 * @return
	 */
	public static String getCurZhCNDateTime() {
		return dateToDateString(new Date(), ZHCN_TIME_FORMAT);
	}

	/**
	 * 获取日期d的days天后的一个Date
	 * 
	 * @param d
	 * @param days
	 * @return Date
	 */
	public static Date getInternalDateByDay(Date d, int days) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		now.add(Calendar.DATE, days);
		return now.getTime();
	}

	/**
	 * 获取日期d的months月后的一个Date
	 * 
	 * @param d
	 * @param months
	 * @return Date
	 */
	public static Date getInternalDateByMon(Date d, int months) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		now.add(Calendar.MONTH, months);
		return now.getTime();
	}

	/**
	 * 获取日期d的years年后的一个Date
	 * 
	 * @param d
	 * @param years
	 * @return Date
	 */
	public static Date getInternalDateByYear(Date d, int years) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		now.add(Calendar.YEAR, years);
		return now.getTime();
	}

	/**
	 * 获取日期d的sec秒后的一个Date
	 * 
	 * @param d
	 * @param sec
	 * @return Date
	 */
	public static Date getInternalDateBySec(Date d, int sec) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		now.add(Calendar.SECOND, sec);
		return now.getTime();
	}

	/**
	 * 获取日期d的min分后的一个Date
	 * 
	 * @param d
	 * @param min
	 * @return Date
	 */
	public static Date getInternalDateByMin(Date d, int min) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		now.add(Calendar.MINUTE, min);
		return now.getTime();
	}

	/**
	 * 获取日期d的hours小时后的一个Date
	 * 
	 * @param d
	 * @param hours
	 * @return Date
	 */
	public static Date getInternalDateByHour(Date d, int hours) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		now.add(Calendar.HOUR_OF_DAY, hours);
		return now.getTime();
	}

	/**
	 * 根据一个日期字符串，返回日期格式，目前支持4种 如果都不是，则返回null
	 * 
	 * @param DateString
	 * @return 返回日期格式，目前支持4种
	 */
	public static String getFormateStr(String DateString) {
		String patternStr1 = "[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}"; // "yyyy-MM-dd"
		String patternStr2 = "[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}\\s[0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}"; // "yyyy-MM-dd
																									// HH:mm:ss";
		String patternStr3 = "[0-9]{4}年[0-9]{1,2}月[0-9]{1,2}日"; // "yyyy年MM月dd日"
		String patternStr4 = "[0-9]{4}年[0-9]{1,2}月[0-9]{1,2}日[0-9]{1,2}时[0-9]{1,2}分[0-9]{1,2}秒"; // "yyyy年MM月dd日HH时mm分ss秒"
		Pattern p = Pattern.compile(patternStr1);
		Matcher m = p.matcher(DateString);
		boolean b = m.matches();
		if (b) {
			return DATE_FORMAT;
		}
		p = Pattern.compile(patternStr2);
		m = p.matcher(DateString);
		b = m.matches();
		if (b) {
			return TIMEF_FORMAT;
		}
		p = Pattern.compile(patternStr3);
		m = p.matcher(DateString);
		b = m.matches();
		if (b) {
			return ZHCN_DATE_FORMAT;
		}
		p = Pattern.compile(patternStr4);
		m = p.matcher(DateString);
		b = m.matches();
		if (b) {
			return ZHCN_TIME_FORMAT;
		}
		return null;
	}

	/**
	 * 将一个"yyyy-MM-dd HH:mm:ss"字符串，转换成"yyyy年MM月dd日HH时mm分ss秒"的字符串
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String getZhCNDateTime(String dateStr) {
		Date d = getDate(dateStr);
		return dateToDateString(d, ZHCN_TIME_FORMAT);
	}

	/**
	 * 将一个"yyyy-MM-dd"字符串，转换成"yyyy年MM月dd日"的字符串
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String getZhCNDate(String dateStr) {
		Date d = getDate(dateStr, DATE_FORMAT);
		return dateToDateString(d, ZHCN_DATE_FORMAT);
	}

	/**
	 * 将dateStr从fmtFrom转换到fmtTo的格式
	 * 
	 * @param dateStr
	 * @param fmtFrom
	 * @param fmtTo
	 * @return
	 */
	public static String getDateStr(String dateStr, String fmtFrom, String fmtTo) {
		Date d = getDate(dateStr, fmtFrom);
		return dateToDateString(d, fmtTo);
	}

	/**
	 * 将小时数换算成返回以毫秒为单位的时间
	 * 
	 * @param hours
	 * @return
	 */
	public static long getMicroSec(BigDecimal hours) {
		BigDecimal bd;
		bd = hours.multiply(new BigDecimal(3600 * 1000));
		return bd.longValue();
	}

	/**
	 * 获取Date中的分钟
	 * 
	 * @param d
	 * @return
	 */
	public static int getMin(Date d) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		return now.get(Calendar.MINUTE);
	}

	/**
	 * 获取xxxx-xx-xx的日
	 * 
	 * @param d
	 * @return
	 */
	public static int getDay(Date d) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		return now.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取月份，1-12月
	 * 
	 * @param d
	 * @return
	 */
	public static int getMonth(Date d) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		return now.get(Calendar.MONTH) + 1;
	}

	/**
	 * 获取19xx,20xx形式的年
	 * 
	 * @param d
	 * @return
	 */
	public static int getYear(Date d) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		return now.get(Calendar.YEAR);
	}

	/**
	 * 得到d的上个月的年份+月份,如200505
	 * 
	 * @return
	 */
	public static String getYearMonthOfLastMon(Date d) {
		Date newdate = getInternalDateByMon(d, -1);
		String year = String.valueOf(getYear(newdate));
		String month = String.valueOf(getMonth(newdate));
		return year + month;
	}

	/**
	 * 得到当前日期的年和月如200509
	 * 
	 * @return String
	 */
	public static String getCurYearMonth() {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		String DATE_FORMAT = "yyyyMM";
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(now.getTime()));
	}

	/**
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getNextMonth(String year, String month) {
		String datestr = year + "-" + month + "-01";
		Date date = getDate(datestr, DATE_FORMAT);
		return getInternalDateByMon(date, 1);
	}

	/**
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getLastMonth(String year, String month) {
		String datestr = year + "-" + month + "-01";
		Date date = getDate(datestr, DATE_FORMAT);
		return getInternalDateByMon(date, -1);
	}

	/**
	 * 得到日期d，按照页面日期控件格式，如"2001-3-16"
	 * 
	 * @param d
	 * @return
	 */
	public static String getSingleNumDate(Date d) {
		return dateToDateString(d, DATE_FORMAT);
	}

	/**
	 * 得到d半年前的日期,"yyyy-MM-dd"
	 * 
	 * @param d
	 * @return
	 */
	public static String getHalfYearBeforeStr(Date d) {
		return dateToDateString(getInternalDateByMon(d, -6), DATE_FORMAT);
	}

	/**
	 * 得到当前日期D的月底的前/后若干天的时间,<0表示之前，>0表示之后
	 * 
	 * @param d
	 * @param days
	 * @return
	 */
	public static String getInternalDateByLastDay(Date d, int days) {
		return dateToDateString(getInternalDateByDay(d, days), DATE_FORMAT);
	}

	public static java.sql.Date getSqlDate(String dateTimeStr) {
		// DateUtils.getTIME_STR_FORMAT
		java.sql.Date d = new java.sql.Date(DateUtils.getDate(dateTimeStr, DateUtils.TIME_STR_FORMAT).getTime());
		// d.setHours(Integer.parseInt(dateTimeStr.substring(8,10)));
		// d.setMinutes(Integer.parseInt(dateTimeStr.substring(10,12)));
		// d.setSeconds(Integer.parseInt(dateTimeStr.substring(12,14)));
		return d;
	}

	/**
	 * 获取上一个月
	 * 
	 * @param ym
	 *            2013-09
	 * @param month
	 * @param pattern
	 * @return
	 */
	public static String getLastMonth(String ym, int month, String pattern) {
		Date date = getDate(ym, YEAR_S_MONTH);
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(date);
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(pattern);
		sdf.setTimeZone(TimeZone.getDefault());
		now.add(Calendar.MONTH, month);
		return sdf.format(now.getTime());
	}

	/**
	 * 返回当月最后一天的日期
	 */
	public static String getLastDayOfMonth(Date date) {
		Calendar calendar = convert(date);
		calendar.set(Calendar.DATE, calendar.getMaximum(Calendar.DATE));
		DateFormat format = new SimpleDateFormat(DATE_FORMAT);
		return format.format(calendar.getTime());
	}

	/**
	 * 将日期转换为日历
	 * 
	 * @param date
	 *            日期
	 * @return 日历
	 */
	private static Calendar convert(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	/**
	 * date2 - date1 = 多少天
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getDiffersDays(String date1, String date2) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			Date d1 = sdf.parse(date1);
			Date d2 = sdf.parse(date2);
			long daysBetween = (d2.getTime() - d1.getTime() + 1000000) / (3600 * 24 * 1000);
			return daysBetween;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	/**
	 * 计算两个日期之间相差的天数 (date2 - date1)
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int daysBetween(Date date1, Date date2) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		long time1 = cal.getTimeInMillis();
		cal.setTime(date2);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 计算两个日期相差天数
	 * 
	 * @param smdate
	 * @param bdate
	 * @return
	 * @throws ParseException
	 */
	public static int daysBetween(String smdate, String bdate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(sdf.parse(smdate));
			long time1 = cal.getTimeInMillis();
			cal.setTime(sdf.parse(bdate));
			long time2 = cal.getTimeInMillis();
			long between_days = (time2 - time1) / (1000 * 3600 * 24);
			return Integer.parseInt(String.valueOf(between_days));
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	/**
	 * 计算两个时间相差的月份
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static int monthBetween(String start, String end) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(sdf.parse(start));
			long time1 = cal.getTimeInMillis();
			cal.setTime(sdf.parse(end));
			long time2 = cal.getTimeInMillis();
			long between_days = (time2 - time1) / (1000 * 3600 * 24);
			return Integer.parseInt(String.valueOf(between_days));
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	/**
	 * 根据给定日期Date返回星期几
	 * 
	 * @param date
	 * @return
	 */
	public static String getWeekOfDate(Date date) {
		String[] weekOfDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar calendar = Calendar.getInstance();

		if (date != null) {
			calendar.setTime(date);
		}

		int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;

		if (w < 0) {
			w = 0;
		}

		return weekOfDays[w];
	}

	/**
	 * 根据给定日期(字符串形式)返回星期几
	 * 
	 * @param date
	 * @return
	 */
	public static String getWeekOfDate(String date) {
		Date d = getDate(date, "yy-MM-dd");
		return getWeekOfDate(d);
	}

	/**
	 * 返回指定日期的下一个日期
	 * 
	 * @param d
	 * @return
	 */
	public static Date getNextDate(Date d) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		now.add(Calendar.DAY_OF_MONTH, 1);
		return now.getTime();
	}

	/**
	 * 返回指定日期的下一个日期
	 * 
	 * @param d
	 * @param dateFomat
	 * @return
	 */
	public static String getNextDate(String d, String dateFomat) {
		Date date = getNextDate(getDate(d, dateFomat));
		DateFormat df = new SimpleDateFormat(dateFomat);
		return df.format(date);
	}

	/**
	 * 获取Date中的小时
	 * 
	 * @param d
	 * @return
	 */
	public static int getHour(Date d) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		return now.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 给定时间，返回小时
	 * 
	 * @param d
	 * @return
	 */
	public static int getHour(String d) {
		return getHour(getDate(d, "hh:mm:ss"));
	}

	public static int getMin(String d) {
		return getMin(getDate(d, "hh:mm:ss"));
	}

	/**
	 * 按指定格式返回日期字符串
	 * 
	 * @Title: formatDate
	 * @param pattern
	 * @return
	 * @return: String
	 */
	public static String formatDate(String pattern) {
		return formatDate(new Date(), pattern);
	}

	/**
	 * @Title: formatDate
	 * @param date
	 * @param pattern
	 * @return
	 * @return: String
	 */
	public static String formatDate(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * 格式化输出日期
	 * 
	 * @param date
	 *            日期
	 * @param format
	 *            格式
	 * @return 返回字符型日期
	 */
	public static String format(java.util.Date date, String format) {
		String result = "";
		try {
			if (date != null) {
				java.text.DateFormat df = new java.text.SimpleDateFormat(format);
				result = df.format(date);
			}
		} catch (Exception e) {
		}
		return result;
	}

	/**
	 * @Title: getDateByStr
	 * @param date
	 * @return
	 * @return: Date
	 */
	public static Date getDateByStr(String date) {
		return getDateByStr(date, TIMEF_FORMAT);
	}

	/**
	 * @Title: getDateByStr
	 * @param date
	 * @param pattern
	 * @return
	 * @return: Date
	 */
	public static Date getDateByStr(String date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date();
	}

	/**
	 * 补齐不足长度
	 * 
	 * @param length
	 *            长度
	 * @param number
	 *            数字
	 * @return
	 */
	public static String lpad(int length, Long number) {
		String f = "%0" + length + "d";
		// 超过的话 就截取
		String nuber_str = number + "";
		if (nuber_str.length() > length) {
			return nuber_str = nuber_str.substring(nuber_str.length() - length);
		}
		return String.format(f, number);
	}

	/**
	 * 计算两个日期相差 毫秒数
	 * 
	 * @param smdate
	 * @param bdate
	 * @return
	 * @throws ParseException
	 */
	public static int millBetween(String smdate, String bdate) {
		SimpleDateFormat sdf = new SimpleDateFormat(MSEL_FORMAT);
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(sdf.parse(smdate));
			long time1 = cal.getTimeInMillis();
			cal.setTime(sdf.parse(bdate));
			long time2 = cal.getTimeInMillis();
			long between_days = (time2 - time1);
			return Integer.parseInt(String.valueOf(between_days));
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	/**
	 * 签到日考勤统计 获取当前时间的时分秒
	 * 
	 * @author:黄泽亮
	 * @return
	 */
	public static String getEveryMinute() {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");// 时:分:秒
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(now.getTime()));
	}

	/**
	 * 获取小数点后一位
	 * 
	 * @author: 黄泽亮
	 * @param minutes
	 * @return
	 */
	public static String getPointOne(long minutes) {
		double s = minutes / 60d;
		double newTime = (double) (Math.floor(s * 10d) / 10);
		return newTime + "";
	}

	/**
	 * 获取当月工作日天数
	 * 
	 * @author: 黄泽亮
	 * @return
	 */
	public static int getWorkingDay() {
		String input = dateToDateString(new Date(), "yyyy-MM");
		int count = 0;
		int month = Integer.parseInt(input.substring(5, 7));
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.parseInt(input.substring(0, 4)));
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DATE, 1);

		while (cal.get(Calendar.MONTH) < month) {
			int day = cal.get(Calendar.DAY_OF_WEEK);

			if (!(day == Calendar.SUNDAY || day == Calendar.SATURDAY)) {
				count++;
			}
			cal.add(Calendar.DATE, 1);
		}
		return count;
	}

	/**
	 * 获取某个月的法定工作日
	 * 
	 * @author: 黄泽亮
	 * @param dateStr
	 * @return
	 */
	public static int getMonthWorkingDay(String dateStr) {
		int count = 0;
		int month = Integer.parseInt(dateStr.substring(5, 7));
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.parseInt(dateStr.substring(0, 4)));
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DATE, 1);

		while (cal.get(Calendar.MONTH) < month) {
			int day = cal.get(Calendar.DAY_OF_WEEK);

			if (!(day == Calendar.SUNDAY || day == Calendar.SATURDAY)) {
				count++;
			}
			cal.add(Calendar.DATE, 1);
			if (month == 12 && cal.get(Calendar.MONTH) == 0)
				break;
		}
		return count;
	}

	/**
	 * 获取当月第一天 返回格式例 2016-06-01
	 * 
	 * @author: 黄泽亮
	 * @param date
	 * @return
	 */
	public static String getFirstDayOfMonth(Date date) {
		Calendar calendar = convert(date);
		calendar.set(Calendar.DATE, calendar.getMinimum(Calendar.DATE));
		DateFormat format = new SimpleDateFormat(DATE_FORMAT);
		return format.format(calendar.getTime());
	}

	/**
	 * 返回当月最后一天的日期 eg: 2016-06-30
	 * 
	 * @author: 黄泽亮
	 * @param date
	 * @return
	 */
	public static String getActualLastDayOfMonth(Date date) {
		Calendar calendar = convert(date);
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
		DateFormat format = new SimpleDateFormat(DATE_FORMAT);
		return format.format(calendar.getTime());
	}

	public static String getFirstDayOfWeek(Date date) {
		Calendar calendar = convert(date);
		calendar.setFirstDayOfWeek(Calendar.SUNDAY);
		calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
		DateFormat format = new SimpleDateFormat(DATE_FORMAT);
		return format.format(calendar.getTime());
	}

	public static String getLastDayOfWeek(Date date) {
		Calendar calendar = convert(date);
		calendar.setFirstDayOfWeek(Calendar.SUNDAY);
		calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek() + 6);
		DateFormat format = new SimpleDateFormat(DATE_FORMAT);
		return format.format(calendar.getTime());
	}

	/**
	 * 获取当天是 年+第几周
	 * 
	 * @author: 黄泽亮
	 * @return
	 */
	public static String getWeekOfYear() {
		Calendar c = Calendar.getInstance();
		String y = c.get(Calendar.YEAR) + "";
		String wk = c.get(Calendar.WEEK_OF_YEAR) + "";
		return y + wk;// 年+第几周
	}

	/**
	 * 得到某一天的该星期的第一日
	 * 
	 * @author: 黄泽亮
	 * @param date
	 * @param firstDayOfWeek
	 * @return
	 */
	public static Date getFirstDayOfWeek(Date date, int firstDayOfWeek) {
		Calendar cal = Calendar.getInstance();
		if (date != null)
			cal.setTime(date);
		cal.setFirstDayOfWeek(firstDayOfWeek);// 设置一星期的第一天是哪一天
		cal.set(Calendar.DAY_OF_WEEK, firstDayOfWeek);// 指示一个星期中的某天
		cal.set(Calendar.HOUR_OF_DAY, 0);// 指示一天中的小时。HOUR_OF_DAY 用于 24
											// 小时制时钟。例如，在 10:04:15.250 PM
											// 这一时刻，HOUR_OF_DAY 为 22。
		cal.set(Calendar.MINUTE, 0);// 指示一小时中的分钟。例如，在 10:04:15.250 PM
									// 这一时刻，MINUTE 为 4。
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 获取上周一时间
	 */
	public static Date lastMonday() {
		Calendar calendar = Calendar.getInstance();
		while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
			calendar.add(Calendar.DAY_OF_WEEK, -1);
		}
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		int offset = 1 - dayOfWeek;
		calendar.add(Calendar.DATE, offset - 7);
		return getFirstDayOfWeek(calendar.getTime(), 2);
	}

	/**
	 * 上周是一年中的第几周
	 * 
	 * @author: 黄泽亮
	 * @return
	 * @throws ParseException
	 */
	public static String getLastWeekOfYear() throws ParseException {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		cal.setTime(format.parse(format.format(lastMonday())));
		String y = cal.get(Calendar.YEAR) + "";
		String week = cal.get(Calendar.WEEK_OF_YEAR) + "";
		return y + week;
	}

	/**
	 * 获取下个月第一天
	 * 
	 * @return
	 */
	public static Date nextMonthFirstDay() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, c.get(Calendar.MONTH) + 1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}

	/**
	 * 获取每个月工作日列表
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static List<String> getWorking(int year, int month) {
		List<String> dates = new ArrayList<String>();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DATE, 1);

		while (cal.get(Calendar.YEAR) == year && cal.get(Calendar.MONTH) < month) {
			int day = cal.get(Calendar.DAY_OF_WEEK);
			if (!(day == Calendar.SUNDAY || day == Calendar.SATURDAY)) {
				dates.add(dateToDateString((Date) cal.getTime().clone(), DATE_FORMAT));
			}
			cal.add(Calendar.DATE, 1);
		}
		return dates;
	}

	/**
	 * 获取年份
	 * 
	 * @author: 黄泽亮 输入参数格式： 2016-07
	 * @param dateStr
	 * @return
	 */
	public static int getYear(String dateStr) {
		int year = Integer.parseInt(dateStr.substring(0, 4));
		return year;
	}

	/**
	 * 获取月份
	 * 
	 * @author: 黄泽亮 输入参数格式： 2016-07
	 * @param dateStr
	 * @return
	 */
	public static int getMonth(String dateStr) {
		int month = Integer.parseInt(dateStr.substring(5, 7));
		return month;
	}

	/**
	 * 获取下个月的第一天的零时零分零秒
	 * 
	 * @param month
	 *            向后推迟月的个数
	 * @return
	 */
	public static Date getFirstDayOfNextMonth(int month) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, c.get(Calendar.MONTH) + month);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	/**
	 * 获得当月凌晨0点0分0秒
	 * 
	 * @return
	 */
	public static Date getMonthZero() {
		Calendar startTime = Calendar.getInstance();
		startTime.set(Calendar.DAY_OF_MONTH, 1);
		startTime.set(Calendar.HOUR_OF_DAY, 0);
		startTime.set(Calendar.MINUTE, 0);
		startTime.set(Calendar.SECOND, 0);
		startTime.set(Calendar.MILLISECOND, 0);
		Date start = startTime.getTime();
		return start;
	}

	/**
	 * 获得当月凌晨5点0分0秒
	 * 
	 * @return
	 */
	public static Date getMonthFive() {
		Calendar startTime = Calendar.getInstance();
		startTime.set(Calendar.DAY_OF_MONTH, 1);
		startTime.set(Calendar.HOUR_OF_DAY, 5);
		startTime.set(Calendar.MINUTE, 0);
		startTime.set(Calendar.SECOND, 0);
		startTime.set(Calendar.MILLISECOND, 0);
		Date start = startTime.getTime();
		return start;
	}

	/**
	 * 获得当前月末最后倒数第三天
	 * 
	 * @return
	 */
	public static Date getLastThree() {
		Calendar cale = Calendar.getInstance();
		cale.add(Calendar.MONTH, 1); // 设置为下个月1号
		cale.set(Calendar.DAY_OF_MONTH, -2);// 设置为倒数第三天
		cale.set(Calendar.HOUR_OF_DAY, 0);
		cale.set(Calendar.MINUTE, 0);
		cale.set(Calendar.SECOND, 0);
		cale.set(Calendar.MILLISECOND, 0);
		Date start = cale.getTime();
		return start;
	}

	/**
	 * 
	 * @return
	 */
	public static Date getMonthLast() {
		Calendar cale = Calendar.getInstance();
		cale.add(Calendar.MONTH, 1);
		cale.set(Calendar.DAY_OF_MONTH, 0);// 设置为1号,当前日期既为本月第一天
		cale.set(Calendar.HOUR_OF_DAY, 0);
		cale.set(Calendar.MINUTE, 0);
		cale.set(Calendar.SECOND, 0);
		cale.set(Calendar.MILLISECOND, 0);
		Date start = cale.getTime();
		return start;
	}

	/**
	 * //获取当前月最后一天的最后一秒
	 * 
	 * @return
	 */
	public static Date getMonthLastDay() {
		Calendar calEnd = Calendar.getInstance();// 获取当前日期
		calEnd.add(Calendar.MONTH, 1);
		calEnd.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		calEnd.set(Calendar.HOUR_OF_DAY, 0);
		calEnd.set(Calendar.MINUTE, 0);
		calEnd.set(Calendar.SECOND, -1);
		Date endTime = calEnd.getTime();
		return endTime;
	}

	/**
	 * 获得上月27号0时00分0秒
	 * 
	 * @return
	 */
	public static Date getLastMonth27() {
		Calendar caleStart = Calendar.getInstance();
		caleStart.add(Calendar.MONTH, -1);
		caleStart.set(Calendar.DAY_OF_MONTH, 27);// 设置为27号,当前日期既为上月的27号
		caleStart.set(Calendar.HOUR_OF_DAY, 0);
		caleStart.set(Calendar.MINUTE, 0);
		caleStart.set(Calendar.SECOND, 0);
		return caleStart.getTime();
	}

	/**
	 * 获得本月27号0时00分0秒
	 * 
	 * @return
	 */
	public static Date getMonth27() {
		Calendar calEnd = Calendar.getInstance();// 获取当前日期
		calEnd.set(Calendar.DAY_OF_MONTH, 27);// 设置为27号,当前日期既为本月27号
		calEnd.set(Calendar.HOUR_OF_DAY, 0);
		calEnd.set(Calendar.MINUTE, 0);
		calEnd.set(Calendar.SECOND, -1);

		return calEnd.getTime();
	}

	public static Date getUnicomSettleMentDayOfMonth(int month) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, c.get(Calendar.MONTH) + month - 1);
		c.set(Calendar.DAY_OF_MONTH, 27);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	public static Date getDateForInvalid() {
		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DAY_OF_MONTH);
		if (day >= 27) {
			c.add(Calendar.MONTH, 1);
		} else {
			c.add(Calendar.MONTH, 0);
		}
		c.set(Calendar.DAY_OF_MONTH, 27);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	public static Date getTodayStart() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	public static Date getTodayEnd() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	/* 获得当前时间的一天之前 */
	public static Date getOneDayBefore() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -1);
		return c.getTime();
	}
	/* 获得当前时间的一天之后 */
	public static String getOneDayAfter() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, +1);
		Date nextdate = c.getTime();
		return sdf.format(nextdate);
	}
	/*
	 * 获得月底最后一天最后一秒
	 */
	public static Date getMonthEnd() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, -1);
		return cal.getTime();
	}

	/**
	 * 日期加一天
	 * 
	 * @param day
	 * @return
	 */
	public static String getNextDay(String day) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse(day);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, 1);
			date = cal.getTime();
			return sdf.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 日期加一个月
	 * 
	 * @param day
	 * @return
	 */
	public static String getNextMonth(String day) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse(day);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.MONTH, 1);
			date = cal.getTime();
			return sdf.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 比较两个时间点 是不是同一天
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static boolean DateCompare(Date d1, Date d2) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(d1);
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
		c1.set(Calendar.MILLISECOND, 0);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(d2);
		c2.set(Calendar.HOUR_OF_DAY, 0);
		c2.set(Calendar.MINUTE, 0);
		c2.set(Calendar.SECOND, 0);
		c2.set(Calendar.MILLISECOND, 0);
		int result = c1.compareTo(c2);
		if (result == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 根据月份获取月初时间
	 * 
	 * @param date
	 * @return
	 */
	public static String getStartTime(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse(time);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.set(Calendar.DAY_OF_MONTH, 1);
			date = cal.getTime();
			return sdf.format(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 根据月份获取月底时间
	 * 
	 * @param date
	 * @return
	 */
	public static String getEndTime(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse(time);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.MONTH, 1);
			cal.set(Calendar.DAY_OF_MONTH, 0);
			date = cal.getTime();
			return sdf.format(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 获得当天时间的零晨
	 * 
	 * @return
	 */
	public static Date getNowDayStart() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 获得当天时间的最后一秒
	 * 
	 * @return
	 */
	public static Date getNowDayEnd() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, -1);
		return cal.getTime();
	}

	/**
	 * 获得当月1号时间
	 * 
	 * @param args
	 */
	public static Date getMonthStart() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static boolean monthCompare(Date date1, Date date2) {
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		calendar.setTime(date1);
		int m1 = calendar.get(Calendar.MONTH);
		int y1 = calendar.get(Calendar.YEAR);
		calendar.setTime(date2);
		int y2 = calendar.get(Calendar.YEAR);
		int m2 = calendar.get(Calendar.MONTH);
		if (y1 > y2)
			return true;
		else if (y1 == y2 && m1 > m2)
			return true;
		else
			return false;
	}

	/**
	 * 取得当前时间戳（精确到秒）
	 *
	 * @return nowTimeStamp
	 */
	public static String getNowTimeStamp() {
		long time = System.currentTimeMillis();
		String nowTimeStamp = String.valueOf(time / 1000);
		return nowTimeStamp;
	}

	public static String Date2TimeStamp(String dateStr, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return String.valueOf(sdf.parse(dateStr).getTime() / 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static Date addMonths(final Date date, final int amount) {
		return add(date, Calendar.MONTH, amount);
	}

	private static Date add(final Date date, final int calendarField, final int amount) {
		if (date == null) {
			throw new IllegalArgumentException("The date must not be null");
		}
		final Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(calendarField, amount);
		return c.getTime();
	}

	public static String getTimeStrFormat(Date date) {
		return timeStrFormat.format(date);
	}

	public static void main(String[] args) {
		// System.out.println(getInternalTimeByMonth(6,DateUtils.TIMEF_FORMAT));
		// System.out.println(getInternalTimeByYm(7,5,DateUtils.TIMEF_FORMAT));
		String date = "2017-07-17 11:03:52";
		System.out.println("compareToBefore1 : " + date.compareTo("2017-09-16 11:03:52"));
		System.out.println("compareToBefore2 : " + date.compareTo("2017-05-16 11:03:52"));
		System.out.println("compareToNow1 : " + date.compareTo("2017-07-17 11:03:52"));
		System.out.println("compareToNow2 : " + date.compareTo("2017-07-17"));
		System.out.println("compareToAfter1 : " + date.compareTo("2017-07-18 11:03:52"));
		System.out.println("compareToAfter2 : " + date.compareTo("2017-09-16 11:03:52"));
		System.out.println(getToday(TIMEF_FORMAT));
		String date1 = "2017-07-09 11:12:56";
		System.out.println(getDiffersDays(date1, date));
		System.out.println(getCurMin());
		// 返回当前时间的小时
		System.out.println(getHour(new Date()));
		if (getHour(new Date()) >= 8 && getHour(new Date()) < 18) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}

	}
}