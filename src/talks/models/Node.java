package talks.models;

import java.io.*;

/**
 * The Node class implements an abstraction of a 
 * particular person using chat application.
 * Communication takes place between two nodes 
 * representing the same person where one is on the
 * server and other on the client side.
 */
public class Node
{
    /** The unique id of the Node */
    private int id;

    /** The unique id of the chat room associated with this Node */
    private int chatRoomId;

    /** The name of the Node */
    private String name;

    /** The connection object associated with this Node */
    private Connection connection;

    /**
     * public constructor to initialize the instance variables
     */
    public Node(int id, int chatRoomId, String name, Connection connection)
    {
        this.id = id;
        this.chatRoomId = chatRoomId;
        this.name = name;
        this.connection = connection;
    }

    // Getter and setters
    public int getId()
    {
        return this.id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getChatRoomId()
    {
        return this.chatRoomId;
    }

    public void setChatRoomId(int chatRoomId)
    {
        this.chatRoomId = chatRoomId;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Connection getConnection()
    {
        return this.connection;
    }

    public void setConnection(Connection connection)
    {
        this.connection = connection;
    }

    /**
     * Sends 'message' from this Node
     *
     * @param message   The message to be sent
     * @throws IOException
     */
    public void sendMessage(Message message)
    throws IOException
    {
        this.connection.sendObject(message);
    }

    /**
     * Receives a message and returns it
     * This method blocks the I/O till the message is received
     *
     * @return  The message obtained from the server
     * @throws IOException
     */
    public Message receiveMessage()
    {
        Message message = (Message)this.connection.receiveObject();

        return message;
    }
}