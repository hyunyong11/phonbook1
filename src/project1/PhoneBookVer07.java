package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver07.PhoneInfo;
import project1.ver07.MenuItem;
import project1.ver07.PhoneBookManager;

	
public class PhoneBookVer07 
{

	
	
	public static void main(String[] args) 
	{		
		Scanner scan = new Scanner(System.in);
	
		PhoneBookManager handler = new PhoneBookManager();	
		
		while(true)
		{
			try 
			{
				PhoneBookManager.printMenu();
				
				int choice = scan.nextInt();
				switch(choice)
				{
				case MenuItem.DATAINPUT1:
					handler.dataInput();
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
				default :
					System.out.println("1~5번중에 선택하세요");
					break;
				}
			}
			catch (InputMismatchException e)
			{
				scan = new Scanner(System.in);
				System.out.println("숫자1~5까지만 입력가능합니다 문자적지마세요");
				
			}
		}
	}
}
