package talks.models.server;

import java.io.*;

import talks.models.*;

class ClientThread extends Thread
{
	/** The Node representing the client */
	private Node node;

	public ClientThread(Node node)
	{
		this.node = node;
	}

	public void initializeNode()
	throws IOException
	{
		Message message = new Message();
		message.setMessage(Integer.toString(node.getId()));

		node.sendMessage(message);
	}

	/**
	 * @param: message , node
	 * @return: message: indicating whether it has joined a chatroom or not
	 *           001 -> chatroom joined
	 *           002 -> chatroom not found or wrong password 
	 */
	public Message joinChatRoom(String message, Node node)
	{
		Message returnMessage;
		String[] identifierAndPassword=message.split("\n");

		for(int i=0; i< chatRoomList.size();i++)
		{
			if(chatRoomList.get(i).identifier==identifierAndPassword[0])
			{
				if(chatRoomList.get(i).password==identifierAndPassword[1])
				{
					insertNode(node);
					returnMessage.setStatusCode(001);
					return returnMessage;
				}
			}
		}
		returnMessage.setStatusCode(002);
		return returnMessage;
	}

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
					case 102 : joinChatRoom(message,node);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("ERROR: " + e.toString());
		}
	}
}