package edu.wpi.mimicking.coffee.fakes;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;

import edu.wpi.mimicking.htcpcp.IHTCPCPClient;
import edu.wpi.mimicking.htcpcp.Request;
import edu.wpi.mimicking.htcpcp.Response;

public class FakeClient implements IHTCPCPClient {
	private String filepath = "fake_responses/";
	private String host;
	
	public FakeClient(String host) {
		this.host = host;
	}
	
	@Override
	public Response send(Request request) {
		List<String> lines;
		try {
			lines = Files.readAllLines(Paths.get(filepath + host + ".txt"), Charset.defaultCharset());
			return new Response(Integer.parseInt(lines.get(0)), lines.get(1));
		} catch (NoSuchFileException e) {
			return new Response(404, "Not Found.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Response(500, "Coffee-plosion!");
	}
}
