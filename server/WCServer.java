import java.net.*;
import java.io.*;

class WCServer {

    public static void log(String msg) {
        System.out.println(msg);
    }
    public static void main(String args[]) {
        try
        {
            ServerSocket ss = new ServerSocket(Config.PORT);
            while(true) {
                log("Listening for clients....");
                Socket cs = ss.accept();
                new ClientHandler(cs);
            }

        }
        catch (Exception e) {
            log("Got exception" + e);			 
            e.printStackTrace();
        }
    }
}
