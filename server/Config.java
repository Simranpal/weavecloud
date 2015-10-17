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
//Description      :  Config.java class defines the configuration of server
//Creation Date    :  August 04, 2011
//Authors          :  Simranpal Singh, Varinder Pal Singh
//Project Manager  :  Navjot Singh


import java.awt.*;
class Config {

    /*4 bytes request type header that the server will accept*/
    public static final String REQ_TYPES[] = {"ULRD", "UGLD", "FURP", "FDRP","UFLR"};

    /*4 bytes of req type + some data */ //FIXME 
    public static final int REQ_MIN_LEN = 6;
    public static final int PORT = 7777;

}
