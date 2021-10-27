package project1.ver07;

public class MenuSelectException
{
	public void MenuEX()
	{
		int choice = 0;
		if(choice<1 || choice>5)
			System.out.println("1~5까지의 숫자만 입력하세요");
	}
}
