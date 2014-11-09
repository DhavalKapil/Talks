package talks.models.server;

import java.io.*;
import java.util.*;

import talks.models.*;

class ClientThread extends Thread
{
	/** 
	 * The Node representing the client 
	 *
	 * @var Node
	 */
	private Node node;

	public ClientThread(Node node)
	{
		this.node = node;
	}

	/**
	 * Function to send the id back to the node
	 */
	public void initializeNode()
	throws IOException, ClassNotFoundException
	{
		Message message = this.node.receiveMessage();
		this.node.setName(message.getMessage());

		message = new Message();
		message.setMessage(Integer.toString(node.getId()));
		message.setCreatorId(this.node.getId());

		this.node.sendMessage(message);
	}

	/**
	 * Function to create a chat room
	 */
	private void createChatRoom(Message message)
	throws IOException
	{	
		String[] contents = message.getMessage().split("\n");

		ArrayList<Node> nodes = new ArrayList<Node>();
		nodes.add(this.node);

		ChatRoom chatRoom = new ChatRoom(contents[0], contents[1], nodes, Server.chatRoomId++, contents[2]);
		Server.chatRoomList.add(chatRoom);
		Message returnMessage = new Message();
		returnMessage.setMessage(Integer.toString(chatRoom.getId()));
		returnMessage.setCreatorId(this.node.getId());

		Server.nodeIdRoomMaps.put(this.node.getId(), chatRoom);
		this.node.sendMessage(returnMessage);
	}

	/**
	 * Function to join a chatRoom
	 *
	 * 301 -> Successfully joined chatRoom
	 * 501 -> Wrong password
	 * 502 -> Chat room not found
	 */
	private void joinChatRoom(Message message)
	throws IOException
	{
		Message returnMessage = new Message();	

		returnMessage.setCreatorId(this.node.getId());
		returnMessage.setStatusCode(502);
		returnMessage.setMessage("Chat room not found");

		String[] identifierAndPassword = message.getMessage().split("\n");
		ChatRoom chatRoom = null;

		for(int i=0; i<Server.chatRoomList.size();i++)
		{
			if(Server.chatRoomList.get(i).getIdentifier().equals(identifierAndPassword[0]))
			{
				if(Server.chatRoomList.get(i).getPassword().equals(identifierAndPassword[1]))
				{
					chatRoom = Server.chatRoomList.get(i);

					chatRoom.insertNode(node);		
					Server.nodeIdRoomMaps.put(this.node.getId(), chatRoom);

					returnMessage.setStatusCode(301);
					returnMessage.setMessage(Integer.toString(chatRoom.getId()));

					// Pinging everyone that a new user has been added
					Message notice = new Message(202, this.node.getId(), this.node.getName());
					chatRoom.broadcast(notice);

					break;
				}
				else
				{
					returnMessage.setStatusCode(501);
					returnMessage.setMessage("Password is incorrect");
					break;
				}
			}
		}

		this.node.sendMessage(returnMessage);

		if(returnMessage.getStatusCode()==301)
		{
			for(Node n : chatRoom.getNodes())
			{
				Message m = new Message(203, n.getId(), n.getName());
				this.node.sendMessage(m);
			}
		}
	}

	private void forwardChat(Message message)
	throws IOException
	{
		ChatRoom chatRoom = Server.nodeIdRoomMaps.get(message.getCreatorId());

		chatRoom.broadcast(message);
	}

	/**
	 * Function to broadcast the message to all nodes in the chat group
	 */
	public void run()
	{
		try
		{
			initializeNode();
			// Node is initalized. Loop now over the various functions
			while(true)
			{
				Message message = node.receiveMessage();

				switch(message.getStatusCode())
				{
					// The protocol listing goes here
					case 101 : createChatRoom(message);
						break;
					case 102 : joinChatRoom(message);
						break;
					case 201 : forwardChat(message);
						break;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("ERROR: " + e.toString());
			e.printStackTrace();
		}
	}
}