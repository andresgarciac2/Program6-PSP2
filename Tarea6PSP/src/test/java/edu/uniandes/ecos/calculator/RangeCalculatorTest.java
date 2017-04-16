package edu.uniandes.ecos.calculator;

import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

public class RangeCalculatorTest {
	
	RangeCalculator rangeCalculator = new RangeCalculator();
	
	@Test
	public void calculateResultrTest1() {	 
		Map<String,String> results = rangeCalculator.calculateResults(10,1.1,9);
		assertTrue(results.get("result").equals("0.35005863689720107"));
	}
	
	
	@Test
	public void calculateSimpsonFormulaTest() {	 
		double results = rangeCalculator.calculateSimpsonFormula(10,1.1,9);
		assertTrue(results == 0.3500589042865573);
	}
	
	@Test
	public void calculateGammaForIntFormulaTest() {	 
		double results = rangeCalculator.calculateFactorialGamma(5);
		assertTrue(results == 24);
	}
	
	@Test
	public void calculateGammaForNotIntFormulaTest() {	 
		double results = rangeCalculator.calculateFactorialGammaNonInteger(4.5);
		assertTrue(results == 11.631728396567448);
	}
}
