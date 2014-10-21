package talks.models.server;

import java.io.*;
import java.net.*;

public class Server
{
	private ArrayList<ChatRoom> chatRoomList;
	private ArrayList<Node> nodes;
	public static void main(String[] args)
	throws Exception
	{
		if(args.length!=1)
		{
			System.out.println("Error in syntax");
			System.out.println("Usage: java Server -port");
			return;
		}
		int port;
		try
		{
			int port1 = Integer.parseInt(args[0]);
		}
		catch(NumberFormatException e)
		{
			System.out.println("port expected...");
			return;
		}
		ServerConnection sc;
		sc.port=port1;
		sc.connect(); /*remove accept from the server connection class */
		System.out.println("server started");
		while(true)
		{
			Socket cs = ss.accept();
			Thread t = new work_thread(cs);
			t.start();
		}
		ss.close();
	}

}
public class work_thread extends Thread
{
    Socket socket;
    work_thread(Socket socket)
    {
        this.socket=socket;
    }
	public void createChatRoom(String password,String description,ArrayList<Node> nodes,String identifier)
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
		if(cid==-1)
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
    }
}
