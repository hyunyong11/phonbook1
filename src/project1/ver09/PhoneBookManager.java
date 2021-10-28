 package project1.ver09;

import java.util.Scanner;

public class PhoneBookManager
{
	public PhoneInfo[] account;
	public int numOfAccount; 
	
	public PhoneBookManager(int num)
	{
		account = new PhoneInfo[num];
		
		numOfAccount = 0;
	}
	
	public static void printMenu() 
	{
		System.out.println("######## 메뉴를 입력하세요 ########");
		System.out.print("1. 데이터 입력 ");
		System.out.println("2. 데이터 검색 ");
		System.out.print("3. 데이터 삭제 ");
		System.out.println("4. 주소록 출력 ");
		System.out.print("5. 프로그램 종료 " );
	}
	
	
	public void dataInput()
	{
		Scanner sc = new Scanner(System.in);
		String iName, iPhone, iBirth;
		
		System.out.println("===데이터 입력하세요===");
		System.out.print("이름 : ");
		iName = sc.nextLine();
		System.out.print("전화번호 : ");
		iPhone = sc.nextLine();
		System.out.print("생년월일 : ");
		iBirth = sc.nextLine();
		
		account[numOfAccount++] = new PhoneInfo(iName, iPhone, iBirth);
	}
	
	public void dataSearch()
	{
		boolean isFind = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("데이터 검색을 시작합니다..");
		String searchName = sc.nextLine();
		
		for(int i=0 ; i<numOfAccount ; i++) {
			
			if(searchName.compareTo(account[i].name)==0)
			{
				account[i].showPhoneInfo();
				System.out.println("데이터 검색을 완료했습니다..");
				isFind = true;
			}
		}	
		if(isFind ==false)
			System.out.println("==이름 잘못입력하셨슴다==");
	}
	
	public void dataDelete() {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = sc.nextLine();
		
		int deleteIndex = -1; 
		
		for(int i=0 ; i<numOfAccount ; i++) 
		{
			if(deleteName.compareTo(account[i].name)==0)
			{
				account[i] = null;
				deleteIndex = i;
				numOfAccount--;
				break;
			}
		}

		if(deleteIndex==-1) 
		{
			System.out.println("==삭제된 데이터가 없습니다==");
		}
		else 
		{
			for(int i=deleteIndex ; i<numOfAccount ; i++) 
			{
				
			}
			System.out.println("==데이터("+ deleteIndex
					+"번)가 삭제되었습니다==");
		}
	}
	
	public void dataAllShow()
	{
		for(int i=0 ; i<numOfAccount ; i++) 
		{
			account[i].showPhoneInfo();
		}
	}
}
