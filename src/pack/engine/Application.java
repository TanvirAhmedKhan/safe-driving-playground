/**
* Author Name: Tanvir Ahmed Khan and Jagadish Kodigehalli        Malleshaiah
 * Problem Description: A simulated safe-driving practice test program allows a user to be aware of road safety. 
 * date:22/9/2017
 * ID:100864675
 * ID:101003877
 * Email: 100864675@student.swin.edu.au
 * Email: 1003877@student.swin.edu.au
 * */


/**
 * This is the Application file where Main function start the Activity
 * */
package pack.engine;

import java.awt.EventQueue;

import javax.swing.JFrame;

import pack.ui.Initiation;
import pack.ui.Test;

public class Application {

	
	
	public static void main(String[] args) {
		
		try {
			Initiation window = new Initiation();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
