package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class orderTest {

	@Test
	public void testOrderID() {
		Order test = new Order();
		int output = test.getOrderid(1);
		assertEquals(1, output);
	}
	
	@Test
	public void testCustName() {
		Order test = new Order();
		String output = test.getCustomername("John");
		assertEquals("John", output);
	}
	
	@Test
	public void testNdc() {
		Order test = new Order();
		long output = test.getNdc(256);
		assertEquals(256, output);
	}
	
	@Test
	public void testEmail() {
		Order test = new Order();
		String output = test.getEmail("jawad@gmail.com");
		assertEquals("jawad@gmail.com", output);
	}
	
	@Test
	public void testQuantity() {
		Order test = new Order();
		int output = test.getQuantity(500);
		assertEquals(500, output);
	}
	
	
	@Test
	public void testStrength() {
		Order test = new Order();
		int output = test.getStrength(5);
		assertEquals(5, output);
	}
	
		
	}

