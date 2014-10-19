package talks.models;

import java.io.*;
import java.net.*;


abstract class Connection
{
	/*
	*Abstract class used for connecting server and client
 	*and for exchange of information between them.
	*/
	
	/*Port number on which the server is running*/
	protected int port;

	/*Host address*/
	protected String host;

	/*Scoket object for sending and receiving information*/
	protected Socket socket;

	/*IO object*/
	private ObjectInputStream in=null;
	/*IO object*/
	private ObjectOutputStream out=null;
	
	abstract void connect();

	public void sendObject(Object o)
	{
		/*
		*Method for sending serialized object
		*/
		try
		{
			out=new ObjectOutputStream(socket.getOutputStream());
			out.writeObject(o);
		}
		catch( Exception e)
		{
			e.printStackTrace();
		}
	}

	public Object receiveObject()
	{
		/*
		*Method for receiving serialized object
		*/
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
		/*
		*Method for closing the socket
		*/
		try
		{
			socket.close();
			System.out.println("Connection closed!!!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
