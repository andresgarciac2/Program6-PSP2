package edu.uniandes.ecos.calculator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author andresgarcias4n
 * @since 02/04/2017
 * @version 0.0.1
 */
public class RangeCalculator {

	/**
	 * Calcula la formula de simpson
	 * 
	 * @param classes
	 * @return
	 */
	public static double calculateSimpsonFormula(int numSeg,double x,double dof){
		
		double result = 0;
		double w = x/numSeg;
		double part3 = 0;
		
		if (((dof+1)/2 == Math.floor((dof+1)/2)) && !Double.isInfinite((dof+1)/2)){
			part3 = calculateFactorialGamma((dof+1)/2)/(Math.pow((dof*Math.PI), 0.5)*calculateFactorialGammaNonInteger(dof/2));
		}else{
			part3 = calculateFactorialGammaNonInteger((dof+1)/2)/(Math.pow((dof*Math.PI), 0.5)*calculateFactorialGamma(dof/2));
		}
		
		for(int i = 0 ; i <= numSeg; i++){
			double xi = i*w;
			double part1 = 1 + (Math.pow(xi, 2)/dof);
			double part2 = Math.pow(part1, -((dof+1)/2));
			double function = part2 * part3;
			
			if(i == 0 || i == numSeg) result += (w/3)*function;
			else if((i & 1) == 0) result += (w/3)*function*2;
			else result += (w/3)*function*4;
		}
		return result;
	}
	
	/**
	 * Calcula los p
	 * 
	 * @param classes
	 * @return
	 */
	public static  Map<String,String> calculateResults(int numSeg,double x,double dof){
		double e = 0.00001;
		Map<String,String> results = new HashMap<String,String>();
		double val1 = calculateSimpsonFormula(numSeg, x, dof);
		numSeg *= 2;
		double val2 = calculateSimpsonFormula(numSeg, x, dof);
		if(Math.abs(val1-val2)<e){
			results.put("result", Double.toString(val2));
		}else{
			results = calculateResults(numSeg,x,dof);
		}
		return results;
	}
	
	/**
	 * 
	 * calculo de funcion gamma para numeros enteros
	 * @param number
	 * @return
	 */
	public static int calculateFactorialGamma(double number){
		if(number == 0)return 1;
		int result = 1;
		for(int i = 1 ; i < number; i++)result *= i;
		return result;
	}
	
	/**
	 * calculo de funcion gamma para numeros no enteros
	 * 
	 * @param number
	 * @return
	 */
	public static double calculateFactorialGammaNonInteger(double number){
		double result = 1;
		for(double i = number - 1 ; i > 0; i--){
			result *= i;
		}
		return result * Math.sqrt(Math.PI);
	}
}
