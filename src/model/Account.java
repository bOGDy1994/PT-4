package src.model;

import org.joda.time.DateTime;

public abstract class Account {

	protected double money;
	protected int numberOfTransactions;//depends on the type of the account
	protected DateTime dateOfLastTransaction;//i need this to see if i may allow the user to retrieve money or not.
	protected double minSumMoney;//we have a minimum sum to retrieve. if the sum is lower than this, we will not give money to the user
	protected double maxSumMoney;//we have a maximum limit for the sum in both cases
	protected String errorMessage;
	
	public Account(double inMoney)
	{
		money = inMoney;
	}
	
	public String getError()
	{
		return errorMessage;
	}

	public abstract void update(double interest, double taxes);
	public abstract boolean retrieveMoney(double sum);
	public abstract void addMoney(double sum);
	
}
