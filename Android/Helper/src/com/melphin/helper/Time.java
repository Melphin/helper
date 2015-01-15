package com.melphin.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Time {

	// CONSTANTS
	/**
	 * One millisecond in milliseconds
	 */
	public final static long ONE_MILLISECOND = 1;

	/**
	 * One second in milliseconds
	 */
	public final static long ONE_SECOND = 1000 * ONE_MILLISECOND;

	/**
	 * One minute in milliseconds
	 */
	public final static long ONE_MINUTE = 60 * ONE_SECOND;

	/**
	 * One hour in milliseconds
	 */
	public final static long ONE_HOUR = 60 * ONE_MINUTE;

	/**
	 * One day in milliseconds
	 */
	public final static long ONE_DAY = 24 * ONE_HOUR;

	/**
	 * One week (7 days) in milliseconds
	 */
	public final static long ONE_WEEK = 7 * ONE_DAY;

	/**
	 * One month (30 days) in milliseconds
	 */
	public final static long ONE_MONTH = 30 * ONE_DAY;

	/**
	 * One year (365 days) in milliseconds
	 */
	public final static long ONE_YEAR =  365 * ONE_DAY;
	
	// CONSTANT STRING PREFIX
	public final static String PREFIX_MILLISECONDS = "ms";
	public final static String PREFIX_MILLISECONDS_ALT = "msec";
	public final static String PREFIX_SECONDS = "s";
	public final static String PREFIX_SECONDS_ALT_1 = "sec";
	public final static String PREFIX_SECONDS_ALT_2 = "seconds";
	public final static String PREFIX_MINUTES = "min";
	public final static String PREFIX_MINUTES_ALT = "minutes";
	public final static String PREFIX_HOURS = "h";
	public final static String PREFIX_HOURS_ALT = "hours";
	public final static String PREFIX_DAYS = "d";
	public final static String PREFIX_DAYS_ALT = "days";
	public final static String PREFIX_WEEKS = "w";
	public final static String PREFIX_WEEKS_ALT = "weeks";
	public final static String PREFIX_MONTHS = "m";
	public final static String PREFIX_MONTHS_ALT = "months";
	public final static String PREFIX_YEARS = "y";
	public final static String PREFIX_YEARS_ALT = "years";
	
	private final static Pattern[] PREFIXES = new Pattern[]
			{
				Pattern.compile("(\\d+)\\s*("+PREFIX_MILLISECONDS_ALT+"|"+PREFIX_MILLISECONDS+")"),
				Pattern.compile("(\\d+)\\s*("+PREFIX_SECONDS_ALT_2+"|"+PREFIX_SECONDS_ALT_1+"|"+PREFIX_SECONDS+")"),
				Pattern.compile("(\\d+)\\s*("+PREFIX_MINUTES_ALT+"|"+PREFIX_MINUTES+")"),
				Pattern.compile("(\\d+)\\s*("+PREFIX_HOURS_ALT+"|"+PREFIX_HOURS+")"),
				Pattern.compile("(\\d+)\\s*("+PREFIX_DAYS_ALT+"|"+PREFIX_DAYS+")"),
				Pattern.compile("(\\d+)\\s*("+PREFIX_WEEKS_ALT+"|"+PREFIX_WEEKS+")"),
				Pattern.compile("(\\d+)\\s*("+PREFIX_MONTHS_ALT+"|"+PREFIX_MONTHS+"\\b)"),
				Pattern.compile("(\\d+)\\s*("+PREFIX_YEARS_ALT+"|"+PREFIX_YEARS+")")
			};
	private final static long[] PREFIXES_VALUES = new long[]
			{
				ONE_MILLISECOND,
				ONE_SECOND,
				ONE_MINUTE,
				ONE_HOUR,
				ONE_DAY,
				ONE_WEEK,
				ONE_MONTH,
				ONE_YEAR
			};
	
	// IN MILLISECONDS
	public static long milliseconds_ms(long ms)
	{
		return ms * ONE_MILLISECOND;
	}
	
	public static long seconds_ms(long sec)
	{
		return sec * ONE_SECOND;
	}
	
	public static long minutes_ms(long min)
	{
		return min * ONE_MINUTE;
	}
	
	public static long hours_ms(long hours)
	{
		return hours * ONE_HOUR;
	}
	
	public static long days_ms(long days)
	{
		return days * ONE_DAY;
	}
	
	public static long weeks_ms(long weeks)
	{
		return weeks * ONE_WEEK;
	}
	
	public static long months_ms(long months)
	{
		return months * ONE_MONTH;
	}
	
	public static long years_ms(long years)
	{
		return years * ONE_YEAR;
	}
	
	// IN SECONDS
	public static long seconds_sec(long sec)
	{
		return seconds_ms(sec)/ONE_SECOND;
	}
	
	public static long minutes_sec(long min)
	{
		return minutes_ms(min)/ONE_SECOND;
	}
	
	public static long hours_sec(long hours)
	{
		return hours_ms(hours)/ONE_SECOND;
	}
	
	public static long days_sec(long days)
	{
		return days_ms(days)/ONE_SECOND;
	}
	
	public static long weeks_sec(long weeks)
	{
		return weeks_ms(weeks)/ONE_SECOND;
	}
	
	public static long months_sec(long months)
	{
		return months_ms(months)/ONE_SECOND;
	}
	
	public static long years_sec(long years)
	{
		return years_ms(years)/ONE_SECOND;
	}

	// PARSING
	public static long parse_ms(String value)
	{		
		if (value == null || value.trim().equals(""))
			return 0;
		
		Matcher m;
		long v;
		long result = 0;
		for (int i = 0; i < PREFIXES.length; i++) {
			m = PREFIXES[i].matcher(value);
			while(m.find())
			{
				try
				{
					v = Long.parseLong(m.group(1));
					result+=v*PREFIXES_VALUES[i];
				}catch(Exception e){}
			}
		}
		return result;		
	}
	
	public static long parse_sec(String value)
	{
		return parse_ms(value)/ONE_SECOND;
	}
	
	// TIME IN 
	public static long milliseconds_in(long ms)
	{
		return ms / ONE_MILLISECOND;
	}
	
	public static long seconds_in(long ms)
	{
		return ms / ONE_SECOND;
	}
	
	public static long minutes_in(long ms)
	{
		return ms / ONE_MINUTE;
	}
	
	public static long hours_in(long ms)
	{
		return ms / ONE_HOUR;
	}
	
	public static long days_in(long ms)
	{
		return ms / ONE_DAY;
	}
	
	public static long weeks_in(long ms)
	{
		return ms / ONE_WEEK;
	}
	
	public static long months_in(long ms)
	{
		return ms / ONE_MONTH;
	}
	
	public static long years_in(long ms)
	{
		return ms / ONE_YEAR;
	}
}
