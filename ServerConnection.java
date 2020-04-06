import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;

public class ServerConnection implements Runnable
{
	private Socket server;
	private BufferedReader in;
	private PrintWriter out;
	public ServerConnection(Socket s) throws IOException
	{
		server = s;
		in = new BufferedReader(new InputStreamReader(server.getInputStream()));
		out = new PrintWriter(server.getOutputStream(), true);
	}

	@Override
	public void run()
	{
		try
		{
			String num;
			while(true)
			{	
				String serverResponse = in.readLine();
				
				if(serverResponse.contains("Ohhh no You lose QQ") || serverResponse.contains("Good Bye~~"))
				{
					JOptionPane.showMessageDialog(null, serverResponse, "Bye ><", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
				else if(serverResponse.contains("Please enter number in"))
				{
					num = JOptionPane.showInputDialog(null, serverResponse, "Da VinCi Code Game (Range Error)", JOptionPane.ERROR_MESSAGE);
					out.println(num);
				}
				else
				{
					num = JOptionPane.showInputDialog(null, serverResponse, "Da VinCi Code Game", JOptionPane.QUESTION_MESSAGE);
					out.println(num);
				}
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				in.close();
				out.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}