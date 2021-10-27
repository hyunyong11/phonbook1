package project1;

import java.util.Scanner;

import project1.ver05.PhoneInfo;
import project1.ver05.MenuItem;
import project1.ver05.PhoneBookManager;

	
public class PhoneBookVer05 
{

	
	
	public static void main(String[] args) 
	{		
		Scanner scan = new Scanner(System.in);
	
		PhoneBookManager handler = new PhoneBookManager(100);	
		
		while(true)
		{

			PhoneBookManager.printMenu();
			
			int choice = scan.nextInt();
			switch(choice)
			{
			case MenuItem.DATAINPUT1:
				handler.dataInput(choice);
				break;
			case MenuItem.DATASEARCH1:
				handler.dataSearch();
				break;
			case MenuItem.DATADELETE1:
				handler.dataDelete();
				break;
			case MenuItem.DATAALLSHOW1:
				handler.dataAllShow();
				break;
			case MenuItem.END:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}
