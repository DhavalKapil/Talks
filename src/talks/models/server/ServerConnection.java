package talks.models.server;

import java.net.Socket;
import java.net.ServerSocket;

import talks.models.*;

public class ServerConnection extends Connection
{
	/**
	 * Constructor
	 */
	public ServerConnection(Socket socket)
	{
		this.socket = socket;
	}
}
