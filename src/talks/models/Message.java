package talks.models;

import java.util.Date;
import java.io.*;

/**
 * The Message class implements an abstraction for 
 * a message which is communicated between a client and the server.
 */
public class Message implements Serializable
{
	/** The status of the message */
	private int statusCode;

	/** The unique id of the creator */
	private int creatorId;

	/** The main message content */
	private String message;

	/** The unique timestamp of the message */
	private long timestamp;

	/**
	 * Constructor to initialize a blank message
	 */
	public Message()
	{
		this(0,0,null);
	}

	/**
	 * The constructor to initialize a message
	 */
	public Message(int statusCode, int creatorId, String message)
	{
		this.statusCode = statusCode;
		this.creatorId = creatorId;
		this.message = message;
	}

	//getters and setters

	public int getStatusCode()
	{
		return statusCode;
	}
	public void setStatusCode(int statusCode)
	{
		this.statusCode=statusCode;
	}

	public int getCreatorId()
	{
		return creatorId;
	}
	public void setCreatorId(int creatorId)
	{
		this.creatorId=creatorId;
	}

	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message=message;
	}

	public long getTimestamp()
	{
		return timestamp;
	}

	/**
	 * addTimeStamp() method stores the number of milliseconds
	 * between midnight of January 1, 1970 and the current date 
	 * in the private variable- timestamp
	 */
	public void addTimestamp()
	{
		Date current = new Date();
		timestamp = current.getTime();
	}
}

