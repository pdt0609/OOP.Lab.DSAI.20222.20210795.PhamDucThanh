package Lab01;

import javax.swing.JOptionPane;

public class prob6_3 {
	public static void main(String [] args) {
		String strNum;
		strNum=JOptionPane.showInputDialog("Enter the number of the height of a triangle:");
		double num = Double.parseDouble(strNum);
		
		
		double rows = num, k = 0;

	    for (int i = 1; i <= rows; ++i, k = 0) {
	      for (int space = 1; space <= rows - i; ++space) {
	        System.out.print("  ");
	      }

	      while (k != 2 * i - 1) {
	        System.out.print("* ");
	        ++k;
	      }

	      System.out.println();
	    }
	  }
}