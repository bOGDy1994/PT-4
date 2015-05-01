package model;

public abstract class Account {

	private double money;
	
	public Account(double inMoney)
	{
		money = inMoney;
	}
	
	public abstract double retrieveMoney(double sum);
	public abstract void addMoney(double sum);
	
}
