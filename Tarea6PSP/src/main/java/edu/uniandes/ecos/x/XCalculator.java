package edu.uniandes.ecos.x;

import edu.uniandes.ecos.calculator.RangeCalculator;

/**
 * @author andresgarcias4n
 * @since 15/04/2017
 * @version 0.0.1
 */
public class XCalculator {

	
	/**
	 * Variables de paquete
	 */
	double p;
	double dof;
	double startX = 1.0;
	double startD = 0.5;
	int recycle = 1;
	
	/**
	 * Metodo constructor
	 * 
	 * @param p
	 * @param dof
	 */
	public XCalculator(double p, double dof) {
		super();
		this.p = p;
		this.dof = dof;
	}

	/**
	 * Retorna el valor de X en la Tdist
	 * 
	 * @return
	 */
	public double calculateX(){
		getFirstX(this.startX,this.startD);
		if(!(Math.abs(RangeCalculator.calculateSimpsonFormula(10, this.startX, dof)-p)<0.00001 || this.recycle == 1000)){
			this.startD /= 2;
			this.recycle++;
			getFirstX(this.startX,this.startD);
			calculateX();
		}
		return this.startX;
	}
	
	/**
	 * 
	 * Calcula recursivamente el valor apropiado para x
	 * 
	 * @param xStart
	 * @param d
	 */
	public void getFirstX(double xStart, double d){
		double integral = RangeCalculator.calculateSimpsonFormula(10, xStart, dof);
		if(integral< p){
			xStart += d;
			if(RangeCalculator.calculateSimpsonFormula(10, xStart, dof) > p) this.startX = xStart -d;
			else getFirstX(xStart,d);
		}else{
			xStart -= d;
			if(RangeCalculator.calculateSimpsonFormula(10, xStart, dof) < p)this.startX = xStart +d;
			else getFirstX(xStart,d);
		}
	}
	
}
