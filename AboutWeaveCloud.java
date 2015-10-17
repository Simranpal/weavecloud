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
//Description:    CloudLogin.java is the main login page for weavecloud 
//Creation Date:  August 23, 2011
//Authors :       Simranpal Singh, Varinder Pal Singh

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class AboutWeaveCloud implements ActionListener {
	JLabel lbl1 = new JLabel("Weave Cloud Project");
	JLabel lbl2 = new JLabel("Copyright(C) 2010 WeaveBytes, Inc.,");
	JLabel lbl3 = new JLabel("Confidential, all rights reserved. No distribution is permitted.");
	JLabel lbl4 = new JLabel("Project Developed By:");
	JLabel lbl5 = new JLabel("Simranpal Singh , Varinder Pal Singh");

	JButton btnOk = new JButton("OK"); 

	JLabel lblImg=new JLabel(new ImageIcon(getClass().getResource("images/icons/cloudy.png")));
	JPanel panel=new JPanel(null);
	JDialog d;
	
	AboutWeaveCloud(JFrame parent) {
	d = new JDialog(parent);	
	d.setResizable(false);
	lbl1.setBounds(200,50,400,20);
	lbl2.setBounds(200,80,400,20);
	lbl3.setBounds(200,110,400,20);
	lbl4.setBounds(200,140,400,20);
	lbl5.setBounds(200,170,400,20);
	btnOk.setBounds(260,220,80,20);
	lblImg.setBounds(50,70,100,100);
	btnOk.addActionListener(this);
	lbl1.setFont(new Font("Courier New",Font.PLAIN,18));
	panel.add(lbl1);
	panel.add(lbl2);
	panel.add(lbl3);
	panel.add(lbl4);
	panel.add(lbl5);
	panel.add(btnOk);
	panel.add(lblImg);
	d.getContentPane().add(panel);
	d.setTitle("About Weave Cloud");
	d.setModal(true);
	d.pack();
	d.setSize(600,300);
	d.setLocation(500, 400);
	d.setVisible(true);
	
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btnOk) d.setVisible(false);
	}
}
