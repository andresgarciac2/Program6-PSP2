package edu.uniandes.ecos.formater;


/**
 * @author andresgarcias4n
 * @since 02/04/2017
 * @version 0.0.1
 */
public class DataFormater {

	String[] data;
	
	/**
	 * Constructor
	 * 
	 * @param inputData
	 */
	public DataFormater(String inputData){
		data = inputData.split(",");
	}


	/**
	 * retorna los datos de entrada en un arreglo
	 * 
	 * @return data
	 */
	public String[] getData() {
		return data;
	}
	
	
}
