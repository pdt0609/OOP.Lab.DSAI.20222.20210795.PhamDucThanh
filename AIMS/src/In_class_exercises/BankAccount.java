package In_class_exercises;

public class BankAccount {

	 public String name; 
	 public double balance;
	 private double accountnumber;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(double accountnumber) {
		this.accountnumber = accountnumber;
	}

	public BankAccount(String name, double balance, double accountnumber) {
		super();
		this.name=name;
		this.balance=balance;
		this.accountnumber=accountnumber;
	}
	public void deposit(double depositAmount)
	  {
	    balance += depositAmount;
	  }

	  public boolean withdraw(double withdrawAmount)
	  {
	    if (withdrawAmount > (balance-55000)){    
	      System.out.println("Insufficient !");
	      return false;
	    } else {
	      balance -= (withdrawAmount+5000);
	      return true;
	    }
	  }
	}
