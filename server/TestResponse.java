import java.io.*;
class TestRespone {
	static String path = "D:\\WC\\";
	static String UFLD = "UFLD";
	static File f, f1;
	public static void main(String args[]) {
		String a = "UFLRJava\\New Folder";
		handleUFLR(a);
	}
	public static void handleUFLR(String msg) {
		msg = msg.substring(4);
		msg = path + msg;
		f = new File(msg);
		String list[] = f.list();
		for(int i =0; i< list.length;i++) {			
			f1 = new File(msg + "\\" + list[i]);
			System.out.println("F1 is "+f1.toString());
			if(f1.isDirectory()) { UFLD += "d*"+list[i] + ":"; }
			if(f1.isFile())       { UFLD += "f*"+list[i] + ":"; }
		}
		System.out.println("UFLD IS "+UFLD);
		
	}
}