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

//Description:    Settings.java is the class which defines GUI for user to change its settings. 
//Creation Date:  September 2, 2011
//Authors :       Simranpal Singh, Varinder Pal Singh
import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
class Settings  implements ActionListener {
	JDialog d;
	JTabbedPane tb; 
	JPanel PnlGeneral, PnlNetwork, PnlThemes, PnlContent;
	JLabel lblHost, lblPort, lblAttempt, lblTimeOut, lblStrgDir, lblSlctTheme, lblPrevious, lblSetBg, lblSetFg, lblSetFont;
	JTextField tfHost, tfPort, tfStrgDir, tfSlctTheme, tfPrevious, tfSetBg, tfSetFg, tfFont;
	JCheckBox cbTray, cbStartUp, cbExit, cbWarning, cbSplash;
	Choice chAttempt, chTimeOut;
	JButton btnBrowse, btnGenSave, btnGenReset, btnGenCncl, btnNetSave, btnNetReset, btnNetCncl, btnThemSave, btnThemReset, btnThemCncl, btnCntSave, btnCntReset, btnCntCncl;
	Settings(JFrame parent) {
		d = new JDialog(parent);
		d.setIconImage(Toolkit.getDefaultToolkit().getImage("images/icons/32x32/setting.png"));
		//d.setResizable(false);
		
		tb         = new JTabbedPane();
		PnlGeneral = new JPanel();
		PnlNetwork = new JPanel();
		PnlThemes  = new JPanel();
		PnlContent = new JPanel();
		
		tb.addTab("General",new ImageIcon(getClass().getResource("images/icons/32x32/general.png")),PnlGeneral,"General Settings of WeaveCloud");
		tb.addTab("Network",new ImageIcon(getClass().getResource("images/icons/32x32/network.png")),PnlNetwork,"Network Settings");
		tb.addTab("Themes",new ImageIcon(getClass().getResource("images/icons/32x32/theme.png")),PnlThemes,"Change Look and Theme" );
		tb.addTab("Content",new ImageIcon(getClass().getResource("images/icons/32x32/content.png")),PnlContent,"Change Content Settings");
		
		d.add(tb);
		d.setModal(true);
		d.pack();
		d.setSize(650,650);
		d.setLocation(400, 200);
		d.setTitle("Change your Setting");
		
		setGeneralTab();
		setNetworkTab();
		setThemesTab();
		setContentTab();
		loadSettings();
			
		btnBrowse.setActionCommand("CMD_BROWSE");
		btnGenSave.setActionCommand("CMD_GEN_SAVE");
		btnGenReset.setActionCommand("CMD_GEN_RESET");
		btnGenCncl.setActionCommand("CMD_GEN_CANCEL");
		btnNetSave.setActionCommand("CMD_NET_SAVE");
		btnNetReset.setActionCommand("CMD_NET_RESET");
		btnNetCncl.setActionCommand("CMD_NET_CANCEL");
		btnThemSave.setActionCommand("CMD_THEME_SAVE");
		btnThemReset.setActionCommand("CMD_THEME_RESET");
		btnThemCncl.setActionCommand("CMD_THEME_CANCEL");
		btnCntSave.setActionCommand("CMD_CNT_SAVE");
		btnCntReset.setActionCommand("CMD_CNT_RESET");
		btnCntCncl.setActionCommand("CMD_CNT_CANCEL");
	
		btnBrowse.addActionListener(this);
		btnGenSave.addActionListener(this);
		btnGenReset.addActionListener(this);
		btnGenCncl.addActionListener(this);
		btnNetSave.addActionListener(this);
		btnNetReset.addActionListener(this);
		btnNetCncl.addActionListener(this);
		btnThemSave.addActionListener(this);
		btnThemReset.addActionListener(this);
		btnThemCncl.addActionListener(this); 
		btnCntSave.addActionListener(this);
		btnCntReset.addActionListener(this);
		btnCntCncl.addActionListener(this);
		d.setVisible(true);
		
	}/*Settings*/
	
	public void setGeneralTab() {
		PnlGeneral.setLayout(null);
				
		cbTray    = new JCheckBox("Minimize to System Tray");
		cbStartUp = new JCheckBox("Launch on System Startup");
		cbTray.setBounds(100,50,250,20);
		cbStartUp.setBounds(100,90,250,20);
		cbWarning = new JCheckBox("Show Warnings");
		cbWarning.setBounds(100,130,250,20);
		cbSplash = new JCheckBox("Show Splash Screen");
		cbSplash.setBounds(100,170,250,20);
		PnlGeneral.add(cbTray);
		PnlGeneral.add(cbStartUp);
		PnlGeneral.add(cbWarning);
		PnlGeneral.add(cbSplash);
		
		btnGenSave    = new JButton("Save");
		btnGenReset = new JButton("Reset");
		btnGenCncl  = new JButton("Cancel");
		btnGenSave.setBounds(180,500,80,20); 
		btnGenReset.setBounds(285,500,80,20);
		btnGenCncl.setBounds(390,500,80,20);
		PnlGeneral.add(btnGenSave);
		PnlGeneral.add(btnGenReset);
		PnlGeneral.add(btnGenCncl);
		
	}/*setGeneralTab*/
	
	public void setNetworkTab() {
		PnlNetwork.setLayout(null);
		lblHost    = new JLabel("Host"); 
		lblPort    = new JLabel("Port");
		lblAttempt = new JLabel("Number of Connecting Attempts");
		lblTimeOut = new JLabel("Time Out Between Attempts");
		lblHost.setBounds(100,50,200,20);
		lblPort.setBounds(100,90,200,20);
		lblAttempt.setBounds(100,130,200,20);
		lblTimeOut.setBounds(100,170,200,20);
		PnlNetwork.add(lblHost);
		PnlNetwork.add(lblPort);
		PnlNetwork.add(lblAttempt);
		PnlNetwork.add(lblTimeOut);
		
		tfHost = new JTextField();
		tfPort = new JTextField();
		tfHost.setBounds(320,50,180,20);
		tfPort.setBounds(320,90,180,20);
		PnlNetwork.add(tfHost);
		PnlNetwork.add(tfPort);
		
		chAttempt = new Choice();
		chTimeOut = new Choice();
		chAttempt.setBounds(320,130,100,20);
		chTimeOut.setBounds(320,170,100,20);
		chAttempt.add("5");
		chAttempt.add("10");
		chAttempt.add("15");
		chAttempt.add("20");
		chTimeOut.add("10 sec");
		chTimeOut.add("15 sec");
		chTimeOut.add("20 sec");
		PnlNetwork.add(chAttempt);
		PnlNetwork.add(chTimeOut);
		
		cbExit    = new JCheckBox("Exit on Failing After All Attempts");
		cbExit.setBounds(100,210,250,20);
		PnlNetwork.add(cbExit);
		
		btnNetSave    = new JButton("Save");
		btnNetReset = new JButton("Reset");
		btnNetCncl  = new JButton("Cancel");
		btnNetSave.setBounds(180,500,80,20); 
		btnNetReset.setBounds(285,500,80,20);
		btnNetCncl.setBounds(390,500,80,20);
		PnlNetwork.add(btnNetSave);
		PnlNetwork.add(btnNetReset);
		PnlNetwork.add(btnNetCncl);
	}/*setNetworkTab*/
	
	public void setThemesTab() {
		PnlThemes.setLayout(null);
		lblSlctTheme = new JLabel("Select Theme");
		lblPrevious  = new JLabel("Previous Theme");
		lblSetBg     = new JLabel("BackGround Colour");
		lblSetFg     = new JLabel("ForeGround Colour");
		lblSetFont   = new JLabel("Font");
		lblSlctTheme.setBounds(100,50,200,20);
		lblPrevious.setBounds(100,90,200,20);
		lblSetBg.setBounds(100,130,200,20);
		lblSetFg.setBounds(100,170,200,20);
		lblSetFont.setBounds(100,210,200,20);
		PnlThemes.add(lblSlctTheme);
		PnlThemes.add(lblPrevious);
		PnlThemes.add(lblSetBg);
		PnlThemes.add(lblSetFg);
		PnlThemes.add(lblSetFont);
		
		tfSlctTheme = new JTextField();
		tfPrevious  = new JTextField();
		tfSetBg     = new JTextField(); 
		tfSetFg     = new JTextField();
		tfFont      = new JTextField();
		tfSlctTheme.setBounds(320,50,180,20); 
		tfPrevious.setBounds(320,90,180,20);
		tfSetBg.setBounds(320,130,180,20);
		tfSetFg.setBounds(320,170,180,20);
		tfFont.setBounds(320,210,180,20);
		PnlThemes.add(tfSlctTheme);
		PnlThemes.add(tfPrevious);
		PnlThemes.add(new JSeparator(JSeparator.HORIZONTAL));
		PnlThemes.add(tfSetBg);
		PnlThemes.add(tfSetFg);
		PnlThemes.add(tfFont);
		
		btnThemSave    = new JButton("Save");
		btnThemReset = new JButton("Reset");
		btnThemCncl  = new JButton("Cancel");
		btnThemSave.setBounds(180,500,80,20); 
		btnThemReset.setBounds(285,500,80,20);
		btnThemCncl.setBounds(390,500,80,20);
		PnlThemes.add(btnThemSave);
		PnlThemes.add(btnThemReset);
		PnlThemes.add(btnThemCncl);
	}/*setThemesTab*/
	
	public void setContentTab() {
		PnlContent.setLayout(null);
		lblStrgDir = new JLabel("Storage Directory");
		lblStrgDir.setBounds(80,50,200,20);
		PnlContent.add(lblStrgDir);
		
		tfStrgDir = new JTextField();
		tfStrgDir.setBounds(200,50,250,20);
		//tfStrgDir.setEditable(false);
		PnlContent.add(tfStrgDir);
		btnBrowse = new JButton("Browse");
		btnBrowse.setBounds(470,50,100,20);
		PnlContent.add(btnBrowse);
		
		btnCntSave    = new JButton("Save");
		btnCntReset = new JButton("Reset");
		btnCntCncl  = new JButton("Cancel");
		btnCntSave.setBounds(180,500,80,20); 
		btnCntReset.setBounds(285,500,80,20);
		btnCntCncl.setBounds(390,500,80,20);
		PnlContent.add(btnCntSave);
		PnlContent.add(btnCntReset);
		PnlContent.add(btnCntCncl);
	}/*setContentTab*/
	
	public static void main(String args[]) {
		JFrame f = new JFrame();
		new Settings(f);
	}
	public void loadSettings() {
		/*General Settings*/
		int host    = Integer.parseInt(IniParser.parse("settings.ini", "general", "MIN_SYS_TRAY"));
        if(host>0) cbTray.setSelected(true);
		else       cbTray.setSelected(false);
		
		
		int port    = Integer.parseInt(IniParser.parse("settings.ini", "general", "LAUNCH_ON_SYS_STARTUP"));
		if(port>0) cbStartUp.setSelected(true);
		else       cbStartUp.setSelected(false);
		
		int attempt = Integer.parseInt(IniParser.parse("settings.ini", "general", "SHOW_WARNING"));
		if(attempt>0) cbWarning.setSelected(true);
		else          cbWarning.setSelected(false);
		
		int timeout = Integer.parseInt(IniParser.parse("settings.ini", "general", "SHOW_SPLASH_SCREEN"));
		if(timeout>0) cbSplash.setSelected(true);
		else          cbSplash.setSelected(false);
		
		/*Network Settings*/
		tfHost.setText(IniParser.parse("settings.ini", "network", "HOST"));
		tfPort.setText(IniParser.parse("settings.ini", "network", "PORT"));
		chAttempt.select(IniParser.parse("settings.ini", "network", "ATTEMPTS"));
		chTimeOut.select(IniParser.parse("settings.ini", "network", "TIME_OUT_DURATION")+" sec");
		int j = Integer.parseInt(IniParser.parse("settings.ini", "network", "EXIT_ON_FAILURE"));
		if(j>0) cbExit.setSelected(true);
		else    cbExit.setSelected(false);
		
		/*Theme Settings*/
		tfSlctTheme.setText(IniParser.parse("settings.ini", "themes", "SEL_THEME"));
		tfPrevious.setText(IniParser.parse("settings.ini", "themes", "PRVS_THEME"));
		tfSetBg.setText(IniParser.parse("settings.ini", "themes", "BG_COLOUR"));
		tfSetFg.setText(IniParser.parse("settings.ini", "themes", "FG_COLOUR"));
		tfFont.setText(IniParser.parse("settings.ini", "themes", "FONT"));
			
		/*Content Settings*/
		tfStrgDir.setText(IniParser.parse("settings.ini", "content", "STRG_DIR"));
	
	    System.out.println("-- done load settings --");
	
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("CMD_GEN_SAVE")){
			d.setVisible(false); 
			//dispose();
		}
		if(ae.getActionCommand().equals("CMD_BROWSE")) {
			JFrame f = new JFrame();
			f.setSize(300,300);
			JFileChooser chooser = new JFileChooser(); 
			chooser.setDialogTitle("Select Directory");
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		    //disable the "All files" option.
			chooser.setAcceptAllFileFilterUsed(false); 
		    chooser.showOpenDialog(f);
			 tfStrgDir.setText(""+chooser.getSelectedFile());
		}
		if(ae.getActionCommand().equals("CMD_GEN_SAVE")) {
		
			if(cbTray.isSelected())    IniParser.write("settings.ini", "general", "MIN_SYS_TRAY", "1");
			else            		   IniParser.write("settings.ini", "general", "MIN_SYS_TRAY", "0");	
			if(cbStartUp.isSelected()) IniParser.write("settings.ini", "general", "LAUNCH_ON_SYS_STARTUP", "1");
			else            		   IniParser.write("settings.ini", "general", "LAUNCH_ON_SYS_STARTUP", "0");	
			if(cbWarning.isSelected()) IniParser.write("settings.ini", "general", "SHOW_WARNING", "1");
			else            		   IniParser.write("settings.ini", "general", "SHOW_WARNING", "0");	
			if(cbSplash.isSelected())  IniParser.write("settings.ini", "general", "SHOW_SPLASH_SCREEN", "1");
			else            		   IniParser.write("settings.ini", "general", "SHOW_SPLASH_SCREEN", "0");	
		
		}
		
		
		if(ae.getActionCommand().equals("CMD_NET_SAVE"))     {
			IniParser.write("settings.ini", "network", "HOST", tfHost.getText());
			IniParser.write("settings.ini", "network", "PORT", tfPort.getText());
			IniParser.write("settings.ini", "network", "ATTEMPTS", chAttempt.getSelectedItem());
			IniParser.write("settings.ini", "network", "TIME_OUT_DURATION", chTimeOut.getSelectedItem());
			if(cbExit.isSelected()) IniParser.write("settings.ini", "network", "EXIT_ON_FAILURE", "1");
			else            		IniParser.write("settings.ini", "network", "EXIT_ON_FAILURE", "0");	
		}
		//if(ae.getActionCommand().equals("CMD_NET_RESET"))    {}
		//if(ae.getActionCommand().equals("CMD_NET_CANCEL"))   {}
		if(ae.getActionCommand().equals("CMD_THEME_SAVE")) {
			IniParser.write("settings.ini", "themes", "SEL_THEME", tfSlctTheme.getText());
			IniParser.write("settings.ini", "themes", "PRVS_THEME", tfPrevious.getText());
			IniParser.write("settings.ini", "themes", "BG_COLOUR", tfSetBg.getText());
			IniParser.write("settings.ini", "themes", "FG_COLOUR", tfSetFg.getText());
			IniParser.write("settings.ini", "themes", "FONT", tfFont.getText());
		}
		if(ae.getActionCommand().equals("CMD_CNT_SAVE")) {
			IniParser.write("settings.ini", "content", "STRG_DIR", tfStrgDir.getText());
		}
		
		//if(ae.getActionCommand().equals("CMD_NET_RESET"))    {}
		//if(ae.getActionCommand().equals("CMD_NET_CANCEL"))   {}
		//if(ae.getActionCommand().equals("CMD_THEME_RESET"))  {}
		//if(ae.getActionCommand().equals("CMD_THEME_CANCEL")) {}
		//if(ae.getActionCommand().equals("CMD_GEN_RESET"))    {}
		//if(ae.getActionCommand().equals("CMD_GEN_CANCEL"))   {}
		//if(ae.getActionCommand().equals("CMD_CNT_RESET"))    {}
		//if(ae.getActionCommand().equals("CMD_CNT_CANCEL"))   {}
		
	}
}


