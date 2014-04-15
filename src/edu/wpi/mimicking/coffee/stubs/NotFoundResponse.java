package edu.wpi.mimicking.coffee.stubs;

import edu.wpi.mimicking.htcpcp.Response;

public class NotFoundResponse extends Response {
	public NotFoundResponse() {
		super(404, "Not Found.");
	}
}