package talks.models.server;
import java.util.*;
import java.io.*;
import java.net.*;

public class Server
{
	//private ArrayList<ChatRoom> chatRoomList;
	//private ArrayList<Node> nodes;
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
			port= Integer.parseInt(args[0]);
		}
		catch(NumberFormatException e)
		{
			System.out.println("port expected...");
			return;
		}
		ServerSocket server_socket=new ServerSocket(port);
		/*remove accept from the server connection class */
		System.out.println("server started");
		while(true)
		{
			Socket s=server_socket.accept();
			ServerConnection server_connection=new ServerConnection(s);
			Thread t = new work_thread(server_connection);
			t.start();
		}
		//server_socket.close();
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
