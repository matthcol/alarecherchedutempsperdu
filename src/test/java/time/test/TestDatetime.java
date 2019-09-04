package time.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
	}
	
	@Test
	void testDateTime() {
		var onestquand = LocalDateTime.now();
		System.out.println(onestquand);
	}

}
