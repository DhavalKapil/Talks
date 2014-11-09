package talks.models.client;

import talks.models.*;
import talks.controllers.*;
import talks.views.*;

import java.util.*;

public class ClientReceiver extends Thread
{
	/** The node associated with the client */
	private Node node;

	/** The ChatFrame object where the messages are displayed */
	private ChatFrame chatFrame;

	/** The array of nodes in the group */
	private ArrayList<Node> nodes;

	/**
	 * Constructor
	 */
	public ClientReceiver(ChatFrame chatFrame)
	{
		this.chatFrame = chatFrame;
		this.node = this.chatFrame.getNode();

		this.nodes = new ArrayList<Node>();
		this.nodes.add(this.node);
	}

	/**
	 * Function to append the text in the Frame
	 */
	private void appendChatMessage(Message message)
	{
		int id = message.getCreatorId();

		String name = null;

		for(Node node : nodes)
		{
			if(node.getId()==id)
			{
				name = node.getName();
				break;
			}
		}

		this.chatFrame.append(name + " : " + message.getMessage() + "\n");
	}

	/**
	 * Function to add a new node in the list
	 */
	private void addNode(Message message)
	{
		String name = message.getMessage();

		Node node = new Node(message.getCreatorId());
		node.setName(name);

		this.nodes.add(node);

		this.chatFrame.append(name + " entered the ChatRoom\n");
	}

	/**
	 * Function to add a previous node in the list
	 */
	private void addPreviousNode(Message message)
	{
		String name = message.getMessage();

		Node node = new Node(message.getCreatorId());
		node.setName(name);

		this.nodes.add(node);
	}

	/**
	 * Removes a node that get's disconnected
	 */
	private void removeNode(Message message)
	{
		int id = message.getCreatorId();
		String name = null;

		for(Node node : nodes)
		{
			if(node.getId()==id)
			{
				name = node.getName();
				nodes.remove(node);
				break;
			}
		}

		this.chatFrame.append(name + " exited the ChatRoom\n");
	}

	public void run()
	{
		try
		{
			Message message;
			while( (message = this.node.receiveMessage()) != null)
			{
				switch(message.getStatusCode())
				{
					case 201 : appendChatMessage(message);
						break;
					case 202 : addNode(message);
						break;
					case 203 : addPreviousNode(message);
						break;
					case 204 : removeNode(message);
						break;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
}