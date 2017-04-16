package edu.uniandes.ecos.formater;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DataFormaterTest {

	@Test
	public void DataFormaterTestSize(){
		DataFormater formater = new DataFormater("1,5,5");
		assertTrue(formater.getData().length == 3);
	}
	
	@Test
	public void DataFormaterTestNotNull(){
		DataFormater formater = new DataFormater("1,5,5");
		assertTrue(formater.getData() != null);
	}
	
}
