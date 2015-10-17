/*
 * Copyright (C) 2010 WeaveBytes, Inc.,
 *
 * Confidential, all rights reserved. No distribution is permitted.

  ___            ______     ____      ________ 
  \  \    __    /     __|  /	\    /     ___|
   \  \  /  \  /     |_	  /  /\  \  /     |_
    \  \/    \/  /|   _| /  /__\  \/  /|   _|
     \    /\    / |  |__/  ______    / |  |___
      \__/  \__/  |_______/	     \ _/  |______|
	  
			        ___                                     __
			 ______ |  |    ________    __      __         |  |
			/  ___|	|  |   /   __   \  |  |    |  |  ______|  |
			|  |	|  |   |  |  |  |  |  |    |  | /   ___   |
			|  |____|  |__ |  |__|  |__|  \____/  | \  \___|  |
			\_______|______\________/__ \________/__ \________|
*/

//Description      : Dashboard.java is the main page for weavecloud 
//Creation Date    : July 27, 2011
//Authors          : Simranpal Singh, Varinder Pal Singh
//Project Manager  : Navjot Singh

import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
import javax.swing.tree.*;
import java.net.*;
import java.io.*;

class DashBoard extends JFrame implements ActionListener {	
	private JMenuBar 	  mb;
	private JMenu		  cloud, groups, inbox, options, help;	
    private JMenuItem     hwhelp,habout;
    private JMenuItem     cregister, cexit;
    private JMenuItem     gcreate,gjoin,ginvite;
    private JMenuItem     osettings;
    private JMenuItem     miFileUp;
    private JButton       inviteButton;
    private JPanel        mainPane, treePane;
    private CloudLogin    login;
	private JToolBar	  toolbar;
    private JLabel        status;
    private boolean       isConnected = false;
    private Socket        socket;
	static  InputStream   is       = null;
    static  OutputStream  os       = null;
    private ServerHandler sHandler = null;
    private String        user     = "test"; //dummy user
	DashBoard() {	
        super("Weave Cloud");
        setSize(800, 600);
        setLocation(200, 200);
        setIconImage(Toolkit.getDefaultToolkit().getImage("images/icons/32x32/cloud.png"));
        setLayout(new BorderLayout());

        addMenus();

        setupToolbar();
        SplitPane();
        /*status label*/
        status = new JLabel("");
        add(status, BorderLayout.SOUTH);

	//	setDbFont(16);
   //   setDbColor("CYAN");
		new TreePanel(this);
        setVisible(true);
        connectServer();
		
	}//constructor
	
	public void setDbColor(String color){
	//Color c = color;
		if(color=="CYAN"){
			mainPane.setBackground(Color.CYAN);
			treePane.setBackground(Color.CYAN);
			mb.setBackground(Color.CYAN);
			toolbar.setBackground(Color.CYAN);
		}
	}
	public void setDbFont(int font) {
		Font value = new Font("Courier New",Font.PLAIN,font);
		cloud.setFont(value);
		groups.setFont(value);
		inbox.setFont(value);
		options.setFont(value);
		help.setFont(value);
		status.setFont(value);
		cregister.setFont(value);
		hwhelp.setFont(value);
		habout.setFont(value);
		cexit.setFont(value);
		gcreate.setFont(value);
		gjoin.setFont(value);
		ginvite.setFont(value);
		osettings.setFont(value);
		miFileUp.setFont(value);
	}
    public void SplitPane() {
        //treePane.setLineWrap(true);
        //mainPane.setLineWrap(true);
        treePane.setMinimumSize(new Dimension(150, 150));
        mainPane.setMinimumSize(new Dimension(150, 150));
        treePane.setPreferredSize(new Dimension(600, 600));
		treePane.setLayout(new BorderLayout());
        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treePane, mainPane);
        getContentPane().add(sp, BorderLayout.CENTER);
    }

    public void addMenus() {
        mb = new JMenuBar();
        setJMenuBar(mb);
         cloud = new JMenu("Cloud");
         groups = new JMenu("Groups");
         inbox = new JMenu("Inbox");
         options = new JMenu("Options");
         help = new JMenu("Help");
        mb.add(cloud);
        mb.add(groups);
        mb.add(inbox);
        mb.add(options);
        mb.add(help);
		
        cregister = new JMenuItem("Register", new ImageIcon(getClass().getResource("images/icons/16x16/register.png")));
        cexit     = new JMenuItem("Exit", new ImageIcon(getClass().getResource("images/icons/16x16/exit.png")));
        gcreate   = new JMenuItem("Create", new ImageIcon(getClass().getResource("images/icons/16x16/group.png")));
        gjoin     = new JMenuItem("Join", new ImageIcon(getClass().getResource("images/icons/16x16/user.png")));			
        ginvite   = new JMenuItem("Invite", new ImageIcon(getClass().getResource("images/icons/16x16/invite.png")));
        osettings = new JMenuItem("Settings", new ImageIcon(getClass().getResource("images/icons/16x16/setting.png")));
        hwhelp    = new JMenuItem("Weave Cloud Help", new ImageIcon(getClass().getResource("images/icons/16x16/help.png")));
        habout    = new JMenuItem("About", new ImageIcon(getClass().getResource("images/icons/16x16/cloud.png")));
        miFileUp  = new JMenuItem("File Upload", new ImageIcon(getClass().getResource("images/icons/16x16/cloud.png")));

        mainPane = new JPanel();
        treePane = new JPanel();
        cregister.setActionCommand(Config.CMD_REGISTER);
        gcreate.setActionCommand(Config.CMD_CREATE_GROUP); 
        gjoin.setActionCommand(Config.CMD_JOIN_GROUP);
        ginvite.setActionCommand(Config.CMD_INVITE);
        osettings.setActionCommand(Config.CMD_SETTINGS);
        miFileUp.setActionCommand(Config.CMD_FILE_UPLOAD);
        hwhelp.setActionCommand(Config.CMD_HELP);
        habout.setActionCommand(Config.CMD_ABOUT);
        cexit.setActionCommand(Config.CMD_EXIT);

        cloud.add(cregister);
        cloud.add(cexit);
        groups.add(gcreate);
        groups.add(gjoin);
        groups.add(ginvite);
        options.add(miFileUp);
        options.add(osettings);
        help.add(hwhelp);
        help.add(habout);

        cregister.addActionListener(this);
        miFileUp.addActionListener(this);
        cexit.addActionListener(this);
        gcreate.addActionListener(this);
        gjoin.addActionListener(this);
        ginvite.addActionListener(this);
        osettings.addActionListener(this);
        habout.addActionListener(this);
    }

    private void setupToolbar() {
        toolbar = new JToolBar();
        //Create
        JButton createButton = new JButton(new ImageIcon(getClass().getResource("images/icons/64x64/group.png")));
        createButton.setToolTipText("Create a new group ");
        toolbar.add(createButton);
        createButton.setActionCommand(Config.CMD_CREATE_GROUP); 
        createButton.addActionListener(this);

        //Join
        JButton joinButton = new JButton(new ImageIcon(getClass().getResource("images/icons/64x64/user.png")));
        joinButton.setToolTipText("Join an existing group");
        toolbar.add(joinButton);
        joinButton.addActionListener(this);
        joinButton.setActionCommand(Config.CMD_JOIN_GROUP);
        //Invite
        JButton inviteButton = new JButton(new ImageIcon(getClass().getResource("images/icons/64x64/invite.png")));
        inviteButton.setToolTipText("Invite a Friend");
        toolbar.add(inviteButton);
        inviteButton.addActionListener(this);
        inviteButton.setActionCommand(Config.CMD_INVITE);

        //Settings
        JButton settingButton = new JButton(new ImageIcon(getClass().getResource("images/icons/64x64/setting.png")));
        settingButton.setToolTipText("Change settings");
        toolbar.add(settingButton);
        settingButton.addActionListener(this);
        settingButton.setActionCommand(Config.CMD_SETTINGS);

        //Help
        JButton helpButton = new JButton(new ImageIcon(getClass().getResource("images/icons/64x64/help.png")));
        helpButton.setToolTipText("About WeaveCloud");
        toolbar.add(helpButton);
        helpButton.addActionListener(this);
        helpButton.setActionCommand(Config.CMD_HELP);

        //Exit
        JButton exitButton = new JButton(new ImageIcon(getClass().getResource("images/icons/64x64/exit.png")));
        exitButton.setToolTipText("Exit from Weave Cloud..");
        toolbar.add(exitButton);
        exitButton.addActionListener(this);
        exitButton.setActionCommand(Config.CMD_EXIT);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Add Toolbar to JFrame
        add(toolbar, BorderLayout.NORTH);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals(Config.CMD_REGISTER))	         new Registration(this); 
        if(ae.getActionCommand().equals(Config.CMD_EXIT))	             System.exit(0);
        if(ae.getActionCommand().equals(Config.CMD_CREATE_GROUP))        new GroupAdd(this);
        if(ae.getActionCommand().equals(Config.CMD_JOIN_GROUP))	         new JoinGroup(this);	  
        if(ae.getActionCommand().equals(Config.CMD_INVITE))		    	 new Invitation(this);
        if(ae.getActionCommand().equals(Config.CMD_SETTINGS))		     new Settings(this);
        if(ae.getActionCommand().equals(Config.CMD_ABOUT))		    	 new AboutWeaveCloud(this); 
        if(ae.getActionCommand().equals(Config.CMD_FILE_UPLOAD))	     new Uploader(this); 
    }

    public void setStatus(String msg) {
        status.setText(msg);
    }

    public void doSleep(int msecs) {
        try { Thread.sleep(msecs); }
        catch (Exception e1){}
    }

    public void setConnectedStatus(boolean val) {
        isConnected = val;
        if(isConnected) setStatus("Connected to WeaveCloud Server.");
        else            setStatus("Disconnected from WeaveCloud Server.");
    }

    public void connectServer() {
        int attempt=0;
        while(!isConnected && attempt < Config.SERVER_CONNECT_ATTEMPTS) {
		   try {
                attempt ++;
                log.info("attempt = " + attempt);
                setStatus("#" + attempt + ") Connecting to server at " + Config.HOST + " ...");
                socket = new Socket(Config.HOST, Config.PORT);
                setConnectedStatus(true);
                byte msg[] = new byte[1024];
				is = socket.getInputStream();
				os = socket.getOutputStream();
				break;
            }
            catch (Exception e){
                doSleep(1000);
                setStatus("Failed to connect to server");
                doSleep(1000);
            }
        }
        if(!isConnected) {
            setStatus("Closing application...");
            doSleep(1000);
            System.exit(1);
        }
        sHandler = new ServerHandler(socket, this);
    }	

    public static void sendMessageToServer(String msg) {
	   if(os == null) return;
	   try {
            os.write(msg.getBytes());
	   }
	   catch (Exception e) { 
			e.printStackTrace();
	   }
    }

    public String getUser() { return user; }
	
    // main method
    public static void main(String []args) {
        //new Splash();
        DashBoard d = new DashBoard();
    }
}//DashBoard
