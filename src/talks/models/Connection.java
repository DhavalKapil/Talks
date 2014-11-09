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

	/** Scoket object for sending and receiving information */
	protected Socket socket;

	/** The input stream object */
	private ObjectInputStream in;

	/** The output stream object */
	private ObjectOutputStream out;

	/**
	 * Function to establish streams
	 */
	protected void establishStreams()
	throws IOException
	{
		this.in = new ObjectInputStream(this.socket.getInputStream());

		this.out = new ObjectOutputStream(this.socket.getOutputStream());
	}
	
	/**
     * Method for sending serialized object
     */
	public void sendObject(Object o)
	throws IOException
	{
		out.writeObject(o);
	}

    /**
     * Method for receiving serialized object
     */
	public Object receiveObject()
	throws IOException, ClassNotFoundException
	{	
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
