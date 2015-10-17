import java.awt.*;
class GetResolution 
{
	int x,y;
	GetResolution()
	{
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		String pr = dim.toString();
		String str = pr.substring(25);
		x = Integer.parseInt(str.substring(0,str.indexOf(',')));
		y = Integer.parseInt(str.substring(str.indexOf('=')+1,str.length()-1));
		System.out.println("Resolution of Screen is: "+x+"x"+y);
	}
}
