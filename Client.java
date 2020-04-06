import java.net.*;
import java.io.*;

public class Client
{
	private static final String SERVER_IP = "localhost";
	private static final int SERVER_PORT = 8787;
	public static void main(String[] args) throws IOException
	{
		Socket socket = new Socket(SERVER_IP, SERVER_PORT);

		ServerConnection serverConn = new ServerConnection(socket);
		
		new Thread(serverConn).start(); //Multithreading: Create a Client thread
	}
}