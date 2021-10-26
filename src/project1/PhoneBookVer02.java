package project1;

import java.util.Scanner;

import project1.ver02.PhoneInfo;

public class PhoneBookVer02
{
	public static void main(String[] args)
	{		
		Scanner scan = new Scanner(System.in);
		String iName,iPhone,iBirth;
	
		while(true) 
		{
			System.out.println("######## 메뉴를 입력하세요 ########");
			System.out.print("1.데이터 입력 ");
			System.out.println("2.프로그램 종료");
				
			int choice = scan.nextInt();
			scan.nextLine();
			if(choice==1)
			{
				System.out.print("이름 : ");
				iName = scan.nextLine();
				System.out.print("전화번호 : ");
				iPhone = scan.nextLine();
				System.out.print("생년월일 : ");
				iBirth = scan.nextLine();
			}
			else if(choice==2)
			{
				System.out.println("프로그램 종료");
				break;
			}
		}
	}
}
