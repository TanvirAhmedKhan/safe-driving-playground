/**
 * Author Name: Tanvir Ahmed Khan and Jagadish Kodigehalli Malleshaiah
 * Problem Description: A simulated safe-driving practice test program allows a user to be aware of road safety. 
 * date:22/9/2017
 * ID:100864675
 * ID:101003877
 * Email: 100864675@student.swin.edu.au
 * Email: 101003877@student.swin.edu.au

 * */


/*
 * Main Application window, which request Another class to provide the panel where all the activities are going to run. this pages is used to control the applications 
 * */
package pack.ui;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.*;


public class SafeDrivingTest{

	public JFrame frame;
	private ImageIcon school;
    public String name;
    Color PreferedwindowColor;
    JPanel panel ;
    public int testId;
    
    
    
    
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SafeDrivingTest window = new SafeDrivingTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public SafeDrivingTest(String name,String windowColor, int testId) {
		this.testId= testId;
		this.name = name;
		switch(windowColor){
			case "black":
				PreferedwindowColor = Color.decode("#616161");
				break;
			case "red":
				PreferedwindowColor = Color.decode("#ffc1e3");
				break;
			case "green":
				PreferedwindowColor = Color.decode("#69F0AE");
				break;
			case "white":
				PreferedwindowColor = Color.decode("#F3E5F5");
				break;
			case "blue":
				PreferedwindowColor = Color.decode("#81D4FA");
				break;
				
		}
		
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(){
		frame = new JFrame();
		frame.getContentPane().setBackground(PreferedwindowColor);
		frame.setBounds(100, 100, 825, 512);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		panel = new Test(testId);
		
		panel.setBounds(10, 32, 789, 174);
		frame.getContentPane().add(panel);
		
		
		JButton btnStop = new JButton("stop c1");
		btnStop.setBounds(10, 365, 89, 23);
		frame.getContentPane().add(btnStop);
		
		JButton btnStopC = new JButton("stop c2");
		btnStopC.setBounds(112, 365, 89, 23);
		frame.getContentPane().add(btnStopC);
		
		JButton btnStopC_1 = new JButton("stop c3");
		btnStopC_1.setBounds(211, 365, 89, 23);
		frame.getContentPane().add(btnStopC_1);
		
		JButton btnSlowDown = new JButton("slow down");
		btnSlowDown.setBounds(10, 398, 89, 23);
		frame.getContentPane().add(btnSlowDown);
		
		JButton btnSlowDown_1 = new JButton("slow down");
		btnSlowDown_1.setBounds(112, 398, 89, 23);
		frame.getContentPane().add(btnSlowDown_1);
		
		JButton btnSlowDown_2 = new JButton("slow down");
		btnSlowDown_2.setBounds(211, 398, 89, 23);
		frame.getContentPane().add(btnSlowDown_2);
		
		JLabel lblWelcome = new JLabel("Welcome, "+name);
		lblWelcome.setBounds(10, 11, 216, 14);
		frame.getContentPane().add(lblWelcome);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(329, 217, 420, 170);
		frame.getContentPane().add(textArea);
		
		JButton btnGetBackTo = new JButton("Get back to dashboard");
		btnGetBackTo.setVisible(false);
		btnGetBackTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnGetBackTo.setBounds(564, 419, 141, 23);
		frame.getContentPane().add(btnGetBackTo);
		
		btnStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((Test) panel).stopCar(1);
				
			}
		});
		
		btnStopC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((Test) panel).stopCar(2);
				
			}
		});
		
		btnStopC_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((Test) panel).stopCar(3);
				
			}
		});
		
		
		btnSlowDown.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((Test) panel).slow(1);
				
			}
		});
        
		btnSlowDown_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((Test) panel).slow(2);
				
			}
		});
        
		btnSlowDown_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((Test) panel).slow(3);
				
			}
		});
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			  public void run() {
				  textArea.setText(((Test) panel).getResult());
				  btnGetBackTo.setVisible(true);
			  }
			}, 1*60*50);
	}
	
	
	

	
}
