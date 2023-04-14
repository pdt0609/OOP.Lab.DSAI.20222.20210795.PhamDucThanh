package Lab01;

import javax.swing.JOptionPane;

public class prob2_2_6_second_degree_equation_one_variable {
	public static void main(String [] args) {
			String stra; String strb; String strc;
			System.out.println("Enter a,b,c of the equation: ax^2+bx+c=0");
			stra=JOptionPane.showInputDialog("Enter number a:");
			strb=JOptionPane.showInputDialog("Enter number b:");
			strc=JOptionPane.showInputDialog("Enter number c:");
			double a = Double.parseDouble(stra);
			double b = Double.parseDouble(strb);
			double c = Double.parseDouble(strc);
			double denta= Math.pow(b, 2)-4*a*c;
			if (a==0) {
				if (b==0) {
					System.out.println("the equation has no root");
				}else {
					System.out.println("the only root of the equation is "+ (-c/b));
				}
			}else {if(denta==0) {
				System.out.println("the equation has 1 double roots:"+ (-b/2/a));
			}else if( denta>0) {
				System.out.println("the equation has 2 roots x1, x2 \nthe root x1 is:"+ ((-b+Math.sqrt(denta))/(2*a)));
				System.out.println("the roots x2 is:"+ ((-b-Math.sqrt(denta))/(2*a)));
			}else {
				System.out.println("the equation has no real root");
			}
				
			}

	}
}
