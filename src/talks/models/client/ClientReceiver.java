package talks.models.client;

import talks.models.*;
import talks.controllers.*;
import talks.views.*;

public class ClientReceiver extends Thread
{
	/** The node associated with the client */
	private Node node;

	/** The ChatFrame object where the messages are displayed */
	private ChatFrame chatFrame;

	public ClientReceiver(ChatFrame chatFrame)
	{
		this.chatFrame = chatFrame;
		this.node = this.chatFrame.getNode();
	}

	private void appendChatMessage(Message message)
	{
		this.chatFrame.append(message.getCreatorId() + " : " + message.getMessage());
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
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
}