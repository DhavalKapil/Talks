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
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("ERROR: " + e.toString());
		}
	}
}