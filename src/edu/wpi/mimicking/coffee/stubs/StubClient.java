package edu.wpi.mimicking.coffee.stubs;

import edu.wpi.mimicking.htcpcp.IHTCPCPClient;
import edu.wpi.mimicking.htcpcp.Request;
import edu.wpi.mimicking.htcpcp.Response;

public class StubClient implements IHTCPCPClient {
	private String response;
	
	public StubClient(String response) {
		this.response = response;
	}
	
	@Override
	public Response send(Request request) {
		String[] lines = response.split("\\|");
		return new Response(Integer.parseInt(lines[0]), lines[1]);
	}
}
