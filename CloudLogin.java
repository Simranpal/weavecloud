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
//Creation Date:  July 27, 2011
//Authors :       Simranpal Singh, Varinder Pal Singh

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CloudLogin extends JDialog implements ActionListener {

	JLabel lblUsr, lblPwd,lblInvalid;
	JButton btnLogin, btnForgot, btnRegister;
	JTextField tfUsr, tfPwd;
	
	//constructor
	CloudLogin(JFrame parent, String title, boolean block) {
		super(parent, title, block);
		setSize(500,250);
		setLocation(500, 400);
		setVisible(true);
		setResizable(false);
		
        JPanel pane = new JPanel();
		pane.setLayout(null);
		pane.setSize(450,230);

		lblUsr      = new JLabel("Username");
		lblPwd      = new JLabel("Password");
		btnLogin    = new JButton("LOGIN");
		btnForgot   = new JButton("FORGOT PASSWORD ?");
		btnRegister = new JButton("REGISTER");
		tfUsr       = new JTextField();
		tfPwd       = new JTextField();
		lblInvalid  = new JLabel("Invalid UserName or Password");
		lblInvalid.setForeground(Color.RED);
		lblInvalid.setVisible(false);
	
		lblUsr.setBounds(50,60,150,20);
		lblPwd.setBounds(50,110,150,20);
		lblInvalid.setBounds(210,140,240,20 );

		btnForgot.setBounds(175,180,150,30);
		btnLogin.setBounds(50,180,100,30);
		btnRegister.setBounds(350,180,100,30);
		
		tfUsr.setBounds(210,60,240,20);
		tfPwd.setBounds(210,110,240,20);

		btnLogin.addActionListener(this);
		btnForgot.addActionListener(this);
		btnRegister.addActionListener(this);
		
		//adding
		pane.add(lblUsr);
		pane.add(lblPwd);
		pane.add(btnLogin);
		pane.add(btnForgot);
		pane.add(btnRegister);
		pane.add(tfUsr);
		pane.add(tfPwd);
		pane.add(lblInvalid);
        getContentPane().add(pane);         pack(); 
		}//End of Constructor

		public void actionPerformed(ActionEvent ae) {	
			if(ae.getSource() == btnLogin) {   
				if(checkLogin()) {
					setVisible(false);
					new DashBoard();
				}
				else {	
					tfUsr.setText("");
					tfPwd.setText("");
					lblInvalid.setVisible(true);
				}
			}
			if(ae.getSource() == btnForgot)   { }
			if(ae.getSource() == btnRegister) { 
				//new Registration(this);
				setVisible(false);
			}
		}
		
	//checkLogin method
	public boolean checkLogin () {
		if(tfUsr.getText().equals("aa") && tfPwd.getText().equals("aa")) return true;
		else                                                             return false;
	}
	
	//main
	public static void main(String [] args) {
		CloudLogin cl = new CloudLogin(new JFrame(), "Hello...", true);
	}
}//CloudLogin
