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
//Description:    Server.java simulates the behaviour of remote server.
//Creation Date:  August 5, 2011
//Authors :       Simranpal Singh, Varinder Pal Singh

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//class Server is used for simulation and testing of server behaviour
class Server extends JFrame {//implements ActionListener {	
	static String validProtocols[] ={"CNGR", "CNGA", "CNUR"};
	
	//constructor
	Server() {
	}

	public static void submitRequest(String request) {
		String subrequest = request.substring(0,4);
		if(ServerUtils.checkString(validProtocols,subrequest)) System.out.println("Valid Protocol");
		else System.out.println("InValid Protocol");
			
	}

	//using main for testing the class features
/*	public static void main(String[] args) 	{
		Server server = new Server(...);
		server.submitRequest("CNGR:Simran:Sports:");
		server.submitRequest("CNGR:Simran:Sports:"); 

		
	}*/
}//Server
