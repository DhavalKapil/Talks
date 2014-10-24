import java.util.*;
import java.lang.*;
import java.io.*;

class functions
{
	public static int newChatRoomId;
	public void createChatRoom(String password,String description,ArrayList<Node> nodes,String identifier)
	{
		newChatRoomId++;
		ChatRoom obj=new ChatRoom(password,description,nodes,newChatRoomId,identifier);
	 	obj.insertNode(Node node);
	 	ChatRoomList.add(obj);
	}
}
