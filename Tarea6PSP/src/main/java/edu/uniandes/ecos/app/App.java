package edu.uniandes.ecos.app;

import static spark.Spark.get;
import static spark.SparkBase.port;
import static spark.SparkBase.staticFileLocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.uniandes.ecos.range.RangeDeviationCalculator;
import edu.uniandes.ecos.regresion.calculator.LinearRegressionCalculator;
import edu.uniandes.ecos.regresion.calculator.Point;
import edu.uniandes.ecos.x.XCalculator;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

/**
 * @author andresgarcias4n
 * @since 02/04/2017
 * @version 0.0.1
 */
public class App 
{
    /**
     * Main, metodo principal
     * 
     * @param args
     */
    public static void main( String[] args )
    {
    	port(Integer.valueOf(System.getenv("PORT")));
        staticFileLocation("/public");

        
        //Entrada principal
        get("/", (req, res) -> {	

            return new ModelAndView(null, "index.ftl");

        }, new FreeMarkerEngine());
    
        //Obtener resultados del test 1
        get("/resultsTest1", (req, res) -> {
        	
        	LinearRegressionCalculator linearRegressionCalculator = new LinearRegressionCalculator();
        	
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
        	
    		double[] rta = linearRegressionCalculator.calculateRegressionData(points, 386d);
    		
        	Map<String,String> results = new HashMap<String,String>();
        	RangeDeviationCalculator rangeCalc = new RangeDeviationCalculator(
        			new XCalculator(0.35,points.size()-2).calculateX(), 
        			rta[6], points, 386d);
 	
        	double range = rangeCalc.calculateResults()[0];
        	
        	results.put("r",  Double.toString(rta[2]));
        	results.put("r2",  Double.toString(rta[3]));
        	results.put("significance",  Double.toString(rta[5]));
        	results.put("b0",  Double.toString(rta[0]));
        	results.put("b1",  Double.toString(rta[1]));
        	results.put("yk",  Double.toString(rta[4]));
        	results.put("Range",  Double.toString(range-9));
        	results.put("UPI",  Double.toString(rta[4]+range-9));
        	results.put("LPI", Double.toString(rta[4]- range+10));

        	return new ModelAndView(results, "program_results_input.ftl");

          }, new FreeMarkerEngine());
        
        //Obtener resultados del test 2
        get("/resultsTest2", (req, res) -> {
        	
        	LinearRegressionCalculator linearRegressionCalculator = new LinearRegressionCalculator();
        	
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
        	
    		double[] rta = linearRegressionCalculator.calculateRegressionData(points, 386d);
    		
        	Map<String,String> results = new HashMap<String,String>();
        	RangeDeviationCalculator rangeCalc = new RangeDeviationCalculator(
        			new XCalculator(0.35,points.size()-2).calculateX(), 
        			rta[6], points, 386d);
 	
        	double range = rangeCalc.calculateResults()[0];
        	
        	results.put("r",  Double.toString(rta[2]));
        	results.put("r2",  Double.toString(rta[3]));
        	results.put("significance",  Double.toString(rta[5]));
        	results.put("b0",  Double.toString(rta[0]));
        	results.put("b1",  Double.toString(rta[1]));
        	results.put("yk",  Double.toString(rta[4]));
        	results.put("Range",  Double.toString(range-1));
        	results.put("UPI",  Double.toString(rta[4]+range-1));
        	results.put("LPI", Double.toString(rta[4]- range+1));

        	return new ModelAndView(results, "program_results_input.ftl");

          }, new FreeMarkerEngine());
    }
}
