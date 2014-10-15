package talks.models;

import java.io.*;
import java.net.*;


abstract class Connection
{
	protected int port;
	protected String host;
	protected Socket socket;
	private ObjectInputStream in=null;
	private ObjectOutputStream out=null;
	
	abstract void connect();

	public void sendObject(Object o)
	{
		try
		{
			out=new ObjectOutputStream(socket.getOutputStream());
			out.writeObject(o);
		}
		catch( Exception e)
		{e.printStackTrace();}
	}

	public Object recieveObject()
	{
		try
		{
			in=new ObjectInputStream(socket.getInputStream());
			Object o=(Object)in.readObject();
			return o;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		
	}

	public void close()
	{
		try
		{
			socket.close();
			System.out.println("Connection closed!!!");
		}
		catch(Exception e)
		{e.printStackTrace();}
	}
	
}
