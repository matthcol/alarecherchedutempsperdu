package time.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.junit.jupiter.api.Test;

class TestDatetime {

	@Test
	void testTime() {
		var quelleheureestil = LocalTime.now();
		System.out.println(quelleheureestil);
	}
	
	@Test
	void testDate() {
		var queljouronest = LocalDate.now();
		System.out.println(queljouronest);
		System.out.println(
				queljouronest.format(DateTimeFormatter.ofPattern("eeee dd/MM/Y")));
	}
	
	@Test
	void testDateInternational() {
		ZoneId argTz = ZoneId.of("America/Buenos_Aires");
		Locale argLocale = new Locale("arg", "esp");
		System.out.println(argLocale);
		var quand = LocalDateTime.now(argTz);
		System.out.println(quand);
		System.out.println(
				quand.format(DateTimeFormatter.ofPattern("eeee dd/MM/Y", argLocale)));
	}
	
	@Test
	void testDateTime() {
		var onestquand = LocalDateTime.now();
		System.out.println(onestquand);
	}
	
	
	

}
