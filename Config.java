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
//Description      :  Config.java class defines the configuration of weavecloud 
//Creation Date    :  August 04, 2011
//Authors          :  Simranpal Singh, Varinder Pal Singh
//Project Manager  :  Navjot Singh


import java.awt.*;
class Config {


    public static final int SERVER_CONNECT_ATTEMPTS = 20;
    public static final String HOST = "127.0.0.1";
    public static final int PORT = 7777;

    /*Packet Size in Bytes*/
    public static final int FTP_PKT_SIZE = 512;  

    //Login Window Settings
    static Color LOGIN_BG_COLOR = new Color(100,150,200);

    //Registeration Window Settings
    static Color REGIS_BG_COLOR = new Color(100,150,200);

    //Dashboard Window Settings
    static Color DASHBOARD_BG_COLOR = new Color(100,150,200);

    //GUI States
    public static final int E  = -1;
    public static final int DL = 0;
    public static final int D  = 1;
    public static final int DR = 2;

    public static void enterLoginState() {}
    public static void leaveLoginState() {}
    public static void enterDashboardState() {}
    public static void leaveDashboardState() {}

    //Logging levels
    public static final int LOG_DEBUG    = 0;
    public static final int LOG_INFO     = 1;
    public static final	int LOG_WARNING  = 2;
    public static final int LOG_CRITICAL = 3;
    public static final int LOG_ERROR    = 4;

    //Current Log level
    public static final int LOG_LEVEL = LOG_DEBUG;



    //string commands to be attached with buttons, menu items etc
    public static final String CMD_REGISTER		 = "CMD_REGISTER";	
    public static final String CMD_EXIT			 = "CMD_EXIT";
    public static final String CMD_CREATE_GROUP  = "CMD_CREATE_GROUP";
    public static final String CMD_JOIN_GROUP    = "CMD_JOIN_GROUP";
    public static final String CMD_INVITE		 = "CMD_INVITE";
    public static final String CMD_INBOX		 = "CMD_INBOX";
    public static final String CMD_SETTINGS		 = "CMD_SETTINGS";
    public static final String CMD_HELP			 = "CMD_HELP";
    public static final String CMD_ABOUT		 = "CMD_ABOUT";
    public static final String CMD_FILE_UPLOAD	 = "CMD_FILE_UPLOAD";
}
