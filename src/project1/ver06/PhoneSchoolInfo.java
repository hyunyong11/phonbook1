package project1.ver06;

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

}
