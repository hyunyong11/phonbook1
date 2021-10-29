package project1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import project1.ver09.PhoneInfo;
import project1.ver09.PhoneBookManager;
	
public class PhoneBookVer09
{
	public static Connection connect;
	public static PreparedStatement psmt;
	public static ResultSet rs;
	public static Statement sta;
	
	public static void main(String[] args)
	{		
		Scanner scan = new Scanner(System.in);
	
		PhoneBookManager handler = new PhoneBookManager();	
		
		handler.oracleSave();
		
		while(true)
		{

			PhoneBookManager.printMenu();
			
			int choice = scan.nextInt();
			switch(choice)
			{
			case 1:
				handler.dataInput();
				break;
			case 2:
				handler.dataSearch();
				break;
			case 3:
				handler.dataDelete();
				break;
			case 4:
				handler.oracleSave();
				break;
			case 5:
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
				return;
			}
		}
	}
}
