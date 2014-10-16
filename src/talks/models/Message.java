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
	
}
