 package project1.ver07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;




public class PhoneBookManager implements MenuItem, SubMenuItem
{
	
	HashSet<Object> obj = new HashSet<Object>(100);

	
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
		System.out.println("1번 : 일반   2번 : 학교   3번 : 회사");
		int num = sc.nextInt();
		sc.nextLine();
		
		PhoneInfo obj2;
		
		try 
		{
			System.out.print("이름:");
			String name = sc.nextLine();
			System.out.print("전화번호:");
			String phone = sc.nextLine();
			
			if(num==SubMenuItem.NOMAL)
			{
				obj2=new PhoneInfo(name,phone);
			}
			
			else if(num==SubMenuItem.SCFRI)
			{
				System.out.print("전공 : ");
				String major = sc.nextLine();
				System.out.print("학년 : ");
				int scNum = sc.nextInt();
				
				PhoneSchoolInfo obj3 = new PhoneSchoolInfo(name, phone, major, scNum);
				obj2=obj3;
			}
			
			else if(num==SubMenuItem.COFRI)
			{
				System.out.print("회사명 : ");
				String comp = sc.nextLine();
				PhoneCompanyInfo obj3 = new PhoneCompanyInfo(name, phone, comp);
				obj2=obj3;
			}
			else
			{
				throw new NullPointerException();
			}
			
			
			if(obj.add(obj2)==false)
			{
				System.out.println("이름 똑같잖아요");
				System.out.println("덮어쓸까? Y(y)/N(n)");
				
				String rename = sc.nextLine();
				
				if(rename.equals("Y")||rename.equals("y"))
				{
					if(obj.contains(obj2))
					{
						obj.remove(obj2);
						obj.add(obj2);
						System.out.println("덮어쓰기성공");
					}
					else
					{
						System.out.println("덮어쓰기실패");
					}
				}
				else if(rename.equals("N")||rename.equals("n"))
				{
					System.out.println("덮어쓰기 취소.");
				}
				else
				{
					System.out.println("잘못입력");
				}
			}
		}
		catch(NullPointerException e) {}
	}
	
	public void dataSearch()
	{
		boolean isFind = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("데이터 검색을 시작합니다..");
		String searchName = sc.nextLine();
		
		System.out.print("이름 : ");
		try
		{
			Iterator itr = obj.iterator();
			
			while(itr.hasNext())
			{
				PhoneInfo PI = (PhoneInfo)itr.next();
				
				if(PI.name.equals(searchName))
				{
					isFind =true;
					if(PI instanceof PhoneCompanyInfo)
					{
						((PhoneCompanyInfo)PI).showPhoneCompanyInfo();
					}
					else if(PI instanceof PhoneSchoolInfo)
					{
						((PhoneSchoolInfo)PI).showPhoneSchoolInfo();
					}
					else
					{
						((PhoneInfo)PI).showPhoneInfo();
					}
				}
			}
		}	
		catch(NullPointerException e)
		{
			System.out.println("==이름 잘못입력하셨슴다==");
		}
	}
	
	public void dataDelete() 
	{
		boolean isFind = false;
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = sc.nextLine();
		
		System.out.println("삭제되었습니다.");
		
		try
		{	
			Iterator itr = obj.iterator();
			while(itr.hasNext())
			{
				PhoneInfo PI = (PhoneInfo)itr.next();
				
				if(PI.name.equals(deleteName))
				{
					isFind=true;
					itr.remove();
				}
			}
			if(isFind=false)
			{
				throw new NullPointerException();
			}
		}
		catch (NullPointerException e) 
		{
			System.out.println("결과 없다");
		}
	}
	
	public void dataAllShow()
	{
		Iterator itr = obj.iterator();
		while(itr.hasNext())
		{
			Object object = itr.next();
			if(object instanceof PhoneCompanyInfo)
				((PhoneCompanyInfo)object).showPhoneCompanyInfo();
			else if(object instanceof PhoneSchoolInfo)
				((PhoneSchoolInfo)object).showPhoneSchoolInfo();
			else
				((PhoneInfo)object).showPhoneInfo();
		}
	}
}
