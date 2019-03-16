package networking;
import java.net.*;
import java.io.*;

public class Client extends Thread{
	public static void main(String[] args) {

		//String serverName = args[0];
		String serverName = "192.168.1.37";
		
		//int port = Integer.parseInt(args[1]);
		int port = 5450;
		try {
			System.out.println("Connecting to " + serverName + " on port " + port);
			Socket client = new Socket(serverName, port);

			System.out.println("client Just connected to " + client.getRemoteSocketAddress());
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);

			out.writeUTF("Hello from " + client.getLocalSocketAddress());
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);

			System.out.println("Server says " + in.readUTF());
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}