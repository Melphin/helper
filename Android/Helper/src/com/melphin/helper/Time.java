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

	public final static String TEXT_VALUE_ZERO = "zero"; 
	public final static String TEXT_VALUE_NONE = "none"; 
	public final static String TEXT_VALUE_NULL = "null"; 
	public final static String TEXT_VALUE_ONE = "one"; 
	public final static String TEXT_VALUE_TWO = "two"; 
	public final static String TEXT_VALUE_THREE = "three"; 
	public final static String TEXT_VALUE_FOUR = "four"; 
	public final static String TEXT_VALUE_FIVE = "five"; 
	public final static String TEXT_VALUE_SIX = "six"; 
	public final static String TEXT_VALUE_SEVEN = "seven"; 
	public final static String TEXT_VALUE_EIGHT = "eight"; 
	public final static String TEXT_VALUE_NINE = "nine";
	
	private final static String VALUE_PREFIX_PATTERN = "(\\d+|"+
			TEXT_VALUE_ZERO+"\\s|"+
			TEXT_VALUE_NONE+"\\s|"+
			TEXT_VALUE_NULL+"\\s|"+
			TEXT_VALUE_ONE+"\\s|"+
			TEXT_VALUE_TWO+"\\s|"+
			TEXT_VALUE_THREE+"\\s|"+
			TEXT_VALUE_FOUR+"\\s|"+
			TEXT_VALUE_FIVE+"\\s|"+
			TEXT_VALUE_SIX+"\\s|"+
			TEXT_VALUE_SEVEN+"\\s|"+
			TEXT_VALUE_EIGHT+"\\s|"+
			TEXT_VALUE_NINE+"\\s)";
	private final static Pattern[] PREFIXES = new Pattern[]
			{
				Pattern.compile(VALUE_PREFIX_PATTERN+"\\s*("+PREFIX_MILLISECONDS_ALT+"|"+PREFIX_MILLISECONDS+")"),
				Pattern.compile(VALUE_PREFIX_PATTERN+"\\s*("+PREFIX_SECONDS_ALT_2+"|"+PREFIX_SECONDS_ALT_1+"|"+PREFIX_SECONDS+")"),
				Pattern.compile(VALUE_PREFIX_PATTERN+"\\s*("+PREFIX_MINUTES_ALT+"|"+PREFIX_MINUTES+")"),
				Pattern.compile(VALUE_PREFIX_PATTERN+"\\s*("+PREFIX_HOURS_ALT+"|"+PREFIX_HOURS+")"),
				Pattern.compile(VALUE_PREFIX_PATTERN+"\\s*("+PREFIX_DAYS_ALT+"|"+PREFIX_DAYS+")"),
				Pattern.compile(VALUE_PREFIX_PATTERN+"\\s*("+PREFIX_WEEKS_ALT+"|"+PREFIX_WEEKS+")"),
				Pattern.compile(VALUE_PREFIX_PATTERN+"\\s*("+PREFIX_MONTHS_ALT+"|"+PREFIX_MONTHS+"\\b)"),
				Pattern.compile(VALUE_PREFIX_PATTERN+"\\s*("+PREFIX_YEARS_ALT+"|"+PREFIX_YEARS+")")
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
		
		try
		{
			long result = getValue(value);
			return result;
		}catch(Exception e)
		{			
		}
		
		Matcher m;
		long v;
		long result = 0;
		for (int i = 0; i < PREFIXES.length; i++) {
			m = PREFIXES[i].matcher(value);
			while(m.find())
			{
				try
				{
					v = getValue(m.group(1));
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

	public static long getValue(String value) throws Exception
	{
		if (value==null || value.trim().equals(""))
			return 0;
		value = value.trim();
		
		try
		{
			return Long.parseLong(value);
		}catch(Exception e)
		{
			if (value.equals(TEXT_VALUE_ZERO) ||
					value.equals(TEXT_VALUE_NONE) ||
					value.equals(TEXT_VALUE_NULL))
				return 0;
			if (value.equals(TEXT_VALUE_ONE))
				return 1;
			if (value.equals(TEXT_VALUE_TWO))
				return 2;
			if (value.equals(TEXT_VALUE_THREE))
				return 3;
			if (value.equals(TEXT_VALUE_FOUR))
				return 4;
			if (value.equals(TEXT_VALUE_FIVE))
				return 5;
			if (value.equals(TEXT_VALUE_SIX))
				return 6;
			if (value.equals(TEXT_VALUE_SEVEN))
				return 7;
			if (value.equals(TEXT_VALUE_EIGHT))
				return 8;
			if (value.equals(TEXT_VALUE_NINE))
				return 9;
		}
		throw new Exception();
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
