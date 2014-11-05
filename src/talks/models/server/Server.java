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
class work_thread extends Thread
{
    ServerConnection server_c;
    work_thread(ServerConnection server_c)
    {
        this.server_c=server_c;
    }
/*	public void createChatRoom(String password,String description,ArrayList<Node> nodes,String identifier)
	{
		ChatRoom obj=new ChatRoom(password,description,nodes,chatRoomList.size()+1,identifier);
		if(chatRoomList.size()==0)
		{
			chatRoomList.add(1);
		}
		chatRoomList.add(chatRoomList[chatRoomList.size()-1]+1)	;
		nodes[0].setChatRoomId(chatRoomList[chatRoomList.size()-1]);
	}
    public void run()
    {
        boolean flag=true;
        try
        {
	    DataInputStream ip = new DataInputStream(socket.getInputStream());
	    DataOutputStream op = new DataOutputStream(socket.getOutputStream());
            while (flag)
            {

		op.println("Welcome to the chatroom");
		Message m=ip.recieveObject();
		int cid=m.getChatRoomId();
		/* send chatroom id = -1 in the message if a new chatroom is to be created */
		/*if(cid==-1)
		{
			op.println("Set password for the new chatroom");
			String password=ip.readLine();
			op.println("Set description for the chatroom");
			String description=ip.readLine();
			op.println("Set the identifier for the chatroom");
			String identifier=ip.readLine();
			ArrayList<Node> newNodeList;
			newNodeList.add(nodes.get(m.getCreatorId()));
			createChatRoom(password,description,newNodeList,identifier);
		}
		else
		{
			chatRoomList[cid].broadcast(m);
		}

            }
            socket.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }*/
}
