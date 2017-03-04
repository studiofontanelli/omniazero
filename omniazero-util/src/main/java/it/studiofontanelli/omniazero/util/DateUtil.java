package it.studiofontanelli.omniazero.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class DateUtil {

	public static final String DATE_FORMAT_ddMMyyyy = "dd/MM/yyyy";
	public static final String DATE_FORMAT_ddMMyyyyHHmmss = "dd/MM/yyyy HH:mm:ss";
	public static final String DATE_FORMAT_yyyyMMddHHmmss = "yyyyMMddHHmmss";

	public static Date clearTimeOfDate(Date d) {
		// posticipato al metodo di calcolo
		return d;
	}
	
	public static java.util.Date format(String dateStr, String pattern) throws ParseException {
		Date date = null;
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		format.setLenient(false);
		date = format.parse(dateStr);
		return new java.util.Date(date.getTime());
	}

	public static String format(java.util.Date date, String pattern) {
		String formattedDate = "";
		if (date != null) {
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			formattedDate = format.format(date);
		}
		return formattedDate;
	}

	public static String formatISO8601(java.util.Date date) {
		String formattedDate = "";
		String pattern = "yyyy-MM-dd'T'HH:mm:ssZ";
		if (date != null) {
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			formattedDate = format.format(date);
			formattedDate = formattedDate.substring(0, 22) + ":" + formattedDate.substring(22);
		}
		return formattedDate;
	}

	public static String format(Object date, String pattern) {
		String formattedDate = "";
		if (date != null) {
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			formattedDate = format.format(date);
		}
		return formattedDate;
	}

	/**
	 * Restituisce la data corrente
	 * 
	 * @return
	 */
	public static Date getCurrentDate() {
		return Calendar.getInstance().getTime();
	}

	public static Timestamp getCurrentTimestamp() {
		return new Timestamp(Calendar.getInstance().getTime().getTime());
	}

	public static int getDifferenzaGiorniTraDate(Date dataInizio, Date dataFine) {

		DateTime d1 = new DateTime(clearTimeOfDate(dataInizio));
		DateTime d2 = new DateTime(clearTimeOfDate(dataFine));
		return Days.daysBetween(d1.withTimeAtStartOfDay(), d2.withTimeAtStartOfDay()).getDays();
	}

}
