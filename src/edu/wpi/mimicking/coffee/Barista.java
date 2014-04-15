package edu.wpi.mimicking.coffee;

import edu.wpi.mimicking.coffee.fakes.FakeClient;
import edu.wpi.mimicking.htcpcp.IHTCPCPClient;
import edu.wpi.mimicking.htcpcp.Request;
import edu.wpi.mimicking.htcpcp.Response;

public class Barista {
	private String name;
	private IHTCPCPClient client;
	
	public Barista(String name, String host) {
		this.name = name;
		this.client = new FakeClient(host);
	}
	
	public String welcomeMessage(String customerName) {
		return "Hello " + customerName + ", I'm " + name + ".";
	}
	
	public Response sendRequest(Request request) {
		return client.send(request);
	}
}
