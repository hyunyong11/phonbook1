 package project1.ver09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


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
			Class.forName("orcale.jdbc.OracleDriver");
			
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
		System.out.println("######## 메뉴를 입력하세요 ########");
		System.out.print("1. 데이터 입력 ");
		System.out.println("2. 데이터 검색 ");
		System.out.print("3. 데이터 삭제 ");
		System.out.println("4. 오라클연결 ");
		System.out.println("5. 프로그램 종료 ");
		
	}
	
	
	public void dataInput()
	{
		try
		{
			String st = " INSERT INTO phonebook_tb VALUES "
					+ " (seq_phonebook.nextval,?,?,?) ";
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
			Scanner sc = new Scanner(System.in);
			String searchName = sc.nextLine();
			String st = " SELECT * FROM phonebook_tb "
					+ " WHERE name LIKE '%" + searchName + "%' ";
			System.out.println("데이터 검색을 시작합니다..");
			sta=connect.createStatement();
			while(rs.next())
			{
				String name = rs.getString(1);
				String phonenum = rs.getString(2);
				String birth = rs.getString(3);
				System.out.printf("%s, %s, %s", name, phonenum, birth);
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
		try
		{
			String st = " DELETE FROM phonebook_tb "
					+ " WHERE name = ? ";
			psmt = connect.prepareStatement(st);
			Scanner sc = new Scanner(System.in);
			System.out.print("삭제할 이름을 입력하세요 :");
			String deleteName = sc.nextLine();
			
			sta = connect.createStatement();
			int num = psmt.executeUpdate(st);
			System.out.println(num +"행이 삭제됨");
		}	
		catch(SQLException e)
		{
			System.out.println("쿼리실행 오류");
		}
	}
	
}
