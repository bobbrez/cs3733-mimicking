package edu.wpi.mimicking.htcpcp;

import java.util.ArrayList;
import java.util.List;

public class Request {
	private List<String> additions;
	
	public Request() {
		additions = new ArrayList<String>();
	}
	
	public Request(List<String> additions) {
		this.additions = additions;
	}
	
	public void add(String addition) {
		additions.add(addition);
	}
	
	public String toString() {
		String header = "Accept-Additions=";
		for(String addition : additions) {
			header += addition + " ";
		}
		return header.trim();
	}
}