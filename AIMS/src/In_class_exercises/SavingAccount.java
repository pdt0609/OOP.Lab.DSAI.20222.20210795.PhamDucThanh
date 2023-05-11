package In_class_exercises;

public class SavingAccount extends BankAccount {
	public SavingAccount(String name, double balance, double accountnumber) {
		super(name, balance, accountnumber);
		// TODO Auto-generated constructor stub
	}
	public void deposit(int depositamount) {
		super.deposit(depositamount);
	}
	public double mounthly=0;
	public void monthlyinterest(double anualinterest) {
		double a=getBalance();
		mounthly=a*anualinterest/12;
		System.out.println(mounthly);
	}
}
