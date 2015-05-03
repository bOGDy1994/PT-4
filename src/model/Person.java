package src.model;

import java.io.Serializable;

public class Person implements Serializable {
	private int age;
	private String name;
	private String phonenumber;
	private String email;
	
	public Person(int inAge, String inName, String inPhonenumber, String inEmail)
	{
		age = inAge;
		name = inName;
		phonenumber = inPhonenumber;
		email = inEmail;
	}
	
	private int hash(String name)
	{
		int Sum = 0;
		for(int i = 0; i<name.length(); i++)
			Sum = Sum + name.charAt(i);
		return Sum;
	}
	
	@Override
	public int hashCode()
	{
		return 37 * age + 13 * hash(name);
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o == null) return false;
		if(!(o instanceof Person)) return false;
		if(hashCode() == o.hashCode())
		{
			Person comp = (Person)o;
			if(age!=comp.getAge()) return false;
			if(!name.equals(comp.getName())) return false;
			if(!phonenumber.equals(comp.getPhonenumber())) return false;
			if(!email.equals(comp.getEmail())) return false;
		}
		return true;
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
