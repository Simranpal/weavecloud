import javax.swing.*;
import javax.swing.filechooser.*;

public class Uploader {
    DashBoard DB;

    String fpath;
    String fname;
    public Uploader(DashBoard DB) {
        log.debug("creating uploader...");
        this.DB=DB;

        if(!chooseFile()) return;

        try {
            Packetizer pizer = new Packetizer(fpath);

            int pktNo = 1;
            while(pizer.hasMorePackets()) {
                String payload = pizer.nextPacket();
                String packet  = "FURP" + DB.getUser() + ":private*java*" + fname + ":" + pktNo + ":" + payload.length();
                pktNo++;
                //log.info("Sending " + packet + ":" + payload);
                DB.sendMessageToServer(packet + ":" + payload);
                Thread.sleep(100);
            }
        }catch(Exception e) {
            e.printStackTrace();
            log.error("Got Exception while creating Packetizer for " + fpath + ", error=" + e);
        }
    }

    public boolean chooseFile() {
        boolean ret = false;
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(DB);
        if(returnVal == JFileChooser.APPROVE_OPTION) {

            fpath = chooser.getCurrentDirectory() + "/" + chooser.getSelectedFile().getName();
            fname = chooser.getSelectedFile().getName();
            ret = true;
        }
        return ret;
    }

}//Uploader
