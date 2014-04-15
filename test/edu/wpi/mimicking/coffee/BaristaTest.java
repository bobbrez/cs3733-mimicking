package edu.wpi.mimicking.coffee;

import static org.junit.Assert.*;

import org.junit.Test;

public class BaristaTest {
	/** 
	 * Dummy Example
	 **/
	@Test
	public void testWelcomeCustomer() {
		// Setup
		Barista barista = new Barista("Marty", null);
		String expectedWelcomeMsg = "Hello Bob, I'm Marty.";
		
		// Execute
		String actualWelcomeMsg = barista.welcomeMessage("Bob");
		
		// Verify
		assertEquals(expectedWelcomeMsg, actualWelcomeMsg);
	}

}
