package time.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
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
		var quand = LocalDateTime.now(argTz);
		System.out.println(quand);
		//Locale argLocale = new Locale("esp", "arg");
		Locale[] locales = Locale.getAvailableLocales();
		Arrays.sort(locales, Comparator.comparing(Object::toString));
		for (Locale loc : locales) {
			System.out.print(loc + " : ");
			System.out.println(
				quand.format(DateTimeFormatter.ofPattern("eeee dd/MM/Y", loc)));
		}
	}
	
	@Test
	void testDateTime() {
		var onestquand = LocalDateTime.now();
		System.out.println(onestquand);
	}
	
	
	

}
