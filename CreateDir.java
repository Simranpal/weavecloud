import java.io.*;
class CreateDir {
	public static void createRepository(String uname) {
		String path = "C:/Users/Navi/Desktop/experiments/"; 
		if(new File(path+uname).mkdir())
		{	
			System.out.println("Directory created");
			new File(path+uname+"/Public").mkdir();
			new File(path+uname+"/Private").mkdir();
		}
	}
	public static void main(String args[])	{
		 CreateDir.createRepository("ABC");
	}
}