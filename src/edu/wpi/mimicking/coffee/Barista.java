package edu.wpi.mimicking.coffee;

import edu.wpi.mimicking.coffee.stubs.StubClient;
import edu.wpi.mimicking.htcpcp.Client;
import edu.wpi.mimicking.htcpcp.IHTCPCPClient;
import edu.wpi.mimicking.htcpcp.Request;
import edu.wpi.mimicking.htcpcp.Response;

public class Barista {
	private String name;
	private IHTCPCPClient client;
	
	public Barista(String name, String host) {
		this.name = name;
		if(isTestMode()) {
			this.client = new StubClient(host);
		} else {
			this.client = new Client(host);
		}
	}
	
	public String welcomeMessage(String customerName) {
		return "Hello " + customerName + ", I'm " + name + ".";
	}
	
	public Response sendRequest(Request request) {
		return client.send(request);
	}
	
	public IHTCPCPClient client() {
		return client;
	}
	
	public void setClient(IHTCPCPClient client) {
		this.client = client;
	}
	
	private boolean isTestMode() {
		return System.getenv("mode") != null && System.getenv("mode").equals("TEST");
	}
}
