package project1.ver08;

import java.io.IOException;

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
		
			while(true)
			{
				pm.saveInfoTxt();
				sleep(3000);
				System.out.println("3초마다 자동저장!!");
			}
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
				
}


