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
//Creation Date:  July 27, 2011
//Authors :       Simranpal Singh, Varinder Pal Singh

import java.util.*;
class Parse {
	String msg  = "GLIDnavjot:weavebytes&simran:java&varinder:cloud&";
    String msg1 = "ULIDnavjot:weavebytes&simran:java&varinder:cloud&";
	String msgUFLR = "UFLRsimran/java/navi/";
	String msgUFLD = "UFLDd*java:d*songs:f*xyz.doc:f*abc.txt";
	
	//GLIDnavjot:weavebytes&simran:java&varinder:cloud&
	public void parseGLID(String m) {
		StringTokenizer st = new StringTokenizer(m.substring(4), "&");
		while (st.hasMoreTokens()) {
			int i = m.indexOf(":");
			int j = m.indexOf("&");
			if( i == -1)
				break; 
			String s = m.substring(i+1,j);
			m        = m.substring(j+1);
			if(i>0&&j>0)
			 System.out.println(s);
		}
	}
	
	//ULIDnavjot:weavebytes&simran:java&varinder:cloud&
    public void ULID(String m) {
		StringTokenizer st = new StringTokenizer(m.substring(4), ":");
		int i = m.indexOf(":");
		String s = m.substring(4,i);
		System.out.println(s);
		while (m.length()>1) {
			int j = m.indexOf("&");
			if (j==-1)
			{
				break;
			}
			m = m.substring(j+1);
			int k = m.indexOf(":");
			if (k==-1)
			{
				break;
			}
			String sb = m.substring(0,k);
			System.out.println(sb);
		}
	}
	//ULFRsimran/java/navi/
	public void UFLR(String m) {
		StringTokenizer st = new StringTokenizer(m.substring(4), "/");
		int i = m.indexOf("/");
		String s = m.substring(4,i);
		System.out.println(s);
		while (m.length()>1) {
			int k = m.indexOf("/");
			if (k==-1)
			{
				break;
			}
			m = m.substring(k+1);
			int j = m.indexOf("/");
			if (j==-1)
			{
				break;
			}
			String sb = m.substring(0,j);
			System.out.println(sb);
		}
	}
	
	//UFLDd*java:d*songs:f*xyz.doc:f*abc.txt
	public void UFLD(String m) {
		Hashtable group = new Hashtable();
		m = m.substring(4);
		while (m.length()>1) {
			int k = m.indexOf(":");
			if (k==-1)
			{
				break;
			}
			String sb = m.substring(0,k);
			m = m.substring(k+1);
			//System.out.println("sb is "+sb);
			int star = sb.indexOf("*");
			String fType = sb.substring(0,star);
			String fName = sb.substring(star+1);
			System.out.println("Name : "+fName);
			System.out.println("Type : "+fType);
			group.put(fName,fType);
		}
		Enumeration list;
		list = group.keys();
		while(list.hasMoreElements())
		{
			String str = (String)list.nextElement();
			System.out.println(group.get(str));
		}
	}
		
	public static void main(String[] args) 
	{
		Parse g = new Parse();
			//g.parseGLID(g.msg);
			
		Parse u = new Parse();
		//u.ULID(u.msg1);
		Parse f = new Parse();
		//f.UFLR(f.msgUFLR);
		
		Parse f1 = new Parse();
		f1.UFLD(f.msgUFLD);
	}
}
