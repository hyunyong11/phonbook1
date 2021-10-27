package project1.ver07;

public class PhoneSchoolInfo extends PhoneInfo
{
	String major;
	int scNum;

	public PhoneSchoolInfo(String name, String phoneNumber, String major, int scNum)
	{
		super(name, phoneNumber);
		this.major = major;
		this.scNum = scNum;
	}
	
	public void showPhoneSchoolInfo() 
	{
		System.out.println("이름:"+name);
		System.out.println("전화번호:"+phoneNumber);
		System.out.println("전공:"+ major);
		System.out.println("학년:"+ scNum);
	}
}
