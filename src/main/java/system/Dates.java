package system;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.ChronoZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import java.util.Date;

public class Dates {

  public static String dateFormat(Date date) {
    System.out.println("Date: " + date);
	  LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	  DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      String formattedDate = localDate.format(dateFormat);
      System.out.println("Formatted Date: " + formattedDate);
		return formattedDate;
  }
	public static String getCurrentDate () {
    // Current date
		LocalDate currentDate = LocalDate.now();
		
		// Formatting a date
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDate = currentDate.format(formatter);
		
		return formattedDate;
	}
	  public static long getDaysBetweenDates(String date1, String date2) {
		    // long d = Auth.getDaysBetweenDates("23/04/2023","29/04/2023");
		    // start done
		    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		    try {
		      java.util.Date startDate = dateFormat.parse(date1);
		      java.util.Date endDate = dateFormat.parse(date2);

		      long diffInMilliseconds = endDate.getTime() - startDate.getTime();
		      long diffInDays = TimeUnit.DAYS.convert(diffInMilliseconds, TimeUnit.MILLISECONDS);

		      return diffInDays;
		    } catch (ParseException e) {
		      e.printStackTrace();
		      return -1; // Return -1 to indicate an error
		    }
		  }
      
}
