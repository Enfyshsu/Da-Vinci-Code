import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server
{
	private static final int PORT = 8787;

	private static ArrayList<ClientHandler> clients = new ArrayList<>();
	private static ExecutorService pool = Executors.newFixedThreadPool(4);

	public static int randomNum = getRandomNum();
	public static int leftNum = 0, rightNum = 1000;

	public static void main(String[] args) throws IOException
	{
		//System.out.println("randomNum: " + randomNum); //print the number generate by getRandomNum();
		ServerSocket listener = new ServerSocket(8787);

		while(true)
		{
			System.out.println("[SERVER] Waiting for client connection...");
			Socket client = listener.accept();
			System.out.println("[SERVER] Connected to client");
			ClientHandler clientThread = new ClientHandler(client, clients);
			clients.add(clientThread);

			pool.execute(clientThread);
		}
	}

	private static int getRandomNum()
	{
		int randomNum = (int)(Math.random()*1000);
		return randomNum;
	}
}