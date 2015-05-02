package src.logic;

import src.model.Account;
import src.model.Person;
import src.model.Types;

public interface BankProc {

	/**
	 * 
	 * @pre p.getID()>=0 
	 * @pre p.getAge()>=18 
	 * @pre !p.getName().equals("") 
	 * @pre p.getPhonenumber().length == 10 
	 * @pre p.getEmail().equals(*@*.*)
	 * @pre inMoney>0
	 * @pre t!=NULL
	 * @pre a.getName().equals("")!=NULL
	 * @pre  Entry<p, a> entry ==NULL
	 * @post Entry<p, a> entry !=NULL
	 */
	public void addAccount(Person p, Account a, double inMoney, Types.accountTypes t);
	/**
	 * 
	 * @pre p.getID()>=0 
	 * @pre p.getAge()>=18 
	 * @pre !p.getName().equals("") 
	 * @pre p.getPhonenumber().length == 10 
	 * @pre p.getEmail().equals(*@*.*)
	 * @pre a.getName().equals("")!=NULL
	 * @pre Entry<p, a> entry !=NULL
	 * @post Entry<p, a> entry ==NULL
	 */
	public void removeAccount(Person p, Account a);
	/**
	 * 
	 * @pre p.getID()>=0 
	 * @pre p.getAge()>=18 
	 * @pre !p.getName().equals("") 
	 * @pre p.getPhonenumber().length == 10 
	 * @pre p.getEmail().equals(*@*.*)
	 * @pre inMoney>0
	 * @pre a.getName().equals("")!=NULL
	 * @pre t!=NULL
	 * @pre Entry<p, a> entry == NULL
	 * @post Entry<Person, Account> entry !=NULL
	 */
	public void addPerson(Person p, Account a, double inMoney, Types.accountTypes t);
	/**
	 * 
	 * @pre p.getID()>=0 
	 * @pre p.getAge()>=18 
	 * @pre !p.getName().equals("") 
	 * @pre p.getPhonenumber().length == 10 
	 * @pre p.getEmail().equals(*@*.*)
	 * @pre Entry<p, a> entry !=NULL
	 * @post foreach Entry<p, a> entry in Entry
	 * 			entry == NULL
	 */
	public void removePerson(Person p);
}
