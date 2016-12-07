package jUnitTest;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import Model.Indications;

public class BloodPressureTest {

	private static Indications newIndicator = null;

	@BeforeClass
	public static void setupClass() {
		newIndicator = new Indications();
	}

	@Test
	public void bloodPressureHyperSystolicAndDiaostalic() {

		String indicate = newIndicator.indicateBloodPressureRisk("120/80");

		assertEquals("PREHYPERTENSION", indicate);

	}

	@Test
	public void bloodPressureIndicationpreHyperJustSystolic() {

		String indicate = newIndicator.indicateBloodPressureRisk("139/50");

		assertEquals("PREHYPERTENSION", indicate);

	}

	@Test
	public void bloodPressureIndicationpreHyperJustDiaostalic() {

		String indicate = newIndicator.indicateBloodPressureRisk("100/89");

		assertEquals("PREHYPERTENSION", indicate);

	}

	@Test
	public void bloodPressureIndicationNormal() {

		String indicate = newIndicator.indicateBloodPressureRisk("119/79");

		assertEquals("NORMAL", indicate);

	}

	@Test
	public void bloodPressureIndicationpreStage1Both() {

		String indicate = newIndicator.indicateBloodPressureRisk("140/90");

		assertEquals("STAGE 1 HYPERTENSION ", indicate);

	}

	@Test
	public void bloodPressureIndicationpreStage1JustSystolic() {

		String indicate = newIndicator.indicateBloodPressureRisk("140/79");

		assertEquals("STAGE 1 HYPERTENSION ", indicate);
	}

	@Test
	public void bloodPressureIndicationpreJustDiaostalic() {

		String indicate = newIndicator.indicateBloodPressureRisk("119/90");

		assertEquals("STAGE 1 HYPERTENSION ", indicate);
	}

	@Test
	public void bloodPressureIndicationStage2Both() {

		String indicate = newIndicator.indicateBloodPressureRisk("160/100");

		assertEquals("STAGE 2 HYPERTENSION ", indicate);

	}

	@Test
	public void bloodPressureIndicationStage2JustSystolic() {

		String indicate = newIndicator.indicateBloodPressureRisk("160/79");

		assertEquals("STAGE 2 HYPERTENSION ", indicate);

	}

	@Test
	public void bloodPressureIndicationStage2JustDiaostalic() {

		String indicate = newIndicator.indicateBloodPressureRisk("119/100");

		assertEquals("STAGE 2 HYPERTENSION ", indicate);

	}

	@Test
	public void bloodPressureIndicationCrisisBoth() {

		String indicate = newIndicator.indicateBloodPressureRisk("190/120");

		assertEquals("HYPERTENSIVE CRISIS", indicate);

	}

	@Test
	public void bloodPressureIndicationCrisisJustSystolic() {

		String indicate = newIndicator.indicateBloodPressureRisk("200/79");

		assertEquals("HYPERTENSIVE CRISIS", indicate);

	}

	@Test
	public void bloodPressureIndicationCrisisJustDiaostalic() {

		String indicate = newIndicator.indicateBloodPressureRisk("119/300");

		assertEquals("HYPERTENSIVE CRISIS", indicate);

	}

}
