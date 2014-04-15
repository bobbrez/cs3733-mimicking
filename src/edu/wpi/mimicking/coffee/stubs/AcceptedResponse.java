package edu.wpi.mimicking.coffee.stubs;

import edu.wpi.mimicking.htcpcp.Response;

public class AcceptedResponse extends Response {
	public AcceptedResponse() {
		super(202, "Brewing.");
	}
}