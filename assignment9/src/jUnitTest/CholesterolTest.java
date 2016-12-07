package jUnitTest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import Model.Indications;

public class CholesterolTest {

	private static Indications indicator = null;

	@BeforeClass
	public static void setupClass() {
		indicator = new Indications();
	}

	/*
	 * double value = Conversion.SafeParseInteger(cholesterol); Indicator =
	 * "BORDERLINE HIGH"; if (value < 200) { Indicator = "DESIRABLE"; } if
	 * (value >= 240) { Indicator = "HIGH"; }
	 */

	@Test
	public void testCholesterol_A() {
		String value = indicator.indicateCholesterolRisk("201");
		assertEquals("BORDERLINE HIGH", value);
	}

	@Test
	public void testCholesterol_B() {
		String value = indicator.indicateCholesterolRisk("200");
		assertEquals("BORDERLINE HIGH", value);
	}

	@Test
	public void testCholesterol_C() {
		String value = indicator.indicateCholesterolRisk("199");
		assertEquals("DESIRABLE", value);
	}

	@Test
	public void testCholesterol_D() {
		String value = indicator.indicateCholesterolRisk("240");
		assertEquals("HIGH", value);
	}

	@Test
	public void testCholesterol_E() {
		String value = indicator.indicateCholesterolRisk("239");
		assertEquals("BORDERLINE HIGH", value);
	}

	@Test
	public void testCholesterol_F() {
		String value = indicator.indicateCholesterolRisk("300");
		assertEquals("HIGH", value);
	}

}
