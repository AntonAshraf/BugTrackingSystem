package system;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {

	public static String getCurrentDate () {
        // Current date
		LocalDate currentDate = LocalDate.now();
		
		// Formatting a date
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formattedDate = currentDate.format(formatter);
		
		return formattedDate;
	}

}
