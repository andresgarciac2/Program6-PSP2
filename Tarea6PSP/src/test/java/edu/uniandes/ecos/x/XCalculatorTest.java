package edu.uniandes.ecos.x;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class XCalculatorTest {

	
	XCalculator calculator = null;

	
	@Test
	public void calculateResultrTest1() {	
		double[] values = new double[3];
		calculator = new XCalculator(0.20,6);
		values[0] = calculator.calculateX();
		calculator = new XCalculator(0.45,15);
		values[1] = calculator.calculateX();
		calculator = new XCalculator(0.495,4);
		values[2] = calculator.calculateX();
		
		assertTrue(values[0] == 0.55340576171875);
		assertTrue(values[1] == 1.7530517578125);
		assertTrue(values[2] == 4.607421875);
	}
	
}
