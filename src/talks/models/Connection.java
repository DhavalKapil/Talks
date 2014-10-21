package talks.models;

import java.io.*;
import java.net.*;




	/**
        *Abstract class used for connecting server and client
        *and for exchange of information between them.
        */

abstract public class Connection
{
	/**Port number on which the server is running*/
	protected int port;

	/**Host address*/
	protected String host;

	/**Scoket object for sending and receiving information*/
	protected Socket socket;

	/**IO object*/
	private ObjectInputStream in=null;
	/**IO object*/
	private ObjectOutputStream out=null;
	
	//abstract public void connect();

	/**
         *Method for sending serialized object
         */
	public void sendObject(Object o)
	{
		
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




       /**
        *Method for receiving serialized object
        */
	public Object receiveObject()
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

       /**
        *Method for closing the socket
        */
	public void close()
	{
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
