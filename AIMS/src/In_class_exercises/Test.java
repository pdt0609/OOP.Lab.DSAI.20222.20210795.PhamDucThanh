package In_class_exercises;


public class Test {
	 public static void main(String args[]) {
			BankAccount account=new BankAccount("thanh",100000,200000);
			
		    System.out.println("Has a balance of " + account.getBalance());
		    account.withdraw(1000);


		    System.out.println("Has a balance of " + account.getBalance());
		    SavingAccount account1=new SavingAccount("thanh",100000,200000);
		    account1.monthlyinterest(1.1);
		    
	 }}