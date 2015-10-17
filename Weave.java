import java.awt.*;
class Weave extends Frame 
{
	int x = 163;
	int y = 115;
	int k = 0;
	int i = 0;
	int j =1;
	int w = 400,h =200;
	Weave() {
		super("Text");
		setSize(w,h);
		setLocation(400,200);
		setResizable(false);
		setVisible(true);
	}
	public void paint(Graphics g) {
		int cx =w/2;
		int cy =h/2;
		g.setColor(Color.BLUE);
		g.fillOval(cx,cy-50,20,20);
		g.fillOval(cx+45,cy-35,20,20);
		g.fillOval(cx+60,cy,20,20);
		g.fillOval(cx+40,cy+35,20,20);
		g.fillOval(cx,cy+50,20,20);
		g.fillOval(cx-40,cy+35,20,20);
		g.fillOval(cx-60,cy,20,20);
		g.fillOval(cx-45,cy-35,20,20);
		String str[] = {"W","E","A","V","E","","C","L","O","U","D"};
		//g.setFont(new Font("Arial",Font.BOLD,9));
		for(i =0;i<str.length;i++) {
			g.drawString(str[i],x,y);
			if(i==0)
				x+=5;
			x+=8;	
			try
			{
				Thread.sleep(200);
			}
			catch (Exception e) {}
		}
		while(k==0)
		{
			for( j =1;j<=8;j++)
			{
			
				switch(j)
				{
					case 1:
						g.fillOval(cx-45,cy-35,20,20);
						g.setColor(Color.RED);
						g.fillOval(cx,cy-50,20,20);
						g.setColor(Color.BLUE);
						try
						{
							Thread.sleep(300);	
						}
						catch (Exception e)
						{
						}
						break;
					case 2:
						g.fillOval(cx,cy-50,20,20);
						g.setColor(Color.RED);
						g.fillOval(cx+45,cy-35,20,20);
						g.setColor(Color.BLUE);
						try
						{
							Thread.sleep(300);	
						}
						catch (Exception e)
						{
						}
						break;
				case 3:
					g.fillOval(cx+45,cy-35,20,20);
					g.setColor(Color.RED);
					g.fillOval(cx+60,cy,20,20);
					g.setColor(Color.BLUE);
					try
					{
						Thread.sleep(300);	
					}
					catch (Exception e)
					{
					}
					break;
				case 4:
						g.fillOval(cx+60,cy,20,20);
						g.setColor(Color.RED);
						g.fillOval(cx+40,cy+35,20,20);
						g.setColor(Color.BLUE);
						try
						{
							Thread.sleep(300);
						}
						catch (Exception e)
						{
						}
						break;
				case 5:
						g.fillOval(cx+40,cy+35,20,20);
						g.setColor(Color.RED);
						g.fillOval(cx,cy+50,20,20);
						g.setColor(Color.BLUE);
					try
						{
							Thread.sleep(300);
						}
						catch (Exception e)
						{
						}
						break;
				case 6:
						g.fillOval(cx,cy+50,20,20);
						g.setColor(Color.RED);
						g.fillOval(cx-40,cy+35,20,20);
						g.setColor(Color.BLUE);
					try
						{
							Thread.sleep(300);
						}
						catch (Exception e)
						{
						}
						break;
				case 7:
						g.fillOval(cx-40,cy+35,20,20);		
						g.setColor(Color.RED);
						g.fillOval(cx-60,cy,20,20);
						g.setColor(Color.BLUE);
					try
						{
							Thread.sleep(300);
						}
						catch (Exception e)
						{
						}
						break;
					case 8:
						g.fillOval(cx-60,cy,20,20);
						g.setColor(Color.RED);
						g.fillOval(cx-45,cy-35,20,20);
						g.setColor(Color.BLUE);
						
						try
						{
							Thread.sleep(300);
						}
						catch (Exception e)
						{
						}
						break;
				}	
				x = 163;
				for(int i =0;i<str.length;i++)
				{
					g.setColor(Color.RED);
					g.drawString(str[i],x,y);
					try
				{
					Thread.sleep(100);
				}
				catch (Exception e) {}
				g.setColor(Color.BLUE);
				g.drawString(str[i],x,y);
				if(i==0)
					x+=5;
				x+=8;
			}
			}
		}
	}
	public static void main(String[] args) 
	{
		new Weave();		
	}
}
