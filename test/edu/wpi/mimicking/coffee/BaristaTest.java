package edu.wpi.mimicking.coffee;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.wpi.mimicking.coffee.stubs.AcceptedResponse;
import edu.wpi.mimicking.coffee.stubs.CreatedResponse;
import edu.wpi.mimicking.coffee.stubs.NotFoundResponse;
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
		((StubClient)barista.client()).setResponse(new AcceptedResponse());
		
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
		((StubClient)barista.client()).setResponse(new CreatedResponse());
		
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
		((StubClient)barista.client()).setResponse(new NotFoundResponse());
		
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
