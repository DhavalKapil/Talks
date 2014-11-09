package talks.models.server;

import java.util.*;
import java.io.*;
import java.net.*;

import talks.models.*;

/**
 * Main Server class
 */
public class Server
{
	/**
	 * Array of chat rooms that are created by the clients
	 *
	 * @var ArrayList<ChatRoom>
	 */
	static ArrayList<ChatRoom> chatRoomList;

	/**
	 * Array of Nodes
	 *
	 * @var ArrayList<ChatRoom>
	 */
	static ArrayList<Node> nodes;

	/**
	 * A mapping of the node id's versus it's chat group
	 *
	 * @var HashMap<Integer, ChatRoom>
	 */
	static HashMap<Integer, ChatRoom> nodeIdRoomMaps;

	/**
	 * Static variables to hold the counter for the id of node and chatRoom
	 */
	static int nodeId = 1;
	static int chatRoomId = 1;

	/**
	 * Main method to that starts the server
	 */
	public static void main(String[] args)
	throws Exception
	{
		int port;

		if(args.length!=1)
		{
			System.out.println("Error in syntax");
			System.out.println("Usage: java Server -port");
			return;
		}
		
		try
		{
			port = Integer.parseInt(args[0]);
		}
		catch(NumberFormatException e)
		{
			System.out.println("Number expected");
			return;
		}

		ServerSocket serverSocket = new ServerSocket(port);

		System.out.println("Server started");

		while(true)
		{
			Socket socket = serverSocket.accept();

			ServerConnection serverConnection = new ServerConnection(socket);

			Node node = new Node(nodeId++);
			node.setConnection(serverConnection);
			nodes.add(node);

			Thread thread = new ClientThread(node);
			thread.start();
		}
	}

}
