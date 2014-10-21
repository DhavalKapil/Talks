package talks.models.server;

import java.net.Socket;
import java.net.ServerSocket;

import talks.models.*;

public class ServerConnection extends Connection
{
	private ServerSocket serverSocket=null;


	public ServerConnection(Socket s)
	{
		socket=s;
	}


	/*public void connect()
	{
		try
		{
			serverSocket=new ServerSocket(port);
			socket=serverSocket.accept();
		}
		catch(Exception e)
		{e.printStackTrace();}
	}*/
}
