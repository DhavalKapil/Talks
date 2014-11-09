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
	public static void display()
	{
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatFrame().setVisible(true);
            }
        });
	}
}