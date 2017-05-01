
package edu.uniandes.ecos.regresion.calculator;

import java.util.List;

import org.apache.commons.math3.stat.regression.SimpleRegression;

/**
 * 
 * Clase para calcular los valores solicitados por el enunciado
 * @author AndrésGarcía
 *@version 0.0.1
 */
public class LinearRegressionCalculator {

	/**
	 * 
	 * Calcula y retorna los valores usando uso de Apache common Math
	 * 
	 * @param entryData
	 * @param predict
	 * @return
	 */
	public double[] calculateRegressionData(List<Point> entryData,double predict){
    	SimpleRegression regression = new SimpleRegression();
    	double[] result = new double[7];
    	double deviationSum = 0;
    	for(Point p : entryData){
    		regression.addData(p.getX(), p.getY());
    	}

    	result[0] = regression.regress().getParameterEstimate(0);
    	result[1] = regression.regress().getParameterEstimate(1);
    	result[2] = regression.getR();
    	result[3] = regression.getRSquare();
    	result[4] = regression.predict(predict);
    	result[5] = regression.getSignificance();
    	for(Point p : entryData){
    		regression.addData(p.getX(), p.getY());
    		deviationSum += Math.pow(p.y - result[0] - (result[1]* p.x), 2);
    	}
    	double div = 1.0/((double)entryData.size()-2.0);
    	result[6] = Math.sqrt(div*deviationSum);
    	return result;
	}
	
}
