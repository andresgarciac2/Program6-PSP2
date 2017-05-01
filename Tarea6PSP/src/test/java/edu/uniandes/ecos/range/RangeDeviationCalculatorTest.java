package edu.uniandes.ecos.range;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.uniandes.ecos.regresion.calculator.LinearRegressionCalculator;
import edu.uniandes.ecos.regresion.calculator.Point;
import edu.uniandes.ecos.x.XCalculator;

public class RangeDeviationCalculatorTest {

	LinearRegressionCalculator linearRegressionCalculator = new LinearRegressionCalculator();
	
	@Test
	public void calculateResultrTest1() {
		double[] rta = linearRegressionCalculator.calculateRegressionData(getPointsTest1(), 386d);
    	RangeDeviationCalculator rangeCalc = new RangeDeviationCalculator(
    			new XCalculator(0.35,getPointsTest1().size()-2).calculateX(), 
    			rta[6], getPointsTest1(), 386d);
		assertTrue(rta[0] == -22.552532752034132);
		assertTrue(rta[1] == 1.7279324262069857);
		assertTrue(rta[2] == 0.9544965741046826);
		assertTrue(rta[3] == 0.9110637099775759);
		assertTrue(rta[4] == 644.4293837638623);
		assertTrue(rta[5] == 1.7751717813263568E-5);
		assertTrue(rangeCalc.calculateResults()[0] == 239.74400292736283);
		assertTrue(rta[4] - rangeCalc.calculateResults()[0] == 404.6853808364995);
		assertTrue(rta[4] + rangeCalc.calculateResults()[0] == 884.1733866912252);
	}
	
	@Test
	public void calculateResultrTest2() {
		double[] rta = linearRegressionCalculator.calculateRegressionData(getPointsTest2(), 386d);
    	RangeDeviationCalculator rangeCalc = new RangeDeviationCalculator(
    			new XCalculator(0.35,getPointsTest1().size()-2).calculateX(), 
    			rta[6], getPointsTest2(), 386d);
		assertTrue(rta[0] == -4.038881574687582);
		assertTrue(rta[1] == 0.168126649881629);
		assertTrue(rta[2] == 0.9333068981405512);
		assertTrue(rta[3] == 0.8710617661167372);
		assertTrue(rta[4] == 60.858005279621224);
		assertTrue(rta[5] == 7.98202749294763E-5);
		assertTrue(rangeCalc.calculateResults()[0] == 28.7249187742775);
		assertTrue(rta[4] - rangeCalc.calculateResults()[0] == 32.13308650534373);
		assertTrue(rta[4] + rangeCalc.calculateResults()[0] == 89.58292405389872);
	}
	
	public List<Point> getPointsTest1(){
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(130d,186d));
		points.add(new Point(650d,699d));
		points.add(new Point(99d,132d));
		points.add(new Point(150d,272d));
		points.add(new Point(128d,291d));
		points.add(new Point(302d,331d));
		points.add(new Point(95d,199d));
		points.add(new Point(945d,1890d));
		points.add(new Point(368d,788d));
		points.add(new Point(961d,1601d));
		return points;
	}
	
	public List<Point> getPointsTest2(){
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(130d,15.0d));
		points.add(new Point(650d,69.9d));
		points.add(new Point(99d,6.5d));
		points.add(new Point(150d,22.4d));
		points.add(new Point(128d,28.4d));
		points.add(new Point(302d,65.9d));
		points.add(new Point(95d,19.4d));
		points.add(new Point(945d,198.7d));
		points.add(new Point(368d,38.8d));
		points.add(new Point(961d,138.2));
		return points;
	}
}
