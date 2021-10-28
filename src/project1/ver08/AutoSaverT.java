package project1.ver08;

import java.io.FileWriter;
import java.io.PrintWriter;

public class AutoSaverT extends Thread
{
	PhoneBookManager pm;
		
	public AutoSaverT(PhoneBookManager pm)
	{
		this.pm = pm;
	}
	

	@Override
	public void run() 
	{
		try
		{
		
			PrintWriter out = new PrintWriter(new FileWriter("src/project1/ver08/AutoSaveBook.txt"));
			while(true)
			{
				for
				( Object PI : pm.obj)
				{
						out.println(PI);
						out.close();
				}
				sleep(3000);
				System.out.println("3초마다 자동저장!!");
			}
		}
		catch (Exception e)
		{
			
		}
	}
				
}


