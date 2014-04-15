package edu.wpi.mimicking.coffee.stubs;

import edu.wpi.mimicking.htcpcp.Response;

public class CreatedResponse extends Response {
	public CreatedResponse() {
		super(201, "Poured and ready.");
	}
}