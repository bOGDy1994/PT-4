package src.model;

public class Person {
	private int id;
	private int age;
	private String name;
	private String phonenumber;
	private String email;
	
	public Person(int inID, int inAge, String inName, String inPhonenumber, String inEmail)
	{
		id = inID;
		age = inAge;
		name = inName;
		phonenumber = inPhonenumber;
		email = inEmail;
	}
	
	public int getID()
	{
		return id;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getPhonenumber()
	{
		return phonenumber;
	}
	
	public String getEmail()
	{
		return email;
	}
	
}
