package edu.wpi.mimicking.coffee.stubs;

import edu.wpi.mimicking.htcpcp.IHTCPCPClient;
import edu.wpi.mimicking.htcpcp.Request;
import edu.wpi.mimicking.htcpcp.Response;

public class StubClient implements IHTCPCPClient {
	private Response response;
	
	public StubClient(String response) {
	}
	
	public void setResponse(Response response) {
		this.response = response;
	}
	
	@Override
	public Response send(Request request) {
		return response;
	}
}
