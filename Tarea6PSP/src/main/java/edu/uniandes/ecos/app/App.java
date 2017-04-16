package edu.uniandes.ecos.app;

import static spark.Spark.get;
import static spark.SparkBase.port;
import static spark.SparkBase.staticFileLocation;

import java.util.HashMap;
import java.util.Map;

import edu.uniandes.ecos.calculator.RangeCalculator;
import edu.uniandes.ecos.formater.DataFormater;
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
        
        //Obtener resultados con datos de entrada por url
        get("/results/:inputFile", (req, res) -> {	
          	DataFormater dataFormater = new DataFormater(req.params(":inputFile"));

        	Map<String,String> results = new HashMap<String,String>();
        	XCalculator calculator = new XCalculator(Double.parseDouble(dataFormater.getData()[0]), Double.parseDouble(dataFormater.getData()[1]));
        	results.put("p", dataFormater.getData()[0]);
        	results.put("dof",  dataFormater.getData()[1]);
        	results.put("result",  Double.toString(calculator.calculateX()));
          	
            return new ModelAndView(results, "program_results_input.ftl");

        }, new FreeMarkerEngine());
    
        //Obtener resultados del test 1
        get("/resultsTest1", (req, res) -> {

        	
        	Map<String,String> results = new HashMap<String,String>();
        	XCalculator calculator = new XCalculator(0.20,6);
        	results.put("result1",  Double.toString(calculator.calculateX()));
        	calculator = new XCalculator(0.45,15);
        	results.put("result2",  Double.toString(calculator.calculateX()));
        	calculator = new XCalculator(0.495,4);
        	results.put("result3",  Double.toString(calculator.calculateX()));
            return new ModelAndView(results, "program_results.ftl");
            
          }, new FreeMarkerEngine());
    }
}
