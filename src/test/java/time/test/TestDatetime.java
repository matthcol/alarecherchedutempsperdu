package time.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.Test;

class TestDatetime {

	public static final DateTimeFormatter FORMAT_DATE_FR =
			DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
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
				queljouronest.format(
						DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		System.out.println(
				queljouronest.format(
						DateTimeFormatter.ofPattern("d/M/yyyy")));
		System.out.println(
				queljouronest.format(
						DateTimeFormatter.ofPattern("d/M/yy")));
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
	
	@Test
	void testParsing() {
		String dateIso = "2019-09-07";
		String dateFr = "07/09/2019";
		String dateUk= "09/07/2019";
		String dateUkShort = "9/7/19";
		
		LocalDate date1 = LocalDate.parse(dateIso);
		LocalDate date2 = LocalDate.parse(dateFr, FORMAT_DATE_FR);
		LocalDate date3 = LocalDate.parse(dateUk, 
				DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		LocalDate date4 = LocalDate.parse(dateUkShort, 
				DateTimeFormatter.ofPattern("M/d/yy"));
		List<LocalDate> dates = List.of(date1, date2, date3, date4);
		for (var date : dates) {
			System.out.println("année : " + date.getYear());
			System.out.println("mois : " + date.getMonth());
			System.out.println("jour : " + date.getDayOfMonth());
		}
	}

	@Test
	void testDateFr() {
		String dateFr = "07/09/2019";
		LocalDate date = LocalDate.parse(dateFr, FORMAT_DATE_FR);
		assertAll(
				()->assertEquals(2019, date.getYear(), "year"),
				()->assertEquals(9, date.getMonthValue(), "month"),
				()->assertEquals(7, date.getDayOfMonth(), "day")
		);
	}
	
	@ParameterizedTest
	@ValueSource(ints = {2000, 2004, 2008, 2020, 2400})
	void testLeapYearOK(int year) {
		LocalDate february29th = LocalDate.of(year, 2,  29);
	}
	
	@ParameterizedTest
	@ValueSource(ints = {2019, 2021, 2100, 2200, 2300, 2500})
	void testLeapYearNOK(int year) {
		assertThrows(DateTimeException.class, 
				() -> {LocalDate february29th = LocalDate.of(year, 2,  29);}
		);
	}
}
