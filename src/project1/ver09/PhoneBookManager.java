 package project1.ver09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.driver.OracleSQLException;


public class PhoneBookManager
{
	public Connection connect;
	public Statement sta;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	public void oracleSave()
	{
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			
			connect = DriverManager.getConnection(
					"jdbc:oracle:thin://@localhost:1521:xe", "kosmo", "1234");
			
			if(connect!=null)
			{
				System.out.println("오라클연결성공");
			}
			else
			{
				System.out.println("오라클연결실패");
			}
		}
		catch(Exception e)
		{
			System.out.println("예외발생");
			e.printStackTrace();
		}
	}
	
	public PhoneBookManager()
	{
		oracleSave();
	}
	
	
	public static void printMenu() 
	{
		System.out.println("♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠");
		System.out.println("♠ ######## 메뉴를 입력하세요 ######## ♠");
		System.out.print("♠ 1. 데이터 입력 ");
		System.out.println("  2. 데이터 검색     ♠");
		System.out.print("♠ 3. 데이터 삭제 ");
		System.out.println("  4. 프로그램 종료   ♠");
		System.out.println("♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠");
		System.out.print("선택하시오  :  ");
	}
	
	
	public void dataInput()
	{
		try
		{
			String st = " INSERT INTO phonebook_tb VALUES "
					+ " (?,?,?) ";
			psmt = connect.prepareStatement(st);
		
			Scanner sc = new Scanner(System.in);
			System.out.println("===데이터 입력하세요===");
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("전화번호 : ");
			String phonenum = sc.nextLine();
			System.out.print("생년월일 : ");
			String birth = sc.nextLine();
			
			psmt.setString(1, name);
			psmt.setString(2, phonenum);
			psmt.setString(3, birth);
			int num = psmt.executeUpdate();
			System.out.println(num +"행이 입력되었습니다.");
		}
		//낫널 설정했을때 뜨는오류
		catch(SQLIntegrityConstraintViolationException e)
		{
			System.out.println("동일한 데이터입력");
		}
		catch (Exception e)
		{
			System.out.println("오류발생");
			e.printStackTrace();
		}
		
	}
	public void dataSearch()
	{
		try 
		{
			System.out.print("입력하세요");
			Scanner sc = new Scanner(System.in);
			String searchName = sc.nextLine();
			String st = " SELECT * FROM phonebook_tb "
					+ " WHERE name LIKE '%" + searchName + "%' ";
			
			System.out.println("데이터 검색을 시작합니다..");
			sta=connect.createStatement();
			rs = sta.executeQuery(st);
			System.out.println("이름    전화번호      생년월일");
			while(rs.next())
			{
				String name = rs.getString(1);
				String phonenum = rs.getString(2);
				String birth = rs.getString(3);
				System.out.printf("%s  %s   %s", name, phonenum, birth);
				System.out.println();
			}
			System.out.println("검색완료");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void dataDelete() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요 :");
		String deleteName = sc.nextLine();
		try
		{
			String st = " DELETE FROM phonebook_tb "
					+ " WHERE name = ? ";
			psmt = connect.prepareStatement(st);
			
//			sta = connect.createStatement();
			psmt.setString(1, deleteName);
			int num = psmt.executeUpdate();
			System.out.println(num +"행이 삭제됨");
		}	
		catch(SQLException e)
		{
			System.out.println("쿼리실행 오류");
			e.printStackTrace();
		}
	}
	public void end()
	{
		try 
		{
			if(sta!=null)
			{
				sta.close();
			}
			if(connect!=null)
			{
				connect.close();
			}
			if(psmt!=null)
			{
				psmt.close();
			}
			if(rs!=null)
			{
				rs.close();
			}
			System.out.println("자원반납 성공");
		}
		catch(SQLException e)
		{
			System.out.println("오류발생");
		}
		System.out.println("프로그램을 종료합니다.");
	}
}
