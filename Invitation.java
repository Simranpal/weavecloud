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

//Description:    Invitation.java is the class which defines GUI for inviting a new friend 
//Creation Date:  September 2, 2011
//Authors :       Simranpal Singh, Varinder Pal Singh
import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
class Invitation extends JDialog {
	JDialog d;
	Invitation(JFrame parent) {
		d = new JDialog(parent);
		d.setIconImage(Toolkit.getDefaultToolkit().getImage("images/icons/32x32/invite.png"));
		d.setResizable(false);
		
		JPanel panel=new JPanel(null);
		JLabel lblEmail = new JLabel("Enter Email Address of friend");
		JTextField tfEmail = new JTextField();
		JButton btnInvite = new JButton("Invite");

		lblEmail.setBounds(50,50,200,20);
		tfEmail.setBounds(270,50,150,20);
		btnInvite.setBounds(200,100,150,20);
		panel.add(lblEmail);
		panel.add(tfEmail);
		panel.add(btnInvite);
		d.setModal(true);
		d.pack();
		d.setSize(500,200);
                Point p = parent.getLocation();
		d.setLocation(p.x + 100, p.y + 100);
		d.getContentPane().add(panel);
        d.setTitle("Invite Friend");
		d.setVisible(true);
		
	}
}


