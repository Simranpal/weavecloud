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
//Description:    Composer.java class is a class that composes new request to server 
//Creation Date:  August 2, 2011
//Authors :       Simranpal Singh, Varinder Pal Singh

class Compose {
	// function composes a CNUR request
	public static String CNUR(String Fname, String Lname, String Usr, String Pwd, String Dob,String Gender ,String Sques,String Ans, String Email) {
		String strCnur = "CNUR"+Fname+":"+Lname+":"+Usr+":"+Pwd+":"+Dob+":"+Gender+":"+Sques+":"+Ans+":"+Email+":";
		return strCnur;
	}
}