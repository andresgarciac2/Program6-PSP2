package edu.uniandes.ecos.app;

import static spark.Spark.get;
import static spark.SparkBase.port;
import static spark.SparkBase.staticFileLocation;

import java.util.HashMap;
import java.util.Map;

import edu.uniandes.ecos.calculator.RangeCalculator;
import edu.uniandes.ecos.formater.DataFormater;
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
          	if(!((Integer.parseInt(dataFormater.getData()[0]) & 1) == 0)){
        		Map<String,String> results = new HashMap<String,String>();
        		results.put("result", "el numero de secuencia debe ser un numero par");
                return new ModelAndView(results, "program_results.ftl");
          	}
            return new ModelAndView(RangeCalculator.calculateResults(Integer.parseInt(dataFormater.getData()[0]),Double.parseDouble(dataFormater.getData()[1]),Double.parseDouble(dataFormater.getData()[2])), "program_results.ftl");

        }, new FreeMarkerEngine());
    
        //Obtener resultados del test 1
        get("/resultsTest1", (req, res) -> {

        	
              return new ModelAndView(RangeCalculator.calculateResults(10, 1.1, 9), "program_results.ftl");

          }, new FreeMarkerEngine());
    }
}
