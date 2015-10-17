import java.net.*;
import java.io.*;


class ClientHandler implements Runnable {
    Socket       cs = null;
    OutputStream os = null;
    InputStream  is = null;
    Thread       t1 = null;
	
	String path = "D:\\WC\\";
	String UFLD = "UFLD";
	File f, f1;

    private final int PACKET_SIZE=1024;

    ClientHandler(Socket cs) {
        this.cs = cs;
        t1 = new Thread(this);
        t1.start();
    }

    public void run() {
        while(true) {
            try {
                //get input/output streams from the socket.     
                if(os == null) { os = cs.getOutputStream(); }
                if(is == null) { is = cs.getInputStream(); }

                System.out.println("Waiting for message from client at : " + cs.getInetAddress().getHostName());
                byte msg[] = new byte[PACKET_SIZE];

                int len  = is.read(msg);
                if(len == -1 ) { System.out.println("Connection broken"); break; }
                String s = "";
                for(int x =0; x<len; x++) s+= (char)msg[x];
                System.out.println("Got Msg from " + cs.getInetAddress().getHostName() + " : " + s);
                System.out.println("s is "+s );
				handleMessage(s);
				s = "";
                
            }
            catch (Exception e) {
			System.out.println("Got exception here" );
                System.out.println("Got exception " + e);
            }
        }
    }

   private boolean isValidMessage(String msg){
        if(msg.length() < Config.REQ_MIN_LEN) return false;

        for(int i=0; i<Config.REQ_TYPES.length; i++) {
            if(msg.startsWith(Config.REQ_TYPES[i])) return true;
        }
        return false;
   }

   public void sendMessage(String msg) {
        try {
            os.write(msg.getBytes());
        }
        catch(Exception e) {
        }
    }

    public void handleMessage(String msg) {
	System.out.println("Message received in handle message is "+msg);
        if(!isValidMessage(msg)) {
            sendMessage("INVALID REEQUEST:: " + msg);
            return;
        }
		
        if(msg.startsWith("FURP")) { handleFURP(msg.substring(4)); return; }
		if(msg.startsWith("UFLR")) { sendMessage(handleUFLR(msg)); return; }
		
		sendMessage("Processing request, pls wait...");
    }
	
	public String handleUFLR(String msg) {
	System.out.println("msg is "+msg );
		msg = msg.substring(4);
		msg = path + msg;
		System.out.println("Path is "+msg );
		f = new File(msg);
		String list[] = f.list();
		for(int i =0;i<list.length;i++)
			System.out.println(list[i]);
		for(int i =0; i< list.length;i++) {			
			f1 = new File(msg + "\\" + list[i]);
			if(f1.isDirectory()) { UFLD += "d*"+list[i] + ":"; }
			if(f1.isFile())       { UFLD += "f*"+list[i] + ":"; }
		}
		return UFLD;	
	}
    public void handleFURP(String msg) {
        //System.out.println(msg);
        //test:private*java*LICENSE:1:512:payload

        int i = msg.indexOf(":");
        String user = msg.substring(0, i);
        int j = msg.indexOf(":", i+1);
        String pathStr = msg.substring(i+1, j);

        int k = msg.indexOf(":", j+1);
        int pktNo =  Integer.parseInt(msg.substring(j+1, k));
        
        int l   = msg.indexOf(":", k+1);
        int len =  Integer.parseInt(msg.substring(k+1, l));

        String payload =  msg.substring(l+1);

        System.out.println("==================================================");
        System.out.println("user    =" + user);
        System.out.println("pathStr =" + pathStr);
        System.out.println("pktNo   =" + pktNo);
        System.out.println("len     =" + len);
        System.out.println("payload     =" + payload);
        System.out.println("==================================================");

        
        try {
        OutputStream f = new FileOutputStream("./tmp", pktNo > 1);
        f.write(payload.getBytes());
        f.close();
        }
        catch(Exception e) {e.printStackTrace();}
    }
}
