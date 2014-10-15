import java.net.Socket;
import java.net.ServerSocket;

public class ServerConnection extends Connection
{
	private ServerSocket serverSocket=null;
	public void connect()
	{
		try
		{
			serverSocket=new ServerSocket(port);
			socket=serverSocket.accept();
		}
		catch(Exception e)
		{e.printStackTrace();}
	}
}
