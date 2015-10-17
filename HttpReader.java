import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class HttpReader 
{	
	public void HttpReader(String address) throws Exception {
    URL page = new URL(address);
    StringBuffer text = new StringBuffer();
    HttpURLConnection conn = (HttpURLConnection) page.openConnection();
    conn.connect();
    InputStreamReader in = new InputStreamReader((InputStream) conn.getContent());
    BufferedReader buff = new BufferedReader(in);
    
    String line;
    do {
      line = buff.readLine();
      text.append(line + "\n");
    } while (line != null);
	String ans = text.toString();
	System.out.println(ans);
}

	public static void main(String[] args) throws Exception
	{
		HttpReader hr = new HttpReader();
		hr.HttpReader("http://dx-code.org/funny.htm");
	}
}
