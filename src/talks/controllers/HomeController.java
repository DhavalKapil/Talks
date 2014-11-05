package talks.controllers;

import talks.models.*;
import talks.views.*;

/**
 * The controller that handles the HomeFrame
 */
public class HomeController
{
	/**
	 * Function to display the HomeFrame
	 */
	public static void display()
	{
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeFrame().setVisible(true);
            }
        });
	}
}