package edu.wpi.mimicking.htcpcp;

public class Response {
	private int status;
	private String message;
	
	public Response() {
	}
	
	public Response(int status, String message) {
		this.status = status;
		this.message = message;
	}
	
	public String toString() {
		return "<" + status + "> " + message;
	}
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}