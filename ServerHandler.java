/* Copyright (C) 2010 WeaveBytes, Inc.,
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
//Creation Date    : October 27, 2011
//Authors          : Simranpal Singh, Varinder Pal Singh
//Project Manager  : Navjot Singh

import java.net.*;
import java.io.*;
class ServerHandler implements Runnable {
    Socket       cs = null;
    OutputStream os = null;
    InputStream  is = null;
    Thread       t1 = null;
	
	private final int PACKET_SIZE=1024;
    private DashBoard DB;
	String s = "";
    ServerHandler(Socket cs, DashBoard DB) {
        this.cs = cs;
        this.DB = DB;
        t1 = new Thread(this);
		t1.start();
    }
    public void run() {
        log.debug("ServerHandler started...");
        while(true) {
            try {
                //get input/output streams from the socket.     
                if(os == null) { os = cs.getOutputStream();  }
         		if(is == null) { is = cs.getInputStream(); }

                byte msg[] = new byte[PACKET_SIZE];
                int len  = is.read(msg);
                if(len == -1 ) { 
                    DB.setConnectedStatus(false);
                    DB.doSleep(2000);
                    DB.connectServer();
                    break; 
                }
				
                for(int x =0; x<len; x++) s+= (char)msg[x];
                log.info("Server Says : " + s);
				System.out.println("s is "+s);
				if(s.startsWith("UFLD")) TreePanel.UFLD(s);
            }
            catch (Exception e) {
                System.out.println("Got exception " + e);
            }
        }
    }
    
    public void sendMessage(String msg) {
        log.debug("Sending : " + msg);
		if(os == null) { return; }
        
		try {
            os.write(msg.getBytes());
        }
        catch(Exception e) {
		 e.printStackTrace();
        }
    }
}
