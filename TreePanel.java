import javax	.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.io.*;
import javax.swing.event.*;
import java.util.Hashtable;

class TreePanel extends JFrame implements TreeSelectionListener {
	JTree tree;
	static DefaultMutableTreeNode root,node;
	String UFLDJava        = "UFLDd*AWt:d*Swing:d*Programming:f*xyz.doc:f*abc.txt:";
	String UFLDAWt         = "UFLDd*sub1:d*sub2:f*abc.java:";
	String UFLDSwing       = "UFLDd*JButton:d*Jpanel:f*abc.java:";
	String UFLDProgramming = "UFLDd*Networking:d*android:f*abc.java:";
	String UFLDsub1        = "UFLDd*songs:d*movies:f*abc.java:";
	String UFLDsub2        = "UFLDd*experiments:d*Dashboard:f*abc.java:";
	static Hashtable ht = new Hashtable();
	String req = "Java";
	JScrollPane scroll;
	int click = 0;
    TreePanel(JFrame parentFrame) {
		super("Tree");
		JPanel p = new JPanel();
		root = new DefaultMutableTreeNode("java");
		p.setLayout(new BorderLayout());
		tree = new JTree(root);
		ht.put("Java","d");
		p.add(tree,BorderLayout.CENTER);
		parentFrame.add(p);
		scroll = new JScrollPane(tree);
		p.add(scroll);
		tree.addTreeSelectionListener(this);
	}
	public static void	addNodes(String add) {
		String f = ht.get(add).toString();
	   	if(f.equals("f")) {
			DefaultMutableTreeNode child = new DefaultMutableTreeNode(add);
			node.add(child);
		}
		else {
			DefaultMutableTreeNode child = new DefaultMutableTreeNode(add);
			node.add(child);
		}
	}
	public void	valueChanged(TreeSelectionEvent e) {
		
			String path = e.getPath().toString(); 
			node= (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
			int comma = path.lastIndexOf(",");
			if(comma>0) req = path.substring(comma+2,(path.length())-1);
			String a  = path.substring(1,path.length()-1);
			path = a.replace(',', '\\');
			path = path.replaceAll(" ","");
			path = path + "\\";
			if((ht.get(req).toString()).equals("d"))  DashBoard.sendMessageToServer(composeUFLR(path));
	}
	public String composeUFLR(String finalPath) {
		String UFLR ="UFLR";
		UFLR = UFLR + finalPath;
		/* if(req.equals("Java"))        UFLD(UFLDJava);
		if(req.equals("AWt"))         UFLD(UFLDAWt);
		if(req.equals("Swing"))       UFLD(UFLDSwing);
		if(req.equals("Programming")) UFLD(UFLDProgramming);
		if(req.equals("sub1"))        UFLD(UFLDsub1);
		if(req.equals("sub2"))        UFLD(UFLDsub2);  
		 */return UFLR;
	}
	public static void UFLD(String m) {
		m = m.substring(4);	
		while (m.length()>1) {
			int k = m.indexOf(":");
			if (k == -1)  break;
			String sb = m.substring(0,k);
			m = m.substring(k+1);
			int star     = sb.indexOf("*");
			String fType = sb.substring(0,star);
			String fName = sb.substring(star+1);
			ht.put(fName, fType);
			addNodes(fName);
		}
	} 
	public static void main(String s[]){
		JFrame f1 = new JFrame();
		f1.setLocation(500,200);
		f1.setVisible(true);
		f1.setSize(400,400);
		f1.setLayout(new BorderLayout());
		new TreePanel(f1);
	} 
}