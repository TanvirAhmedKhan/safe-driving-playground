/**
 * Author Name: Tanvir Ahmed Khan and Jagadish Kodigehalli Malleshaiah
 * Problem Description: A simulated safe-driving practice test program allows a user to be aware of road safety. 
 * date:22/9/2017
 * ID:100864675
 * ID:101003877
 * Email: 100864675@student.swin.edu.au
 * Email: 100864675@student.swin.edu.au

 * */


/**
 * This is the Initiation file which brings the first window, where the user need to provide details and preferred application window color.
 * */

package pack.ui;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class Initiation {

	public JFrame frame;
	private JTextField textField;
	JButton btnStart = new JButton();
	String[] windowColorForUser = { "red","green","blue","black", "white"};
	Image  back;
	private JTextField textField_1;

	/**
	 * Create the application.
	 */
	public Initiation() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 647, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		try {
			back= ImageIO.read(new File("img/first.jpg"));
			
			
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		btnStart.setText("Start");
		btnStart.setBounds(245, 459, 132, 44);
		frame.getContentPane().add(btnStart);
		
		JLabel lblEnterYourName = new JLabel("ENTER YOUR NAME");
		lblEnterYourName.setBounds(107, 207, 132, 14);
		frame.getContentPane().add(lblEnterYourName);
		
		textField = new JTextField();
		textField.setBounds(325, 204, 115, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		//asking the to follow the terms and conditions.
		JCheckBox chckbxIAgreedTo = new JCheckBox("I agreed to follow the terms & conditions");
		chckbxIAgreedTo.setBounds(154, 363, 286, 23);
		frame.getContentPane().add(chckbxIAgreedTo);
		
		
		//asking for the preferred color
		JLabel lblYourDesiredTest = new JLabel("Your desired Test Environment ");
		lblYourDesiredTest.setBounds(107, 274, 188, 14);
		frame.getContentPane().add(lblYourDesiredTest);
		
		//color choser for the user
		JComboBox comboBox = new JComboBox(windowColorForUser);
		comboBox.setToolTipText("select colour");
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(327, 271, 113, 20);
		frame.getContentPane().add(comboBox);
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(107, 232, 95, 14);
		frame.getContentPane().add(lblPassword);
		
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(back));
		lblNewLabel.setText("");
		lblNewLabel.setBounds(0, 0, 631, 591);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(325, 229, 115, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		
		//go to the main activity window where the tasks going to be occured
		btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(chckbxIAgreedTo.isSelected() && textField!=null) {
					try {
						//SafeDrivingTest window = new SafeDrivingTest(textField.getText(),windowColorForUser[comboBox.getSelectedIndex()]);
						//System.out.println(windowColorForUser[comboBox.getSelectedIndex()]);
						//window.frame.setVisible(true);
						frame.setVisible(false);
						ChooseEnvironment ce = new ChooseEnvironment();
						ce.frame.setVisible(true);
						
						
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				
				
			}
		});
	}
}
