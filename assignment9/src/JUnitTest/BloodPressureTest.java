package JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Indications;

public class BloodPressureTest {

	@Test
	public void bloodPressureHyperSystolicAndDiaostalic() {
	
		Indications newIndicator = new Indications();
		
		String indicate = newIndicator.indicateBloodPressureRisk("120/80");
		
		assertEquals("PREHYPERTENSION",indicate);
		
		
	}
	
	@Test
	public void bloodPressureIndicationpreHyperJustSystolic() {
	
		Indications newIndicator = new Indications();
		
		String indicate = newIndicator.indicateBloodPressureRisk("139/50");
		
		assertEquals("PREHYPERTENSION",indicate);
		
		
	}
	
	@Test
	public void bloodPressureIndicationpreHyperJustDiaostalic() {
	
		Indications newIndicator = new Indications();
		
		String indicate = newIndicator.indicateBloodPressureRisk("100/89");
		
		assertEquals("PREHYPERTENSION",indicate);
		
		
	}
	
	@Test
	public void bloodPressureIndicationNormal() {
	
		Indications newIndicator = new Indications();
		
		String indicate = newIndicator.indicateBloodPressureRisk("119/79");
		
		assertEquals("NORMAL",indicate);
		
		
	}
	
	@Test
	public void bloodPressureIndicationpreStage1Both() {
	
		Indications newIndicator = new Indications();
		
		String indicate = newIndicator.indicateBloodPressureRisk("140/90");
		
		assertEquals("STAGE 1 HYPERTENSION ",indicate);
		
		
	}
	
	@Test
	public void bloodPressureIndicationpreStage1JustSystolic() {
	
		Indications newIndicator = new Indications();
		
		String indicate = newIndicator.indicateBloodPressureRisk("140/79");
		
		assertEquals("STAGE 1 HYPERTENSION ",indicate);
		
		
	}
	
	@Test
	public void bloodPressureIndicationpreJustDiaostalic() {
	
		Indications newIndicator = new Indications();
		
		String indicate = newIndicator.indicateBloodPressureRisk("119/90");
		
		assertEquals("STAGE 1 HYPERTENSION ",indicate);
		
		
	}
	
	@Test
	public void bloodPressureIndicationStage2Both() {
	
		Indications newIndicator = new Indications();
		
		String indicate = newIndicator.indicateBloodPressureRisk("160/100");
		
		assertEquals("STAGE 2 HYPERTENSION ",indicate);
		
		
	}
	@Test
	public void bloodPressureIndicationStage2JustSystolic() {
		
		Indications newIndicator = new Indications();
		
		String indicate = newIndicator.indicateBloodPressureRisk("160/79");
		
		assertEquals("STAGE 2 HYPERTENSION ",indicate);
		
		
	}
	@Test
	public void bloodPressureIndicationStage2JustDiaostalic() {
		
		Indications newIndicator = new Indications();
		
		String indicate = newIndicator.indicateBloodPressureRisk("119/100");
		
		assertEquals("STAGE 2 HYPERTENSION ",indicate);
		
		
	}
	@Test
	public void bloodPressureIndicationCrisisBoth() {
		
		Indications newIndicator = new Indications();
		
		String indicate = newIndicator.indicateBloodPressureRisk("190/120");
		
		assertEquals("HYPERTENSIVE CRISIS",indicate);
		
		
	}
	@Test
	public void bloodPressureIndicationCrisisJustSystolic() {
		
		Indications newIndicator = new Indications();
		
		String indicate = newIndicator.indicateBloodPressureRisk("200/79");
		
		assertEquals("HYPERTENSIVE CRISIS",indicate);
		
		
	}
	@Test
	public void bloodPressureIndicationCrisisJustDiaostalic() {
		
		Indications newIndicator = new Indications();
		
		String indicate = newIndicator.indicateBloodPressureRisk("119/300");
		
		assertEquals("HYPERTENSIVE CRISIS",indicate);
		
		
	}
	
	
	
	
}
