/*
Description      : IniParser.java contains ini parser code.
Creation Date    : October 08, 2011
Authors          : Navjot Singh
Project Manager  : Navjot Singh
*/

import java.io.*;

class IniParser {
	public static void write(String iniFile, String section, String element, String value) {
		String  curKey         = "";
        String  curVal         = "";
		String checkSection    = "";
        boolean sectionStarted = false;
		FileReader     fr;
        BufferedReader in;
		BufferedWriter out;
		OutputStreamWriter Sr;
		try {
			File file 	   = new File("temp.ini");  
			OutputStream f = new FileOutputStream(file, false);
			fr 			   = new FileReader(iniFile);
            in 			   = new BufferedReader(fr);
			Sr 			   = new OutputStreamWriter(f);
			out			   = new BufferedWriter(Sr);
			String line;
			int length = 0, offset =0;
            while ((line = in.readLine()) != null) {

                if(line.startsWith(";")) {
					line+= "\r\n";
					length = line.length();				
					Sr.flush();
					Sr.write(line, 0, length);
					continue;
				}
				else if(line.startsWith("[")) {
					int a          = line.indexOf("]");
					checkSection   = line.substring(1,a);
					line		  += "\r\n";
					length 		   = line.length();				
					Sr.flush();
					Sr.write(line, 0, length);
				}
				else {
					line += "\r\n";			
					int i = line.indexOf("=");
  
					if(i<0) continue;

					curKey = line.substring(0, i).trim();
					curVal = line.substring(i+1);
					if(curKey.equals(element)) {
						line+= "\r\n";
						Sr.write(line, 0, i+1);
						curVal = value;
						curVal+= "\r\n";
						Sr.write(curVal, 0, curVal.length());
						Sr.flush();
					}
					else {
						line+= "\r\n";
						Sr.write(line, 0, line.length());
						Sr.flush();
					}
				}
            }
			f.close();
			fr.close();
			in.close();
			Sr.close();
			out.close();
			
			File f2 = new File(iniFile);
		    if (!f2.exists())		throw new IllegalArgumentException("Delete: no such file or directory: " + iniFile);
			 
			if (!f2.canWrite())		throw new IllegalArgumentException("Delete: write protected: "+ iniFile);
			
			if (!f2.delete()) 		throw new IOException("Unable to delete file "+	f2.getName());  
					
		  	new File("temp.ini").renameTo(new File ("settings.ini"));
		}
		catch(Exception e) { System.out.println(e); }
	}	
    public static String parse(String iniFile, String section, String element) {

        String  curKey         = "";
        String  curVal         = "";
        boolean sectionStarted = false;

        /*ensure ini file*/
        if(!verifyIni()) {
            System.out.println("Invalid ini file: " + iniFile);
            return curVal;
        }
        
        FileReader     fr = null;
        BufferedReader in = null;
        try {
            fr = new FileReader(iniFile);
            in = new BufferedReader(fr);
            String line;
            while ((line = in.readLine()) != null) {

                /*remove blank spaces at start and end of line*/
                line=line.trim();

                /*ignore comments*/
                if(line.startsWith(";")) continue;

                /*hunt section*/
                if(!sectionStarted) {
                    if(line.startsWith("[" + section + "]")) sectionStarted = true;
                    continue;
                }
    
                /*section ended*/
                if(line.startsWith("[")) { 
				 fr.close();
			     in.close();
				 return curVal;
				}
                 
				//System.out.println(line);
                /*fetch current element*/
                int i = line.indexOf("=");
  
				/*ignore lines where '=' is not found*/
				if(i<0) continue;

				curKey = line.substring(0, i).trim();
                curVal = line.substring(i+1).trim();
                if(curKey.equals(element)) {
				fr.close();
			    in.close();
				return curVal;
                 }
				}//while
			
        }
        catch(Exception e) {
            e.printStackTrace();
			System.out.println("ERROR:: Failed to parse '" + element + "' from " + iniFile);
            
        }
		try {
        fr.close();
	    in.close();
		}catch(Exception e1){}
        return "";
    }

    private static boolean verifyIni() {
        /*TODO add code to verify validity of given ini file*/
        return true;
    }

    public static void main(String args[]) {
      /*if(args.length !=1) {
            System.out.println("Usage: \njava IniParser <ini-file-path>");
            return;
        }
		*/
		//IniParser.write("settings.ini", "MIN_SYS_TRAY","1");
	//	IniParser.write("settings.ini", "general", "MIN_SYS_TRAY","100");
	//	IniParser.write("settings.ini", "themes", "SEL_THEME","Brown");
		IniParser.write("settings.ini", "content", "STRG_DIR", "WEAVECLOUD/");
	}
}//IniParser
