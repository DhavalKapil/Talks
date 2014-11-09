package talks;

import talks.models.*;
import talks.models.client.*;
import talks.controllers.*;

/**
 * The main client class with the main function
 */
public class Client
{
	/**
	 * Private static function to ask something from the user
	 */
	public static String prompt(String message)
	{
		return javax.swing.JOptionPane.showInputDialog(message);
	}

	/**
	 * The public main function
	 */
	public static void main(String[] args)
	{
		try
		{	
			// Declaring variable
			String name, host;
			int port;
			
			// Taking input for the above variables
			name = prompt("Enter your name:");
			host = prompt("Enter destination IP");
			port = Integer.parseInt(prompt("Enter detination port"));
			
			// Checking for input
			if(name==null || host==null)
				System.exit(0);
			if(name.equals("") || host.equals(""))
				throw new Exception("Invalid name or address!");

			// Establishing Client connection
			ClientConnection connection = new ClientConnection(host, port);
			connection.connect();

			// Initializing a node
			Node node = new Node(0, 0, name, connection);

			int id = Integer.parseInt(node.receiveMessage().getMessage());
			node.setId(id);

			HomeController.display(node);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
}