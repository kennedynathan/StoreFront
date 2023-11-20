package adminApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class AdminService {
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	
	//Creates print write from client socket and creates buffered reader
	
	public void start(String ip, int port) throws IOException {
		clientSocket = new Socket(ip, port);
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
	}
	
	// Send a message to the server and return response
	public String sendMessage(String msg) throws IOException {
		out.println(msg);
		return in.readLine();
	}
	
	//Takes in json and adds U command sending the inventory to the server to update
	public String sendInventory(String json) throws IOException {
		out.println("U-" + json);
		return in.readLine();
	}
	//Sends the R command to get the inventory 
	public String readInventory() throws IOException {
		out.println("R");
		return in.readLine();
	}
	//Close all sockets and readers
	public void cleanUp() throws IOException {
		in.close();
		out.close();
		clientSocket.close();
	}
}
