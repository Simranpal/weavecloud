import javax.swing.*;
import javax.swing.tree.*;

public class CloudPanel{
	public static JPanel addPane() {
		JPanel pane = new JPanel();
		pane.setSize(550,250);
		pane.setLayout(null);

		DefaultMutableTreeNode parent = new DefaultMutableTreeNode("Color", true);
		DefaultMutableTreeNode black = new DefaultMutableTreeNode("Black");
		DefaultMutableTreeNode blue = new DefaultMutableTreeNode("Blue");
		DefaultMutableTreeNode nBlue = new DefaultMutableTreeNode("Navy Blue");
		DefaultMutableTreeNode dBlue = new DefaultMutableTreeNode("Dark Blue");
		DefaultMutableTreeNode green = new DefaultMutableTreeNode("Green");
		DefaultMutableTreeNode white = new DefaultMutableTreeNode("White");
		parent.add(black);
		parent.add(blue);
		blue.add(nBlue);
		blue.add(dBlue);
		parent.add(green );
		parent.add(white);
		JTree tree = new JTree(parent);
		pane.add(tree);
		//pane.setUndecorated(true);
		pane.getRootPane().	setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		return pane;
  }
}

