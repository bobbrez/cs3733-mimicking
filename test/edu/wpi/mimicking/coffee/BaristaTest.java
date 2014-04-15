package edu.wpi.mimicking.coffee;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;

import edu.wpi.mimicking.coffee.stubs.AcceptedResponse;
import edu.wpi.mimicking.coffee.stubs.CreatedResponse;
import edu.wpi.mimicking.coffee.stubs.NotFoundResponse;
import edu.wpi.mimicking.coffee.stubs.StubClient;
import edu.wpi.mimicking.htcpcp.Client;
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
		Request request = new Request();
		request.add("Cream");
		request.add("Sugar");
		
		Response expectedResponse = new Response(202, "Brewing.");
		
		Client mockClient = mock(Client.class);
		when(mockClient.send(request)).thenReturn(expectedResponse);
		
		Barista barista = new Barista("Marty", "coffee://tiki.cs.wpi.edu");
		barista.setClient(mockClient);
		
		// Execute
		Response actualResponse = barista.sendRequest(request);
		
		// Verify
		assertEquals(202, actualResponse.getStatus());
		assertEquals("Brewing.", actualResponse.getMessage());
		
		verify(mockClient).send(request);
	}
	
	@Test
	public void testSendRequestCreated() {		
		// Setup
		Request request = new Request();
		request.add("Cream");
		request.add("Sugar");
		
		Response expectedResponse = new Response(201, "Poured and ready.");
		
		Client mockClient = mock(Client.class);
		when(mockClient.send(request)).thenReturn(expectedResponse);
		
		Barista barista = new Barista("Marty", "coffee://tiki.cs.wpi.edu");
		barista.setClient(mockClient);
		
		// Execute
		Response actualResponse = barista.sendRequest(request);
		
		// Verify
		assertEquals(201, actualResponse.getStatus());
		assertEquals("Poured and ready.", actualResponse.getMessage());
		
		verify(mockClient).send(request);
	}
	
	@Test
	public void testSendRequestNotFound() {
		// Setup
		Request request = new Request();
		request.add("Cream");
		request.add("Sugar");
		
		Response expectedResponse = new Response(404, "Not Found.");
		
		Client mockClient = mock(Client.class);
		when(mockClient.send(request)).thenReturn(expectedResponse);
		
		Barista barista = new Barista("Marty", "coffee://tiki.cs.wpi.edu");
		barista.setClient(mockClient);
		
		// Execute
		Response actualResponse = barista.sendRequest(request);
		
		// Verify
		assertEquals(404, actualResponse.getStatus());
		assertEquals("Not Found.", actualResponse.getMessage());
		
		verify(mockClient).send(request);
	}
}
