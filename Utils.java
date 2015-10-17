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


//Description:    Registration.java is the class for registering a new user on weavecloud 
//Creation Date:  July 20, 2011
//Authors :       Simranpal, Varinder Pal Singh

class Utils {
	public static boolean ensurePattern(String charSet, String str) {
	  if(str.length()==0 || charSet.length()==0) return false;
	  for(int i=0; i<str.length(); i++) {
	      String ch = ""+str.charAt(i);
	      if(charSet.indexOf(ch) == -1) return false;
	    }
       return true;
	}//ensurePattern
}//Utils
