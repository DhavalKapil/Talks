package talks.models;

import java.io.*;
import java.net.Socket;

public class ClientConnection extends Connection
{
	public void connect()
	{
		try
		{
			socket=new Socket(host,port);
			System.out.println("Connected to Server :D!!!");
		}
		catch(Exception e)
		{e.printStackTrace();}
	}
	
}
