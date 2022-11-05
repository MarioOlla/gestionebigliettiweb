package it.prova.gestionebigliettiweb.utility;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtility {
	
	public static LocalDateTime convertFromJavaDateToLocalDateTime(Date toConvert) {
		return toConvert.toInstant()
			      .atZone(ZoneId.systemDefault())
			      .toLocalDateTime();
	}
}
