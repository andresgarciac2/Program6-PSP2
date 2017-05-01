package edu.uniandes.ecos.range;

import java.util.List;

import edu.uniandes.ecos.regresion.calculator.Point;

/**
 * @author andresgarcias4n
 * @since 30/04/2017
 * @version 0.0.1
 */
public class RangeDeviationCalculator {

	/**
	 * Variables de paquete
	 */
	double t;
	double deviation;
	List<Point> historicalData;
	double xk;

	/**
	 * constructor
	 * 
	 * @param t
	 * @param deviation
	 * @param historicalData
	 * @param xk
	 */
	public RangeDeviationCalculator(double t, double deviation, List<Point> historicalData, double xk) {
		super();
		this.t = t;
		this.deviation = deviation;
		this.historicalData = historicalData;
		this.xk = xk;
	}

	/**
	 * 
	 * Calcula el rango
	 * 
	 * @return
	 */
	public double[] calculateResults() {
		double media = 0.0;
		double sumaMedia = 0.0;
		double[] results = new double[3];
		for(Point p : historicalData){
			media += p.getX();
		}
		media = media/2;
		for(Point p : historicalData){
			sumaMedia += Math.pow(p.getX() - media, 2);
		}
		results[0] = t*deviation*Math.sqrt(1 + (1.0/(double)historicalData.size()) + (Math.pow(xk-media, 2)/sumaMedia) );
		return results;
	}

}
