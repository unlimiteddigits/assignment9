package jUnitTest;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import Model.Indications;

public class BmiTesting {

	private static Indications indicator = null;

	@BeforeClass
	public static void setupClass() {
		indicator = new Indications();
	}

	/*
	 * double value = Double.parseDouble(indicator); if (value < 18.5) {
	 * Indicator = "UNDERWEIGHT"; } else if (value >= 18.5 & value <= 24.9) {
	 * Indicator = "NORMAL"; } else if (value >= 25.0 & value <= 29.9) {
	 * Indicator = "OVERWEIGHT"; } else { Indicator = "OBESE"; }
	 */

	@Test
	public void testBMI_A() {
		String value = indicator.indicateBMIRisk("18.5");
		assertEquals("NORMAL", value);
	}

	@Test
	public void testBMI_B() {
		String value = indicator.indicateBMIRisk("18.4");
		assertEquals("UNDERWEIGHT", value);
	}

	@Test
	public void testBMI_C() {
		String value = indicator.indicateBMIRisk("24.9");
		assertEquals("NORMAL", value);
	}

	@Test
	public void testBMI_D() {
		String value = indicator.indicateBMIRisk("25.0");
		assertEquals("OVERWEIGHT", value);
	}

	@Test
	public void testBMI_E() {
		String value = indicator.indicateBMIRisk("29.9");
		assertEquals("OVERWEIGHT", value);
	}

	@Test
	public void testBMI_F() {
		String value = indicator.indicateBMIRisk("30.0");
		assertEquals("OBESE", value);
	}

}
