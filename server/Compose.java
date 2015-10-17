
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
//Description:    Parser.java is the class for parsing string in weavecloud 
//Creation Date:  October 27, 2011
//Authors :       Simranpal Singh, Varinder Pal Singh

import java.io.*;
class Compose {
	static String fileSeparator = System.getProperty("file.separator");
	public static String UFLD(String path) {
		File f,f1;
		String UFLDlist = "UFLD";
		f               = new File(path);
		String a[]      = f.list();
		
		for(int i =0; i< a.length;i++) {			
			f1 = new File(path + fileSeparator + a[i]);
			if(f1.isDirectory() && !UFLDlist.contains(a[i])) { UFLDlist += "d*"+a[i] + ":"; }
			if(f1.isFile() && !UFLDlist.contains(a[i]))      { UFLDlist += "f*"+a[i] + ":"; }
		}
		UFLDlist = UFLDlist.substring(0,UFLDlist.length()-1);
		return UFLDlist;
	}
	public static void main(String args[]) {
		System.out.println(Compose.UFLD("C:/Users/Navi/Desktop/experiments/latest-wc/experiments"));
	}	
}