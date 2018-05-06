/**
 * Author Name: Tanvir Ahmed Khan and Jagadish Kodigehalli Malleshaiah
 * Problem Description: A simulated safe-driving practice test program allows a user to be aware of road safety. 
 * date:22/9/2017
 * ID:100864675
 * ID:101003877
 * Email: 100864675@student.swin.edu.au
 * Email: 100864675@student.swin.edu.au

 * */


/*
 * provide the complex UI,
 * Uses of Graphics2D, Timer , ActionListener, Java Swing
 *
 * */
package pack.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class Test extends JPanel implements ActionListener{

	Timer t = new Timer(1,this);
	Timer t2 = new Timer(1,this);
	
	
	
	
	 public int id;
	 double x=0,y=20,velx =.2;
	 double x2=100,y2=0,velx2 =.2;
	 double x3=200,y3=0,velx3 =.2;
	 double initialVelocity=.2;
	 int breakForC1=0,breakForC2=0,breakForc3=0;
	 
	 int flag3=0;
	 Image  back, danger,car;
	 boolean dc=false, dc2=false, dc3=false;
	 String osc1="",osc2="",osc3="";
	 String finalResult="",damageHistory="";
	 
	public Test(int id) {
		this.id=id;
	}
	
	 public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			
			try {
				if(id==0) {
					back= ImageIO.read(new File("img/background.png"));
				}
				else if(id==1) {
					back= ImageIO.read(new File("img/background2.png"));
				}
				else if(id==2) {
					back= ImageIO.read(new File("img/background3.png"));
				}
				
				
				
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				car= ImageIO.read(new File("img/car.png"));
			} catch(IOException e2) {
				e2.printStackTrace();
			}
			
			try {
				danger= ImageIO.read(new File("img/danger.jpg"));
			} catch(IOException e2) {
				e2.printStackTrace();
			}
			
			g2.drawImage(back,0,0,this);
			
			g2.drawImage(car,(int) x,100,40,40,this);
			g2.drawImage(car,(int) x2,100,40,40,this);
			g2.drawImage(car,(int) x3,100,40,40,this);
						
			g2.drawImage(danger,700,100,50,50,this);
			//g2.fillRect(340,100,50,150);
			t.start();
			flag3=flag3+1;
			
		}
	 
	 
	
	 
	public void actionPerformed(ActionEvent e) {
		
		if((x>=340 && x<380) || (x2>=340 && x2<380) || (x3>=340 && x3<380)) {
			if(velx > (initialVelocity- (initialVelocity*.25))) {
				osc1="car1 was overspeeding.\n";
				
			}
			else {
				osc1="car1 has maintained the speed limit.\n";
			}
			
			if(velx2 > (initialVelocity- (initialVelocity*.25))){
				osc2="car2 was overspeeding.\n";
			}
			else {
				osc2="car2 has maintained the speed limit.\n";
			}
			
			if(velx3 > (initialVelocity- (initialVelocity*.25))) {
				System.out.println("car3 was overspeeding.\n");
				osc3="car2 was overspeeding.";
			}
			else {
				osc3="car3 has maintained the speed limit.\n";
			}
		}
		
		if(x>=650 && !dc) {
			dc=true;
			stopCar(1);
			damageHistory=damageHistory+"car1 has been damaged in the danger point\n";
		}
		
		if(x2>=650 && !dc2) {
			dc2=true;
			stopCar(2);
			damageHistory=damageHistory+"car2 has been damaged in the danger point\n";
		}
		
		if(x3>=650 && !dc3) {
			dc3=true;
			stopCar(3);
			damageHistory=damageHistory+"car3 has been damaged in the danger point\n";
		}
		
		x+= velx;
		x2+=velx2;
		x3+=velx3;
		repaint();
		
		//if(flag3==5000) 
		{
			t.stop();
			finalResult="Break pressed by car 1 :"+breakForC1+ "\nBreak pressed by car 2 :" +breakForC2 +"\nBreak pressed by car 3 :" +breakForc3+"\n";
			finalResult+= osc1+osc2+osc3;
			finalResult+=damageHistory;
			System.out.println(finalResult);
		}
		
	
		
	}
	
	
	public void stopCar(int c) {
		if(c == 1) {
			velx=0;
			breakForC1=breakForC1+1;
		}
		else if(c == 2) {
			velx2=0;
			breakForC2=breakForC2+1;
		}
		else if(c == 3) {
			velx3=0;
			breakForc3=breakForc3+1;
		}
		
	}
	
	public void slow(int velocity) {
		if(velocity == 1) {
			velx=velx-(velx*.25);
		}
		else if(velocity == 2) {
			velx2=velx2-(velx2*.25);
		}
		else if(velocity == 3) {
			velx3=velx3-(velx3*.25);
		}
	}
	
	public String getResult() {
		return finalResult;
	}

}
