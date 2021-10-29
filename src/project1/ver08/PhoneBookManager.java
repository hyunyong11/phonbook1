 package project1.ver08;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class PhoneBookManager implements MenuItem, SubMenuItem 
{
	
	 HashSet<Object> obj = new HashSet<Object>(100);
	
	 Scanner sc = new Scanner(System.in);
	 File data = 
				new File("src/project1/ver08/PhoneBook.obj");
	
	public static void printMenu() 
	{
		System.out.println("♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠");
		System.out.println("♠######## 메뉴를 입력하세요 ########♠");
		System.out.print("♠ 1. 데이터 입력 ");
		System.out.println("  2. 데이터 검색   ♠");
		System.out.print("♠ 3. 데이터 삭제 ");
		System.out.println("  4. 주소록 출력   ♠");
		System.out.print("♠ 5. 저장옵션 " );
		System.out.println("     6. 프로그램 종료 ♠ " );
		System.out.println("♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠");
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
			
			if(num==SubMenuItem.NOMAL)
			{
				System.out.print("이름:");
				String name = sc.nextLine();
				System.out.print("전화번호:");
				String phone = sc.nextLine();
				obj2=new PhoneInfo(name,phone);
			}
			
			else if(num==SubMenuItem.SCFRI)
			{
				System.out.print("이름:");
				String name = sc.nextLine();
				System.out.print("전화번호:");
				String phone = sc.nextLine();
				System.out.print("전공 : ");
				String major = sc.nextLine();
				System.out.print("학년 : ");
				int scNum = sc.nextInt();
				
				PhoneSchoolInfo obj3 = new PhoneSchoolInfo(name, phone, major, scNum);
				obj2=obj3;
			}
			
			else if(num==SubMenuItem.COFRI)
			{
				System.out.print("이름:");
				String name = sc.nextLine();
				System.out.print("전화번호:");
				String phone = sc.nextLine();
				System.out.print("회사명 : ");
				String comp = sc.nextLine();
				PhoneCompanyInfo obj3 = new PhoneCompanyInfo(name, phone, comp);
				obj2=obj3;
			}
			else
			{
				System.out.println("1~3까지 입력해라");
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
		System.out.print("이름을 입력하세요 : ");
		String searchName = sc.nextLine();
		
		try
		{
			Iterator itr = obj.iterator();
			
			while(itr.hasNext())
			{
				PhoneInfo PI = (PhoneInfo)itr.next();
				
				if(PI.name.equals(searchName))
				{
					isFind = true;
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
			if(isFind==false)
			{
				System.out.println("그런사람읎다고 새퀴야");
			}
		}	
		catch(NullPointerException e)
		{
		}
	}
	
	public void dataDelete() 
	{
		boolean isFind = false;
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = sc.nextLine();
		
		
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
					System.out.println("삭제성공");
				}
			}
			if(isFind==false)
			{
				System.out.println("그런사람 읎다");
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
		boolean bl = true;
		Iterator itr = obj.iterator();
		while(itr.hasNext())
		{
			System.out.println("전체정보가 출력되었슴다");
			Object object = itr.next();
			if(object instanceof PhoneCompanyInfo)
				((PhoneCompanyInfo)object).showPhoneCompanyInfo();
			else if(object instanceof PhoneSchoolInfo)
				((PhoneSchoolInfo)object).showPhoneSchoolInfo();
			else
				((PhoneInfo)object).showPhoneInfo();
		}
		if(obj.isEmpty()==true)
		{
			System.out.println("정보가 없다");
		}
	}
	public void autoSave(AutoSaverT as) 
	{
		System.out.println("1번 : 자동저장 켜기   2번 : 자동저장 끄기");
		int save = sc.nextInt();
		
		if(save==1)
		{
			if(!as.isAlive())
			{
				System.out.println("자동저장 활성화");
				as.setDaemon(true);
				as.start();
			}
			else
			{
				System.out.println("이미 자동저장이 실행중입니다.");
			}
			
		}
		else if(save==2)
		{
			if(as.isAlive())
			{
				System.out.println("자동저장 비활성화");
				as.interrupt();
			}
		}
		else
		{
			System.out.println("메뉴를 잘못입력하셨습니다.");
		}
	}

	public void saveData()
	{
		try 
		{
			ObjectOutputStream out = 
					new ObjectOutputStream
					(new FileOutputStream(data));
			Iterator itr = obj.iterator();
			while(itr.hasNext())
			{
				Object object = itr.next();
				out.writeObject(object);
			}
		}
		catch(Exception e)
		{
			System.out.println("데이터 직렬화 오류");
		}
	}
	public void readData() 
	{
		boolean bl = true;
		try {
			ObjectInputStream in = 
					new ObjectInputStream
					(new FileInputStream(data));
					
			while(true) 
			{
				Object object = (PhoneInfo)in.readObject();
				obj.add(object);
				if(object == null)
				{
					break;
				}
			}
		}
		catch(EOFException e)
		{
			
		}
		catch(Exception e)
		{
			System.out.println("복원시 오류발생");
			e.printStackTrace();
			bl = false;
		}
		System.out.println("친구정보 복원완료");
	}

}
