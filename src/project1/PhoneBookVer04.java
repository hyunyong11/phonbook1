package project1;

import java.util.Scanner;

import project1.ver04.PhoneInfo;
import project1.ver04.PhoneBookManager;
	
public class PhoneBookVer04
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
			printMenu();
			
			int choice = scan.nextInt();
			switch(choice)
			{
			case 1:
				handler.dataInput(choice);
				break;
			case 2:
				handler.dataSearch();
				break;
			case 3:
				handler.dataDelete();
				break;
			case 4:
				handler.dataAllShow();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}
