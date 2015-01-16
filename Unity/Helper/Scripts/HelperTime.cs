using UnityEngine;
using System.Collections;
using System.Text.RegularExpressions;

namespace com.melphin.helper
{
	public static class hTime{
		
		#region CONSTANTS
		/// <summary>
		/// One millisecond in milliseconds
		/// </summary>
		public const long ONE_MILLISECOND = 1;
		
		/// <summary>
		/// One second in milliseconds
		/// </summary>
		public const long ONE_SECOND = 1000 * ONE_MILLISECOND;
		
		/// <summary>
		/// One minute in milliseconds
		/// </summary>
		public const long ONE_MINUTE = 60 * ONE_SECOND;
		
		/// <summary>
		/// One hour in milliseconds
		/// </summary>
		public const long ONE_HOUR = 60 * ONE_MINUTE;
		
		/// <summary>
		/// One day in milliseconds
		/// </summary>
		public const long ONE_DAY = 24 * ONE_HOUR;
		
		/// <summary>
		/// One week (7 days) in milliseconds
		/// </summary>
		public const long ONE_WEEK = 7 * ONE_DAY;
		
		/// <summary>
		/// One month (30 days) in milliseconds
		/// </summary>
		public const long ONE_MONTH = 30 * ONE_DAY;
		
		/// <summary>
		/// One year (365 days) in milliseconds
		/// </summary>
		public const long ONE_YEAR =  365 * ONE_DAY;
		#endregion
		#region CONSTANT STRING PREFIX
		public const string PREFIX_MILLISECONDS = "ms";
		public const string PREFIX_MILLISECONDS_ALT = "msec";
		public const string PREFIX_SECONDS = "s";
		public const string PREFIX_SECONDS_ALT_1 = "sec";
		public const string PREFIX_SECONDS_ALT_2 = "seconds";
		public const string PREFIX_MINUTES = "min";
		public const string PREFIX_MINUTES_ALT = "minutes";
		public const string PREFIX_HOURS = "h";
		public const string PREFIX_HOURS_ALT = "hours";
		public const string PREFIX_DAYS = "d";
		public const string PREFIX_DAYS_ALT = "days";
		public const string PREFIX_WEEKS = "w";
		public const string PREFIX_WEEKS_ALT = "weeks";
		public const string PREFIX_MONTHS = "m";
		public const string PREFIX_MONTHS_ALT = "months";
		public const string PREFIX_YEARS = "y";
		public const string PREFIX_YEARS_ALT = "years";
		
		private static Regex[] PREFIXES = new Regex[]
		{
			new Regex("(\\d+)\\s*("+PREFIX_MILLISECONDS_ALT+"|"+PREFIX_MILLISECONDS+")", RegexOptions.IgnoreCase),
			new Regex("(\\d+)\\s*("+PREFIX_SECONDS_ALT_2+"|"+PREFIX_SECONDS_ALT_1+"|"+PREFIX_SECONDS+")", RegexOptions.IgnoreCase),
			new Regex("(\\d+)\\s*("+PREFIX_MINUTES_ALT+"|"+PREFIX_MINUTES+")", RegexOptions.IgnoreCase),
			new Regex("(\\d+)\\s*("+PREFIX_HOURS_ALT+"|"+PREFIX_HOURS+")", RegexOptions.IgnoreCase),
			new Regex("(\\d+)\\s*("+PREFIX_DAYS_ALT+"|"+PREFIX_DAYS+")", RegexOptions.IgnoreCase),
			new Regex("(\\d+)\\s*("+PREFIX_WEEKS_ALT+"|"+PREFIX_WEEKS+")", RegexOptions.IgnoreCase),
			new Regex("(\\d+)\\s*("+PREFIX_MONTHS_ALT+"|"+PREFIX_MONTHS+"\\b)", RegexOptions.IgnoreCase),
			new Regex("(\\d+)\\s*("+PREFIX_YEARS_ALT+"|"+PREFIX_YEARS+")", RegexOptions.IgnoreCase)
		};
		private static long[] PREFIXES_VALUES = new long[]
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
		#endregion
		#region IN MILLISECONDS
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
		#endregion
		#region IN SECONDS
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
		#endregion
		#region PARSING
		public static long parse_ms(string value)
		{		
			if (value == null || value.Trim().Equals(""))
				return 0;

			MatchCollection m;
			GroupCollection g;
			long v;
			long result = 0;
			for (int i = 0; i < PREFIXES.Length; i++) {
				m = PREFIXES[i].Matches(value);
				foreach (Match match in m)
				{
					try
					{
						g = match.Groups;
						v = long.Parse(g[1].Value);
						result+=v*PREFIXES_VALUES[i];
					}catch{}
				}
			}
			return result;		
		}
		
		public static long parse_sec(string value)
		{
			return parse_ms(value)/ONE_SECOND;
		}
		#endregion
		#region TIME IN 
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
		#endregion
	}
}
