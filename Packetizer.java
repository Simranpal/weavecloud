/*
 * Copyright (C) 2010 WeaveBytes, Inc.,
 *
 * Confidential, all rights reserved. No distribution is permitted.

  ___            ______	    ____      ________ 
  \  \    __    /     __|  /	\    /     ___|
   \  \  /  \  /     |_	  /  /\  \  /     |_
    \  \/    \/  /|   _| /  /__\  \/  /|   _|
     \    /\    / |  |__/  ______    / |  |___
      \__/  \__/  |_______/	 \ _/  |______|
	  
			        ___                                      __
			 ______ |  |    ________    __      __          |  |
			/  ___|	|  |   /   __   \  |  |    |  |  _______|  |
			|  |	|  |   |  |  |  |  |  |    |  | /   ____|  |
			|  |____|  |__ |  |__|  |__|  \____/  | \  \____|  |
			\_______|______\________/__ \________/__ \_________|

Description      :  Packetizer.java is the class for containing information about packets 
Creation Date    :  August 04, 2011
Authors          :  Simranpal Singh, Varinder Pal Singh
Project Manager  :  Navjot Singh
*/

import java.io.*;

class Packetizer {
    private InputStream   is;
    private int           size;
    private OutputStream  f;
    private int           pktCount = -1;
    private int           curPkt = 0;

    Packetizer(String filename) throws Exception {
        is       = new FileInputStream(filename);
        size     = is.available();
        pktCount = size/Config.FTP_PKT_SIZE;
        if(size%Config.FTP_PKT_SIZE != 0)	pktCount ++;


        log.info("Created Packetizer for " + filename + ", size=" + size + ", pktCount=" + pktCount);
    }

    public int count() { return pktCount; }

    public String nextPacket() throws Exception {
        String packet="";
        byte data[] = new byte[Config.FTP_PKT_SIZE];
        int len = is.read(data);
        log.debug("len = " + len);
        
        curPkt++;
        return new String(data, 0, len);
    }

    public boolean hasMorePackets() { return curPkt < pktCount;}

    public void release() throws Exception{
        is.close();
    }

    public static void main(String args[]) {
        try
        {
            int pktCount = 1;
            Packetizer pizer = new Packetizer(args[0]);
            while(pizer.hasMorePackets()) {
                System.out.println(pktCount + ":" + pizer.nextPacket());
                pktCount++;
            }
            pizer.release();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

}
