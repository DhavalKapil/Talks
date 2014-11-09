package talks.models.client;

import java.io.*;
import java.net.Socket;

import talks.models.*;


/**
 *Connects the client to the Server
 */

public class ClientConnection extends Connection
{
	/** Host address */
	private String host;

	/**
	 * Constructor to intialize host and port
	 */
	public ClientConnection(String host, int port)
	{
		this.host = host;
		this.port = port;
	}
	
	/**
	 * Function to connect to the server
	 */
	public void connect()
	throws IOException
	{	
		socket = new Socket(host, port);
	}
	
}
