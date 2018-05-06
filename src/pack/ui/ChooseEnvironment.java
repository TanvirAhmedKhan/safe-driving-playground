/**
 * Author Name: Tanvir Ahmed Khan and Jagadish Kodigehalli Malleshaiah
 * Problem Description: A simulated safe-driving practice test program allows a user to be aware of road safety. 
 * date:22/9/2017
 * ID:100864675
 * ID:101003877
 * Email: 100864675@student.swin.edu.au
 * Email: 100864675@student.swin.edu.au

 * */

package pack.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;

public class ChooseEnvironment {

	public JFrame frame;
	String[] windowColorForUser = { "red","green","blue","black", "white"};
	String[] road = { "city view 1","city view 2"};
	int demoLeft=3;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseEnvironment window = new ChooseEnvironment();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChooseEnvironment() {
		initialize();
	}
	
	
	public String makeMyString(int myInt) {
		StringBuilder myStringBuilder = new StringBuilder();
		myStringBuilder.append("");
		myStringBuilder.append(myInt);
		return myStringBuilder.toString();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 810, 517);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(67, 174, 319, 225);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTest = new JLabel("DEMO ");
		lblTest.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTest.setBounds(127, 0, 62, 33);
		panel.add(lblTest);
		
		JLabel lblDemoTestLeft = new JLabel("Demo test Left :");
		lblDemoTestLeft.setBounds(10, 57, 86, 14);
		panel.add(lblDemoTestLeft);
		
		
		String dml = makeMyString(demoLeft);
		
		
		JLabel label = new JLabel(dml);
		label.setBounds(143, 57, 46, 14);
		panel.add(label);
		
		JButton btnNewButton = new JButton("Take a Demo Test");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				demoLeft=demoLeft-1;
				if(demoLeft>=0) {
					label.setText(makeMyString(demoLeft));
					
					if(demoLeft==0) {
						label.setText(makeMyString(demoLeft));
						btnNewButton.setEnabled(false);
					}
					SafeDrivingTest window = new SafeDrivingTest("hello","green",0);
					window.frame.setVisible(true);
				}
				
			}
		});
		btnNewButton.setBounds(88, 154, 150, 23);
		panel.add(btnNewButton);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(224, 255, 255));
		panel_1.setBounds(418, 174, 342, 225);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPracticeTest = new JLabel("Practice Test");
		lblPracticeTest.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPracticeTest.setBounds(104, 0, 139, 35);
		panel_1.add(lblPracticeTest);
		
		JLabel lblSetRoad = new JLabel("set road");
		lblSetRoad.setBounds(10, 49, 70, 14);
		panel_1.add(lblSetRoad);
		
		JComboBox comboBox = new JComboBox(road);
		comboBox.setBounds(160, 46, 139, 20);
		panel_1.add(comboBox);
		
		JLabel lblSetWindowBackground = new JLabel("set window Background");
		lblSetWindowBackground.setBounds(10, 77, 139, 14);
		panel_1.add(lblSetWindowBackground);
		
		JComboBox comboBox_1 = new JComboBox(windowColorForUser);
		comboBox_1.setToolTipText("select colour");
		comboBox_1.setBackground(Color.LIGHT_GRAY);
		comboBox_1.setBounds(160, 77, 139, 20);
		panel_1.add(comboBox_1);
		
		JButton btnTakeTest = new JButton("Take Test");
		btnTakeTest.setBounds(134, 157, 89, 23);
		panel_1.add(btnTakeTest);
		
		
		btnTakeTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					int setRoad=0;
				
				    String temp= road[comboBox.getSelectedIndex()];
				    if(temp.equals("city view 1")) {
				    	setRoad=1;
				    }
				    else if(temp.equals("city view 2")) {
				    	setRoad=2;
				    }
				
					SafeDrivingTest window = new SafeDrivingTest("hello","green",setRoad);
					window.frame.setVisible(true);
				
				
			}
		});
		
		JLabel lblNoOfCar = new JLabel("no. of car");
		lblNoOfCar.setBounds(10, 102, 70, 14);
		panel_1.add(lblNoOfCar);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(160, 108, 139, 20);
		panel_1.add(comboBox_2);
	}
}
