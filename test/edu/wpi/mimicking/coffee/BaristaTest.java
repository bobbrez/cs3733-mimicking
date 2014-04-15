package edu.wpi.mimicking.coffee;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.wpi.mimicking.coffee.stubs.StubClient;
import edu.wpi.mimicking.htcpcp.Request;
import edu.wpi.mimicking.htcpcp.Response;

public class BaristaTest {
	/** 
	 * Stub Example 1
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
	
	@Test
	public void testSendRequestOk() {
		// Setup
		Barista barista = new Barista("Marty", "coffee://tiki.cs.wpi.edu");
		Response cannedResponse = new Response(202, "Brewing."); 
		((StubClient)barista.client()).setResponse(cannedResponse);
		
		Request request = new Request();
		request.add("Cream");
		request.add("Sugar");
		
		// Execute
		Response response = barista.sendRequest(request);
		
		// Verify
		assertEquals(202, response.getStatus());
		assertEquals("Brewing.", response.getMessage());
	}
	
	@Test
	public void testSendRequestCreated() {
		// Setup
		Barista barista = new Barista("Marty", "coffee://tiki.cs.wpi.edu");
		Response cannedResponse = new Response(201, "Poured and ready."); 
		((StubClient)barista.client()).setResponse(cannedResponse);
		
		Request request = new Request();
		request.add("Cream");
		request.add("Sugar");
		
		// Execute
		Response response = barista.sendRequest(request);
		
		// Verify
		assertEquals(201, response.getStatus());
		assertEquals("Poured and ready.", response.getMessage());
	}
	
	@Test
	public void testSendRequestNotFound() {
		// Setup
		Barista barista = new Barista("Marty", "coffee://tiki.cs.wpi.edu");
		Response cannedResponse = new Response(404, "Not Found."); 
		((StubClient)barista.client()).setResponse(cannedResponse);
		
		Request request = new Request();
		request.add("Cream");
		request.add("Sugar");
		
		// Execute
		Response response = barista.sendRequest(request);
		
		// Verify
		assertEquals(404, response.getStatus());
		assertEquals("Not Found.", response.getMessage());
	}
}
