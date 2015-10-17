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
//Description:    Count.java class is used for counting words in string
//Creation Date:  August 10, 2011
//Authors :       Simranpal Singh, Varinder Pal Singh

import java.util.*;
import java.io.*;
class Count {
	public static void main(String args[]) throws Exception {
		System.out.println("Enter the String ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		new Count().wordCount(str);
	}
	public void wordCount(String a) {
		int count = 0;
		if(a.isEmpty()) count = 0;
		else {
			a = a.trim();
			StringTokenizer st = new StringTokenizer(a);
			count=st.countTokens() ;
		}
		System.out.println("Number of Word(s) in String are "+count);
	}
} 