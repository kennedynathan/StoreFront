package test;

import org.junit.Assert;
import org.junit.Test;

import app.Health;

public class HealthTest
{
	@Test
	public void testGetHP()
	{
		Health health = new Health("name", "Description", 1.1, 10, 25);
		
		Assert.assertEquals(25, health.getHealth());
		
		health = new Health();
		
		Assert.assertEquals(0, health.getHealth());
	}
	
	@Test
	public void testToString()
	{
		Health health = new Health("name", "description", 1.1, 10, 25);
		
		Assert.assertEquals("Name: name\nDescription: description\nPrice: 1.1\nQuantity: 10\nHealth: 25", health.toString());
		
		health = new Health();
		
		Assert.assertEquals("Name: \nDescription: \nPrice: 0.0\nQuantity: 0\nHealth: 0", health.toString());


	}
}