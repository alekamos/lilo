package it.costanza.LiLo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

public class DatetimeCustomConverter extends StrutsTypeConverter{

	private static final String DATETIME_FORMAT_STR = "dd/MM/yyyy hh:mm";
	private static final String DATE_FORMAT_STR = "dd/MM/yyyy";
	private static final String TIME_FORMAT_STR = "hh:mm:ss";


	private static final DateFormat DATETIME_FORMAT = new SimpleDateFormat(DATETIME_FORMAT_STR);
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_STR);
	private static final DateFormat TIME_FORMAT = new SimpleDateFormat(TIME_FORMAT_STR);

	@Override
	public Object convertFromString(Map context, String[] strings, Class toClass) {
		if (strings == null || strings.length == 0 || strings[0].trim().length() == 0) {
			return null;
		}

		try {
			if(strings[0].length()==DATETIME_FORMAT_STR.length())
				return DATETIME_FORMAT.parse(strings[0]);
			else if (strings[0].length()==DATE_FORMAT_STR.length()) 
				return DATE_FORMAT.parse(strings[0]);
			else if (strings[0].length()==TIME_FORMAT_STR.length()) 
				return TIME_FORMAT.parse(strings[0]);
			else
				throw new TypeConversionException("Unable to convert given object to date: " + strings[0]);

		} catch (ParseException e) {
			throw new TypeConversionException("Unable to convert given object to date: " + strings[0]);
		}
	}

	@Override
	public String convertToString(Map context, Object o) {
		// TODO Auto-generated method stub
		return null;
	}

}
