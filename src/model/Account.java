package src.model;

import java.io.Serializable;

import org.joda.time.DateTime;

public abstract class Account implements Serializable {

	protected double money;
	protected int numberOfTransactions;//depends on the type of the account
	protected DateTime dateOfLastTransaction;//i need this to see if i may allow the user to retrieve money or not.
	protected double minSumMoney;//we have a minimum sum to retrieve. if the sum is lower than this, we will not give money to the user
	protected double maxSumMoney;//we have a maximum limit for the sum in both cases
	protected String errorMessage;
	protected String accountName;
	
	public Account(double inMoney, String nume)
	{
		if(inMoney > 0.000)
			money = inMoney;
		else money = 0.00;
		accountName = nume;
	}
	
	public String getError()
	{
		return errorMessage;
	}
	
	public double getMoney()
	{
		return money;
	}
	
	public String getName()
	{
		return accountName;
	}

	public abstract void update(double interest, double taxes);
	public abstract boolean retrieveMoney(double sum);
	public abstract void addMoney(double sum);
	
}
