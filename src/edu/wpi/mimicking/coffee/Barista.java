package edu.wpi.mimicking.coffee;

import edu.wpi.mimicking.htcpcp.Client;

public class Barista {
	private String name;
	private Client client;
	
	public Barista(String name, String host) {
		this.name = name;
		this.client = new Client(host);
	}
	
	public String welcomeMessage(String customerName) {
		return "Hello " + customerName + ", I'm " + name + ".";
	}
}
