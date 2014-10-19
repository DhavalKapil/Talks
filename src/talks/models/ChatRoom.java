package talks.models;

import java.io.*;
import java.util.*;

/**
 * The ChatRoom class implements the abstraction of a chatroom
 * by sending the messages received from the server to all
 * the client side nodes. 
 */

public class ChatRoom
{
	/** The unique password of the chatroom */
	private String password;

	/** The description of the chatroom */
	private String description;

	/** nodes lists all the client-side nodes */
	private ArrayList<Node> nodes;

	/** The unique id of the chatroom */
	private int id;

	/** The unique String of the chatroom that user uses to access it */
	private String identifier;

	/** The broadcast method sends messages received from the server to all the nodes  */
	public void broadcast(Message message)
	throws IOException
	{
		int len=nodes.size();
		for(int i=0;i<len;i++)
		{
             nodes.get(i).sendMessage(message);
		}    
	}
    
    /** The insertNode method inserts a new node when a new client is added to the chatroom */
	public void insertNode(Node node)
	{
         nodes.add(node);
	}

	//getters and setters

	public void setPassword(String password)
	{
		this.password=password;
	}
	public String getPassword()
	{
		return password;
	}
	public void setDescription(String description)
	{
		this.description=description;
	}
	public String getDescription()
	{
		return description;
	}
	public ArrayList<Node> getNodes()
	{
		return nodes;
	}
    public void setNodes(ArrayList<Node> nodes)
    {
         this.nodes=nodes;
    }
	public void setId(int id)
	{
		this.id=id;
	}
	public int getId()
	{
		return id;
	}
	public void setIdentifier(String identifier)
	{
		this.identifier=identifier;
	}
	public String getIdentifier()
	{
		return identifier;
	}
}