package talks.models.server;

import java.net.Socket;
import java.net.ServerSocket;

import talks.models.*;
import java.io.*;

public class ServerConnection extends Connection
{
	/**
	 * Constructor
	 */
	public ServerConnection(Socket socket)
	throws IOException
	{
		this.socket = socket;

		super.establishStreams();
	}
}
