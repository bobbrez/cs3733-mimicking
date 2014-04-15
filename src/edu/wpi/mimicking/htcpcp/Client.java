package edu.wpi.mimicking.htcpcp;

public class Client implements IHTCPCPClient {
	private String host;
	
	public Client(String host) {
		this.host = host;
	}
	
	@Override
	public Response send(Request request) {
		// Not yet implemented
		return null;
	}
}
