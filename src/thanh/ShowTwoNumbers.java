package thanh;

import javax.swing.JOptionPane;

public class ShowTwoNumbers {
public static void main(String [] args) {
	String strNum1; String strNum2;
	strNum1=JOptionPane.showInputDialog("Enter the 1st number:");
	strNum2=JOptionPane.showInputDialog("Enter your name:");
	double num1 = Double.parseDouble(strNum1);
	double num2 = Double.parseDouble(strNum2);
	
	System.out.println("the sum of 2 numbers is "+(num1+num2));
	System.out.println("the product of 2 numbers is "+ num1*num2 );
	if (num2<num1) {
		double c=Math.floor(num1/num2);
		double d=num1%num2;
		System.out.println("the difference of 2 numbers is "+(num1-num2));
		System.out.println("the quotient of 2 numbers is "+c);
		System.out.println("the divisor of 2 number is "+d);
	}else {
		double c=Math.floor(num2/num1);
		double d=num2%num1;
		System.out.println("the difference of 2 numbers is "+(num2-num1));
		System.out.println("the quotient of 2 numbers is "+c);
		System.out.println("the divisor of 2 number is "+d);
	}
}
}
