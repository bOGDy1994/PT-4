package src.logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import src.model.Account;
import src.model.Person;

public class Bank implements BankProc,Serializable {
	private HashMap<Person, List<Account>> AccountList;
	private double interest = 0.25;
	private double taxes = 30.00;
	private String errorMessage;
		
	public Bank()
	{
		AccountList = new HashMap<Person, List<Account>>();
	}
	
	public String getError()
	{ 
		return errorMessage;
	}
		
		
	/**
	 *  
	 * @pre p.getAge()>=18 
	 * @pre !p.getName().equals("") 
	 * @pre p.getPhonenumber().length == 10 
	 * @pre p.getEmail().equals(*@*.*)
	 * @pre !a.getName().equals("")
	 * @pre  Entry<p, a> entry == NULL
	 * @invariant isWellFormed()
	 * @post Entry<p, a> Entry !=NULL
	 */
	@Override
	public void addAccount(Person p, Account a) 
	{
		try{
			assert(p.getAge()>=18);	
		}
		catch(AssertionError e)
		{
			errorMessage = "You must be 18 years old to have a bank account!";
			return;
		}
		try{
		assert(!p.getName().equals(""));
		}
		catch(AssertionError e)
		{
			errorMessage = "You must input a name!";
			return;
		}
		try{
			String expression = "\\d{10}";
			Pattern pattern = Pattern.compile(expression);
			Matcher matcher = pattern.matcher(p.getPhonenumber());
		assert(matcher.matches());
		}
		catch(AssertionError e)
		{
			errorMessage = "You must input a valid phonenumber!";
			return;
		}
		try{
		String expression = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(p.getEmail());
		assert(matcher.matches());
		}
		catch (AssertionError e)
		{
			errorMessage = "You must input a valid email!";
			return;
		}
		try
		{
		assert(!a.getName().equals(""));
		}
		catch(AssertionError e)
		{
			errorMessage = "You must input an account name!";
			return;
		}
		List<Account> temp = AccountList.get(p);
		try{
			assert(temp!=null);	
		}
		catch(AssertionError e)
		{
			errorMessage = "You must first add the person and account.";
			return;
		}
		isWellFormed();
		if(errorMessage!=null)
			return;
		temp.add(a);
		AccountList.put(p, temp);
		isWellFormed();
		if(errorMessage!=null)
			return;
		errorMessage = null;
	}

	/**
	 *  
	 * @pre p.getAge()>=18 
	 * @pre !p.getName().equals("") 
	 * @pre p.getPhonenumber().length == 10 
	 * @pre p.getEmail().equals(*@*.*)
	 * @pre HashMap<p, a> HashMap !=NULL
	 * @invariant isWellFormed()
	 * @post HashMap<p, a> HashMap ==NULL
	 */
	@Override
	public void removeAccount(Person p, Account a) 
	{
		try{
			assert(p.getAge()>=18);	
		}
		catch(AssertionError e)
		{
			errorMessage = "You must be 18 years old to have a bank account!";
			return;
		}
		try{
		assert(!p.getName().equals(""));
		}
		catch(AssertionError e)
		{
			errorMessage = "You must input a name!";
			return;
		}
		try{
			String expression = "\\d{10}";
			Pattern pattern = Pattern.compile(expression);
			Matcher matcher = pattern.matcher(p.getPhonenumber());
		assert(matcher.matches());
		}
		catch(AssertionError e)
		{
			errorMessage = "You must input a valid phonenumber!";
			return;
		}
		try{
		String expression = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(p.getEmail());
		assert(matcher.matches());
		}
		catch (AssertionError e)
		{
			errorMessage = "You must input a valid email!";
			return;
		}
		try
		{
		assert(!a.getName().equals(""));
		}
		catch(AssertionError e)
		{
			errorMessage = "You must input an account name!";
			return;
		}
		List<Account> l = AccountList.get(p);
		try{
			assert(l!=null);
			isWellFormed();
			if(errorMessage!=null)
				return;
			int index = l.indexOf(a);
			l.remove(index);
			AccountList.put(p, l);
			isWellFormed();
			if(errorMessage!=null)
			{
				l = AccountList.get(p);
				l.add(a);
				AccountList.put(p, l);
				return;
			}
		}
		catch(AssertionError e)
		{
			errorMessage = "The account doesn't exits!";
			return;
		}
		errorMessage = null;
	}
	
	/**
	 *  
	 * @pre p.getAge()>=18 
	 * @pre !p.getName().equals("") 
	 * @pre p.getPhonenumber().length == 10 
	 * @pre p.getEmail().equals(*@*.*)
	 * @pre HashMap<p, a> HashMap == NULL
	 * @invariant isWellFormed()
	 * @post HashMap<Person, Account> HashMap !=NULL
	 */

	@Override
	public void addPerson(Person p, Account a) 
	{
		try{
			assert(p.getAge()>=18);	
		}
		catch(AssertionError e)
		{
			errorMessage = "You must be 18 years old to have a bank account!";
			return;
		}
		try{
		assert(!p.getName().equals(""));
		}
		catch(AssertionError e)
		{
			errorMessage = "You must input a name!";
			return;
		}
		try{
			String expression = "\\d{10}";
			Pattern pattern = Pattern.compile(expression);
			Matcher matcher = pattern.matcher(p.getPhonenumber());
		assert(matcher.matches());
		}
		catch(AssertionError e)
		{
			errorMessage = "You must input a valid phonenumber!";
			return;
		}
		try{
		String expression = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(p.getEmail());
		assert(matcher.matches());
		}
		catch (AssertionError e)
		{
			errorMessage = "You must input a valid email!";
			return;
		}
		try
		{
		assert(!a.getName().equals(""));
		}
		catch(AssertionError e)
		{
			errorMessage = "You must input an account name!";
			return;
		}
		List<Account> temp = AccountList.get(p);
		try{
			assert(temp==null);	
		}
		catch(AssertionError e)
		{
			errorMessage = "The person you are trying to add exists. Please add an account.";
			return;
		}
		isWellFormed();
		if(errorMessage!=null)
			return;
		temp = new ArrayList<Account>();
		temp.add(a);
		AccountList.put(p, temp);
		isWellFormed();
		if(errorMessage!=null)
			return;
		errorMessage = null;
	}

	/**
	 *  
	 * @pre p.getAge()>=18 
	 * @pre !p.getName().equals("") 
	 * @pre p.getPhonenumber().length == 10 
	 * @pre p.getEmail().equals(*@*.*)
	 * @pre HashMap<p, a> HashMap !=NULL
	 * @invariant isWellFormed()
	 * @post foreach Entry<p, a> entry in HashMap
	 * 			entry == NULL
	 */
	@Override
	public void removePerson(Person p) 
	{
		try{
			assert(p.getAge()>=18);	
		}
		catch(AssertionError e)
		{
			errorMessage = "You must be 18 years old to have a bank account!";
			return;
		}
		try{
		assert(!p.getName().equals(""));
		}
		catch(AssertionError e)
		{
			errorMessage = "You must input a name!";
			return;
		}
		try{
			String expression = "\\d{10}";
			Pattern pattern = Pattern.compile(expression);
			Matcher matcher = pattern.matcher(p.getPhonenumber());
		assert(matcher.matches());
		}
		catch(AssertionError e)
		{
			errorMessage = "You must input a valid phonenumber!";
			return;
		}
		try{
		String expression = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(p.getEmail());
		assert(matcher.matches());
		}
		catch (AssertionError e)
		{
			errorMessage = "You must input a valid email!";
			return;
		}
		isWellFormed();
		if(errorMessage!=null)
			return;
		AccountList.remove(p);
		isWellFormed();
		if(errorMessage!=null)
			return;
		errorMessage = null;
	}
	
	/**
	 * 
	 * @pre NULL
	 * @post HashMap<Person,Account>
	 */
	public HashMap<Person,List<Account>> getAccounts()
	{
		errorMessage = null;
		return AccountList;
	}
	
	/**
	 * 
	 * @pre nothing
	 * @invariant foreach Entry<Person, Account> entry in HashMap<Person,Account>
	 * 				Account a = entry.getValue();
	 * 				a!=NULL;
	 * 				
	 * @post nothing
	 */
	private void isWellFormed()
	{
		for(Entry<Person,List<Account>> entry : AccountList.entrySet())
		{
			List<Account> a = entry.getValue();
			try{
			assert(a.size()!=0);
			}
			catch(AssertionError e)
			{
				errorMessage = "Inconsistency in the data. Nothing's changed.";
				return;
			}
		}
		errorMessage = null;
	}
	
	public void update()
	{
		for(Entry<Person,List<Account>> entry : AccountList.entrySet())
		{
			List<Account> showL = entry.getValue();
			for(Account it : showL)
				it.update(interest, taxes);
		}
		errorMessage = null;
	}

}
