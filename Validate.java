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
//Description:    Validate.java is the class for validating strings in weavecloud 
//Creation Date:  July 27, 2011
//Authors :       Simranpal Singh, Varinder Pal Singh

class Validate {
	static String charSet="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890-. ";
	static String nameCharSet="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-. ";
	public static boolean validatePattern(String str) {
	  if(str.length()==0 || charSet.length()==0) return false;
	  for(int i=0; i<str.length(); i++) {
	      String ch = ""+str.charAt(i);
	      if(charSet.indexOf(ch) == -1) return false;
	    }
       return true;
	}//validatePattern
	public static boolean name(String name) {
	  if(name.length()==0 || charSet.length()==0) return false;
	  for(int i=0; i<name.length(); i++) {
	      String ch = ""+name.charAt(i);
	      if(charSet.indexOf(ch) == -1) return false;
	    }
       return true;
	}
	public static boolean validateEmail(String email) {
		int i = email.indexOf("@");
		int j=0;
		String str="";
		if(i>0) {
			str = email.substring(i,email.length());
			j = str.indexOf(".");
		}
		if(j>0) {
			return true;
		}
		else return false; 
			
	}
}//Validator