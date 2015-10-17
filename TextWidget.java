/*
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
//Description:    TextWidget.java class is a widget 
//Creation Date:  August 10, 2011
//Authors :       Simranpal Singh


import java.awt.*;

class  TextWidget extends Frame {
	String text = "WEAVE-CLOUD";
	TextWidget() {
	super("Weave-Cloud");
		setVisible(true);
		setSize(640,480);
		setLocation(500,400);
	}
	
	public void drawText(Graphics g) {
	g.setFont(new Font("Courier New",Font.BOLD,46));
	for(int i =0;i<text.length();i++) {
		g.setColor(Color.lightGray);
		g.drawString(text,170,250);
		String ch = ""+text.charAt(i); 
		g.setColor(Color.black);
		g.drawString(ch,170+i*28,250);
		try
		{
			Thread.sleep(200);
		}
		catch (Exception e){}
		}
	}
	public void paint(Graphics g) {
	drawText(g);
	repaint();
	}

	public static void main(String[] args) {
		new TextWidget();
	}
}