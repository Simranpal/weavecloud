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

//Description:    JoinGroup.java is the class which defines GUI for joining a new group. 
//Creation Date:  September 2, 2011
//Authors :       Simranpal Singh, Varinder Pal Singh
import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
class JoinGroup  {
	JDialog d;
	JoinGroup(JFrame parent) {
		d = new JDialog(parent);
		d.setIconImage(Toolkit.getDefaultToolkit().getImage("images/icons/32x32/user.png"));
		d.setResizable(false);
		
		JPanel panel=new JPanel(null);
		JLabel lblJoin = new JLabel("Under development");
		
		lblJoin.setBounds(50,50,200,20);
		panel.add(lblJoin);
		d.setModal(true);
		d.pack();
		d.setSize(500,200);
		d.setLocation(400, 400);
		d.getContentPane().add(panel);
        d.setTitle("Join Group");
		d.setVisible(true);
		
	}
}


