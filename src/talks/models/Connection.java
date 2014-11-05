package talks.models;

import java.io.*;
import java.net.*;

/**
 *Abstract class used for connecting server and client
 *and for exchange of information between them.
*/
abstract public class Connection
{
	/** Port number on which the server is running */
	protected int port;

	/** Host address */
	protected String host;

	/** Scoket object for sending and receiving information */
	protected Socket socket;

	/** The input stream object */
	private ObjectInputStream in;

	/** The output stream object */
	private ObjectOutputStream out;
	
	/**
     * Method for sending serialized object
     */
	public void sendObject(Object o)
	throws IOException
	{
		out = new ObjectOutputStream(socket.getOutputStream());
		out.writeObject(o);
	}

    /**
     * Method for receiving serialized object
     */
	public Object receiveObject()
	throws IOException, ClassNotFoundException
	{	
		in = new ObjectInputStream(socket.getInputStream());
		Object o = (Object)in.readObject();

		return o;		
	}

    /**
     * Method for closing the socket
     */
	public void close()
	throws IOException
	{
		socket.close();
	}	
}
