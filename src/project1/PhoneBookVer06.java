package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver06.PhoneInfo;
import project1.ver06.MenuItem;
import project1.ver06.PhoneBookManager;

	
public class PhoneBookVer06 
{

	public static void printMenu() 
	{
		System.out.println("######## 메뉴를 입력하세요 ########");
		System.out.print("1. 데이터 입력 ");
		System.out.println("2. 데이터 검색 ");
		System.out.print("3. 데이터 삭제 ");
		System.out.println("4. 주소록 출력 ");
		System.out.print("5. 프로그램 종료 " );
	}
	
	public static void main(String[] args) 
	{		
		Scanner scan = new Scanner(System.in);
	
		PhoneBookManager handler = new PhoneBookManager(100);	
		
		while(true)
		{
			try 
			{
				printMenu();
			
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
				default :
					System.out.println("1~5번중에 선택하세요");
					break;
				}
			}
			catch (InputMismatchException e)
			{
				scan = new Scanner(System.in);
				System.out.println("숫자1~5까지만 입력가능합니다 문자적지마세요");
				
				e.printStackTrace();
				
			}
		}
	}
}
