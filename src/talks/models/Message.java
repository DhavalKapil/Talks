package models

import java.util.Date;


public class Message
{
	private int statusCode;
	private int creatorId;
	private String message;
	private long timestamp;

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

