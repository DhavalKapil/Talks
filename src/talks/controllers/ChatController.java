package talks.controllers;

import talks.models.*;
import talks.views.*;

/**
 * The controller that handles the CharFrame
 */
public class ChatController
{
	/**
	 * Function to display the ChatFrame
	 */
	public static void display(Node node)
	{
        new ChatFrame(node).setVisible(true);
	}
}