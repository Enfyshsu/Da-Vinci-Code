import java.net.*;
import java.io.*;
import java.util.ArrayList;


public class ClientHandler implements Runnable
{
	private Socket client;
	private BufferedReader in;
	private PrintWriter out;
	private ArrayList<ClientHandler> clients;

	public ClientHandler(Socket clientSocket, ArrayList<ClientHandler> clients) throws IOException
	{
		this.client = clientSocket;
		this.clients = clients;
		in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		out = new PrintWriter(client.getOutputStream(), true);
	}

	@Override
	public void run()
	{
		try
		{
			out.println("Enter number in " + Server.leftNum + " ~ " + Server.rightNum + " ( Type 'stop' to quit the game. )");
			while(true)
			{	
				String num = in.readLine();
				if(num.contains("stop"))
				{
					out.println("Good Bye~~");
					client.close();
					break;
				}
				else
				{
					int clientNum = Integer.parseInt(num);
					if(clientNum == Server.randomNum)
					{
						out.println("Ohhh no You lose QQ");
						client.close();
						break;
					}
					else if(clientNum > Server.randomNum)
					{
						if(clientNum > Server.rightNum) out.println("Please enter number in " + Server.leftNum + " ~ " + Server.rightNum);
						else
						{
							Server.rightNum = clientNum;
							out.println(Server.leftNum + " ~ " + Server.rightNum + ", keep going!!");
						}
					}
					else if(clientNum < Server.randomNum)
					{
						if(clientNum < Server.leftNum) out.println("Please enter number in " + Server.leftNum + " ~ " + Server.rightNum);
						else
						{
							Server.leftNum = clientNum;
							out.println(Server.leftNum + " ~ " + Server.rightNum + ", keep going!!");
						}
					}
				}
			}
		}
		catch(IOException e)
		{
			System.err.println("IO exception in client handler.");
			System.err.println(e.getStackTrace());
		}
		finally
		{
			out.close();
			try
			{
				in.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}