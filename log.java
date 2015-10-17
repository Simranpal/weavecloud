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

//Description:    log.java is the logger class for weavecloud 
//Creation Date:  August 30, 2011
//Authors :       Simranpal Singh, Varinder Pal Singh

public class log {

    public static void debug(String msg) {
	  if(Config.LOG_LEVEL <= Config.LOG_DEBUG) 
	    System.out.println("[DEBUG] " + msg);
		}
	  public static void info(String msg) {
	   if(Config.LOG_LEVEL <= Config.LOG_INFO) 
	    System.out.println("[INFO] " + msg);
	  }
	  public static void warning(String msg) {
	   if(Config.LOG_LEVEL <= Config.LOG_WARNING) 
	    System.out.println("[WARNING] " + msg);
	  }
	  public static void critical(String msg) {
	   if(Config.LOG_LEVEL <= Config.LOG_CRITICAL)
	    System.out.println("[CRITICAL] " + msg);
	  }
	  public static void error(String msg) {
	   if(Config.LOG_LEVEL <= Config.LOG_ERROR)
	    System.out.println("[ERROR] " + msg);
	  }
}