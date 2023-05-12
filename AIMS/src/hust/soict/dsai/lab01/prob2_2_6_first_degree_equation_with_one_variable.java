package hust.soict.dsai.lab01;
import javax.swing.JOptionPane;
public class prob2_2_6_first_degree_equation_with_one_variable {
		public static void main(String [] args) {
		String strNum1; String strNum2;
		System.out.println("Enter a,b of the equation: ax+b=0");
		strNum1=JOptionPane.showInputDialog("Enter number a:");
		strNum2=JOptionPane.showInputDialog("Enter number b:");
		double num1 = Double.parseDouble(strNum1);
		double num2 = Double.parseDouble(strNum2);
		if (num1==0) {
			System.out.println("the equation ax+b=0 has no root");
		}else {
			System.out.println("the root of the quation is "+ (-num2/num1));
		}

	}
}