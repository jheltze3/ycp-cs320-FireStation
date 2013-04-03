package edu.ycp.CS320.client;

import javax.swing.JFrame;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;

import edu.ycp.CS320.shared.IPublisher;
import edu.ycp.CS320.shared.ISubscriber;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RichTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;

public class addEvent extends JFrame  {
	
	public static JFrame frame = new JFrame();
	private static final long serialVersionUID = 1L;


	public addEvent() {
		
		
		getContentPane().setLayout(null);
		
		JButton btnAddEvent = new JButton("Add Event");
		btnAddEvent.setBounds(290, 310, 89, 23);
		getContentPane().add(btnAddEvent);
	}

	public static void openFrame(){
		 frame = new JFrame("Add Event");
		frame.setLocationRelativeTo(null);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 700); //Size of main window
		frame.setVisible(true);
	
		
	}

	public void eventOccurred(Object key, IPublisher publisher, Object hint) {

	}
}

/*
 *  When the user clicks the ADD button a pop up screen for the user to enter the information
 *  When the user clicks the DELETE button it can remove an event from the "database"
 *  
 * Load the information from the database in reference to the DATE selected. 
 *  - checks to see if any events are scheduled for that day
 * 	- Displays all the events available for that day. 
 * 
 * 
 * 
 * 
 * */
