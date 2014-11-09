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
	public static void display(Node node)
	{
        new HomeFrame(node).setVisible(true);
	}
}