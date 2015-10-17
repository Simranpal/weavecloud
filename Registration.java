/*
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
//Description:    Registration.java class is a class for registering new users 
//Creation Date:  July 25, 2011
//Authors :       Simranpal Singh, Varinder Pal Singh

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Registration  extends JDialog implements ActionListener ,ItemListener{
	JLabel lblFname, lblLname, lblUsr,lblDob, lblPwd, lblRpwd, lblSques,lblGender, lblAns, lblEmail;
	JLabel lblIFname,lblILname,lblIUname,lblIPwd,lblIDate,lblIEmail, lblEpwd,lblESans,lblEEmail;
	JButton btnSave,btnReset,btnExit;
	Checkbox cbMale, cbFemale;
	CheckboxGroup  cgGroup;
	JTextField tfFname, tfLname, tfDob, tfUsr,tfAns, tfEmail;
	JPasswordField  tfPwd,tfRpwd;
	Choice Sques, date, month, year;
	
	public Registration(JFrame parent) {
		super(parent,true);
		if (parent != null) {
				Dimension parentSize = parent.getSize(); 
				Point p = parent.getLocation(); 
				setLocation(p.x + parentSize.width / 4, p.y + parentSize.height / 4);
			}
		setSize(500,750);
 		setLocation(500,250);
		setBackground(Config.REGIS_BG_COLOR);

	    //JLabels
		lblUsr     = new JLabel("Username");
		lblPwd     = new JLabel("Password");
		lblRpwd    = new JLabel("Retype Password");
		lblFname   = new JLabel("First Name");
		lblLname   = new JLabel("Last Name");
		lblDob     = new JLabel("Date Of Birth");
		lblGender  = new JLabel("Gender");
		lblSques   = new JLabel("Security Question");
		lblAns     = new JLabel("Security Answer");
		lblEmail   = new JLabel("Email");
		
		//Field validators
		lblIFname = new JLabel("Invalid Characters in First Name");
		lblILname = new JLabel("Invalid Characters in Last Name");
		lblIUname  = new JLabel("Invalid User Name"); 
		lblIPwd = new JLabel("Password do not match");
		lblIDate = new JLabel("Please Check the Date");
		lblIEmail = new JLabel("Incorrect Email");
		lblEpwd = new JLabel("Please enter the password");
	    lblESans = new JLabel("Please enter the Security Answer");
		lblEEmail = new JLabel("Please enter your email");
		lblIFname.setForeground(Color.red);
		lblILname.setForeground(Color.red);
		lblIUname.setForeground(Color.red);
		lblIPwd.setForeground(Color.red);
		lblIDate.setForeground(Color.red);
		lblIEmail.setForeground(Color.red);
		lblEpwd.setForeground(Color.red);
		lblESans.setForeground(Color.red);
		lblEEmail.setForeground(Color.red);
        
		//JButtons
		btnSave  = new JButton("SAVE");
		btnReset = new JButton("RESET");
		btnExit  = new JButton("EXIT");

		cgGroup = new CheckboxGroup();
		cbMale  = new Checkbox("Male",cgGroup,true);
		cbFemale  = new Checkbox("Female",cgGroup,false);

		Sques     = new Choice();
		Sques.add("What city were you born in?");
		Sques.add("What was your first mobile number?");
		Sques.add("What is your maid name?");
		Sques.add("Whats your pet name?");
		Sques.select("Whats your favourite food?");
		
		date = new Choice();
		for(int i = 1; i <= 31; i++)
			date.add(""+i);
		
		month = new Choice();
		for(int j = 1; j <= 12; j++)
			month.add(""+j);

		year = new Choice();
		for(int k = 1950; k <= 2010; k++)
			year.add(""+k);
		
		//JTextFields
		tfUsr   = new JTextField();
		tfPwd   = new JPasswordField();
		tfRpwd  = new JPasswordField();
		tfFname = new JTextField();
		tfLname = new JTextField();
		tfDob   = new JTextField();
		tfAns   = new JTextField();
		tfEmail = new JTextField();

		setLayout(null);
		setResizable(false);

		//setting bounds
		lblFname.setBounds(50,50,150,20);
		lblLname.setBounds(50,110,150,20);
		lblUsr.setBounds(50,170,150,20);
		lblPwd.setBounds(50,230,150,20);
		lblRpwd.setBounds(50,290,150,20);
		lblDob.setBounds(50,350,150,20);
		lblGender.setBounds(50,410,150,20);
		lblSques.setBounds(50,470,150,20);
		lblAns.setBounds(50,530,150,20);
		lblEmail.setBounds(50,590,150,20);
		lblIFname.setBounds(200,80,150,20);
		lblILname.setBounds(200,140,150,20);
		lblIUname.setBounds(200,200,150,20);
		lblIPwd.setBounds(200,320,150,20);
		lblEpwd.setBounds(200,260,150,20);
		lblIDate.setBounds(200,380,150,20);
		lblESans.setBounds(200,560,300,20);
		lblIEmail.setBounds(200,620,150,20);
		lblEEmail.setBounds(200,620,150,20);
		lblIFname.setVisible(false);
		lblILname.setVisible(false);
		lblIUname.setVisible(false);
		lblIPwd.setVisible(false);
		lblIDate.setVisible(false);
		lblIEmail.setVisible(false);
		lblEpwd.setVisible(false);
		lblESans.setVisible(false);
		lblEEmail.setVisible(false);
		
		btnSave.setBounds(50,650,100,30);
		btnReset.setBounds(200,650,100,30);
		btnExit.setBounds(350,650,100,30);

		cbMale.setBounds(200,410,50,20);
		cbFemale.setBounds(350,410,60,20);

		tfFname.setBounds(200,50,250,20);
		tfLname.setBounds(200,110,250,20);
		tfUsr.setBounds(200,170,250,20);
		tfPwd.setBounds(200,230,250,20);
		tfRpwd.setBounds(200,290,250,20);
		date.setBounds(200,350,50,20);
		month.setBounds(290,350,50,20);
		year.setBounds(380,350,70,20);
		Sques.setBounds(200,470,250,20);
		tfAns.setBounds(200,530,250,20);
		tfEmail.setBounds(200,590,250,20);
		
		btnSave.addActionListener(this);
		btnReset.addActionListener(this);
		btnExit.addActionListener(this);
		Sques.addItemListener(this);
		date.addItemListener(this);
		month.addItemListener(this);
		year.addItemListener(this);
		
		//adding
		//JLabels
		add(lblFname);
		add(lblLname);
		add(lblUsr);
		add(lblPwd);
		add(lblRpwd);
		add(lblDob);
		add(lblSques);
		add(lblAns);
		add(lblGender);
		add(lblEmail);
		add(lblIFname);
		add(lblILname);
		add(lblIUname);
		add(lblIPwd);
		add(lblIDate);
		add(lblIEmail);
		add(lblEpwd);
		add(lblESans);
		add(lblEEmail);		
		
		//JTextField
		add(tfFname);
		add(tfLname);
		add(tfUsr);
		add(tfPwd);
		add(tfRpwd);
		add(date);
		add(month);
		add(year);
		add(cbMale);
		add(cbFemale);
		add(Sques);
		add(tfAns);
		add(tfEmail);
		
		//JButton
		add(btnSave);
		add(btnReset);
		add(btnExit);
		
		setVisible(true);
	}// end of constructor
	

	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource() == btnExit) {   
			setVisible(false);
			dispose();
		}
		if(ae.getSource() ==btnSave) {
			lblIFname.setVisible(false);
			lblILname.setVisible(false);
			lblIUname.setVisible(false);
			lblIPwd.setVisible(false);
			lblIDate.setVisible(false);
			lblIEmail.setVisible(false);
			lblEpwd.setVisible(false);
			lblESans.setVisible(false);
			lblEEmail.setVisible(false);
			
			if(tfPwd.getText().equals(""))		lblEpwd.setVisible(true);
			if(tfAns.getText().equals(""))		lblESans.setVisible(true);
			if(tfEmail.getText().equals(""))	lblEEmail.setVisible(true);
			
			if(Validate.name(tfFname.getText())) {
				if(Validate.name(tfLname.getText())) {
					if(Validate.validatePattern(tfUsr.getText())) {
						if(Validate.validatePattern(tfPwd.getText())) {
							if(tfPwd.getText().equals(tfRpwd.getText())) {
								if(Validate.validateEmail(tfEmail.getText())) {	
									String dob = year.getSelectedItem()+month.getSelectedItem()+date.getSelectedItem();
									System.out.println(Compose.CNUR(tfFname.getText(), tfLname.getText(), tfUsr.getText(), tfPwd.getText(), dob, cgGroup.getSelectedCheckbox().getLabel(), Sques.getSelectedItem(),tfAns.getText(), tfEmail.getText()));
								}
							}
						}
					}
				}
			}
			if(!Validate.validatePattern(tfFname.getText())) lblIFname.setVisible(true);
			if(!Validate.validatePattern(tfLname.getText())) lblILname.setVisible(true);
			if(!Validate.validatePattern(tfUsr.getText()))   lblIUname.setVisible(true);
			if(!(tfPwd.getText().equals(tfRpwd.getText())))   lblIPwd.setVisible(true);	
		}
		if(ae.getSource()==btnReset) {
			setVisible(false);
			//new Registration(this);
		}
	}
	/*	String msg="";
		if(!validateForm(msg)) {
		  //popup msg
		}
		else {
		  //sumbit CNUR
		}
		
		
 	}
	private boolean validateForm(String errMsg) {
	  if(tfFname.getText().length==0) {
	    errMsg="Please Specify First Name";
	    return false;
	  }
	  if(!Validate.name(tfFname.getText())) {
	    errMsg="Invalid First Name";
	    return false;
	  }
	}*/
	public void itemStateChanged(ItemEvent ie) {}
	// main method
	public static void main(String [] args) {
	//	Registration r = new Registration(this);
	}
}//end of class Registration
