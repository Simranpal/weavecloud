/*
 * Copyright (C) 2010 WeaveBytes, Inc.,
 *
 * Confidential, all rights reserved. No distribution is permitted.

  ___            _______ 	____      ________ 
  \  \    __    /     __|  /	\    /     ___|
   \  \  /  \  /     |_	  /  /\  \  /     |_
    \  \/    \/  /|   _| /  /__\  \/  /|   _|
	 \    /\    / |  |__/  ______    / |  |___
	  \__/  \__/  |_______/	     \ _/  |______|
	  
			        ___                                      __
			 ______ |  |    ________    __      __          |  |
			/  ___|	|  |   /   __   \  |  |    |  |  _______|  |
			|  |	|  |   |  |  |  |  |  |    |  | /   ____|  |
			|  |____|  |__ |  |__|  |__|  \____/  | \  \____|  |
			\_______|______\________/__ \________/__ \_________|
*/
//Description:    Splash.java class defines the Splashscreen of weavecloud 
//Creation Date:  August 04, 2011
//Authors :       Simranpal Singh, Varinder Pal Singh

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Splash extends JFrame implements Runnable{
 	int i, j=0;
	Thread t1;
	String dot[] = {" . "," .. "," ... "};
	
	Splash() {
		super("Weave Cloud");
		setVisible(true);
		setSize(640,480);
		setLocation(500,400);
		t1 = new Thread(this);
		t1.start();
	}
	public void drawBar(Graphics g) {
		if(i>=581) return;
		g.setFont(new Font("Courier New",Font.PLAIN,18));
		g.drawString("Please Wait,Loading"+dot[j],30,180);
		g.drawRect(30,240,580,40);
		g.drawLine(30,281,610,281);
		g.drawLine(611,240,611,281);
		g.drawLine(30,282,610,282);
		g.drawLine(612,240,612,281);
		g.fillRect(30,240,i,40);
	}
	
	public void run() {
		for(i =30;i<583;i++){
			System.out.println("SSH");
			try	{	
				repaint();	
				Thread.sleep(20);	
			}
			catch(Exception e)	{}
			if( i % 80 == 0){
				j++;
				if(j==3) j=0;
			}
		} 
	}
	public void paint(Graphics g) {
			drawBar(g);
		}
	public static void main(String args[]) {
		new Splash();
	}
	
}