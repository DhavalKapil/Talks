package talks.models;

import java.io.*;
import java.net.Socket;

public class ClientConnection extends Connection
{
	/*Connects the client to the Server*/
	public void connect()
	{
		try
		{
			socket=new Socket(host,port);
			System.out.println("Connected to Server :D!!!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
