package talks.models;

import java.util.Date;

/**
 * The Message class implements an abstraction for 
 * a message which is communicated between a client and the server.
 */
public class Message
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
	 * addTimeStamp() method stores the number of milliseconds
	 * between midnight of January 1, 1970 and the current date 
	 * in the private variable- timestamp
	 */
	public void addTimestamp()
	{
		Date current = new Date();
		timestamp = current.getTime();
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
	public void setTimestamp(long timestamp)
	{
		this.timestamp=timestamp;
	}
	
}

