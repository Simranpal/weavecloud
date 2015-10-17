//Description:    GroupAdd.java creates group.
//Creation Date:  July 20, 2011
//Authors :       SimranPal, Varinder

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GroupAdd extends JDialog implements ActionListener,KeyListener {	
	JLabel lblGroupName, lblUsername, lblVisibility,lblInvalidGroupName,lblInvalidUsername;
	JTextField tfGroupName, tfUsername;
	JButton btnCreate,btnCancel;
	//CheckboxGroup cg ;
	JRadioButton cbPublic,cbPrivate;
	String groupNameCharSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzz0123456789_.-";
	String userNameCharSet  = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzz0123456789_.-";
	JPanel groupAddPane;
	//constructor
	public GroupAdd(JFrame parent) {
			super(parent,true);
			 if (parent != null) {
				Dimension parentSize = parent.getSize(); 
				Point p = parent.getLocation(); 
				setLocation(p.x + parentSize.width / 4, p.y + parentSize.height / 4);
			}
			//setLayout(null);
			groupAddPane    = new JPanel();
			groupAddPane.setLayout(null);
			lblGroupName    = new JLabel("New Group Name");
			lblUsername     = new JLabel("User Name");
			lblVisibility   = new JLabel("Visibility");
			tfGroupName     = new JTextField();
			tfUsername      = new JTextField();
			//cg			    = new CheckboxGroup();
			cbPublic        = new JRadioButton("Public",true);
			cbPrivate       = new JRadioButton("Private",false);
			btnCreate       = new JButton("Create");
			btnCancel       = new JButton("Cancel");

			lblInvalidGroupName = new JLabel("Invalid Group Name");
			lblInvalidUsername  = new JLabel("Invalid User Name");
			lblInvalidGroupName.setForeground(Color.RED);
			lblInvalidUsername.setForeground(Color.RED);
			lblInvalidGroupName.setVisible(false);
			lblInvalidUsername.setVisible(false);
			
			lblGroupName.setBounds(50,50,100,20);
			lblUsername.setBounds(50,110,100,20);
			lblVisibility.setBounds(50,160,100,20);
			tfGroupName.setBounds(200,50,200,20);
			lblInvalidGroupName.setBounds(200,70,200,20);
			tfUsername.setBounds(200,110,200,20);
			lblInvalidUsername.setBounds(200,130,200,20);
			cbPublic.setBounds(200,160,90,30);
			cbPrivate.setBounds(310,160,90,30);
			btnCreate.setBounds(50,220,100,30);
			btnCancel.setBounds(200,220,100,30);
			
			groupAddPane.add(lblGroupName);
			groupAddPane.add(lblUsername);
			groupAddPane.add(lblVisibility);
			groupAddPane.add(tfGroupName);
			groupAddPane.add(tfUsername);
			groupAddPane.add(cbPublic);
			groupAddPane.add(cbPrivate);
			groupAddPane.add(btnCreate);
			groupAddPane.add(btnCancel);
			groupAddPane.add(lblInvalidGroupName);
			groupAddPane.add(lblInvalidUsername);
			
			getContentPane().add(groupAddPane, BorderLayout.CENTER);
			
			btnCreate.addActionListener(this);
			btnCancel.addActionListener(this);
			btnCreate.addKeyListener(this);
			
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			pack();
			
			setSize(450,390);
			//setResizable(false);
			setLocation(500,300);
			groupAddPane.setVisible(true);
			setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {	
		 if(ae.getSource() == btnCreate) {
			 String s="CNGR";
			if(!Utils.ensurePattern(groupNameCharSet, tfGroupName.getText())) lblInvalidGroupName.setVisible(true);
			else {
				lblInvalidGroupName.setVisible(false);
				s = s+tfGroupName.getText();
			}
			if(!Utils.ensurePattern(userNameCharSet, tfUsername.getText() )) lblInvalidUsername.setVisible(true);	 
			else {
				lblInvalidUsername.setVisible(false);
				s = s+":"+tfUsername.getText();
			}
			Server.submitRequest(s);
		}
		 if(ae.getSource() == btnCancel) {
			setVisible(false); 
			dispose();
		 }
	}

	public void keyPressed(KeyEvent ke) {
		if(ke.getKeyCode() == 10){
		
		  System.out.println("Entered");
		}
	}
	public void keyReleased(KeyEvent ke) {
	}
	public void keyTyped(KeyEvent ke) {
		if(ke.getKeyCode()==10 )
			System.out.println("Entered");
	}
}
