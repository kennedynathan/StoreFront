package test;

import org.junit.Assert;
import org.junit.Test;

import app.SalableProduct;


public class SalableTest
{
	@Test
	public void testGetName()
	{
		SalableProduct salable = new SalableProduct("name", "description", 1.1, 10);
		
		Assert.assertEquals("name", salable.getName());
		
		salable = new SalableProduct();
		//Fail
		Assert.assertEquals("", salable.getName());
		
	}
	
	@Test
	public void testGetDescription()
	{
		SalableProduct salable = new SalableProduct("name", "description", 1.1, 10);
		
		Assert.assertEquals("description", salable.getDescription());
		
		salable = new SalableProduct();
		//Fail
		Assert.assertEquals("", salable.getDescription());
		
	}
	
	@Test
	public void testGetPrice()
	{
		SalableProduct salable = new SalableProduct("name", "description", 1.1, 10);
		
		Assert.assertEquals(1.1, salable.getPrice(), .01);
		
		salable = new SalableProduct();
		
		Assert.assertEquals(0, salable.getPrice(), .01);
		
	}
	
	@Test
	public void testGetQuantity()
	{
		SalableProduct salable = new SalableProduct("name", "description", 1.1, 10);
		
		Assert.assertEquals(10, salable.getQuantity());
		
		salable = new SalableProduct();
		
		Assert.assertEquals(0, salable.getQuantity());
		
	}
	
	@Test
	public void testAddQuantity()
	{
		SalableProduct salable = new SalableProduct("name", "description", 1.1, 10);
		
		salable.addQuantity(10);
		
		Assert.assertEquals(20, salable.getQuantity());
		
		salable.addQuantity(-1);
		
		Assert.assertEquals(19, salable.getQuantity());
		
		
	}
	
	@Test
	public void testRemoveQuantity()
	{
		SalableProduct salable = new SalableProduct("name", "description", 1.1, 10);
		
		salable.removeQuantity(5);
		
		Assert.assertEquals(5, salable.getQuantity());
		
		salable.removeQuantity(-5);
		
		Assert.assertEquals(10, salable.getQuantity());
		
	}
	
	@Test
	public void testSetQuantity()
	{
		SalableProduct salable = new SalableProduct("name", "description", 1.1, 10);
		
		salable.setQuantity(100);
		
		Assert.assertEquals(100, salable.getQuantity());
		
	    salable.setQuantity(-5);
	    
	    Assert.assertEquals(-5, salable.getQuantity());
	}
	
	@Test
	public void testCompareTo()
	{
		SalableProduct first = new SalableProduct("Sword", "Made for slashing", 15.9, 15);
		SalableProduct second = new SalableProduct("Sword", "Made for blocking", 52.5, 5);
		
		Assert.assertEquals(-1, first.compareTo(second));
		Assert.assertEquals(1, second.compareTo(first));
		
		second = new SalableProduct("Sword", "Made for slashing", 15.9, 15);
		
		Assert.assertEquals(0, first.compareTo(second));
		
	}
}