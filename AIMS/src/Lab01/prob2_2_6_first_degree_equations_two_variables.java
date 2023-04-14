package Lab01;
	import javax.swing.JOptionPane;
public class prob2_2_6_first_degree_equations_two_variables {
	public static void main(String [] args) {
		String stra11; String stra12; String stra21;String stra22; String strb1;String strb2;
		System.out.println("Enter a11,a12,a21,a22,b1,b2 of the equation: a11x1+a12x2=b1, a21x1+a22x2=b2");
		stra11=JOptionPane.showInputDialog("Enter number a11:");
		stra12=JOptionPane.showInputDialog("Enter number a12:");
		stra21=JOptionPane.showInputDialog("Enter number a21:");
		stra22=JOptionPane.showInputDialog("Enter number a22:");
		strb1=JOptionPane.showInputDialog("Enter number b1:");
		strb2=JOptionPane.showInputDialog("Enter number b2:");

		double a11 = Double.parseDouble(stra11);
		double a12 = Double.parseDouble(stra12);
		double a21 = Double.parseDouble(stra21);
		double a22 = Double.parseDouble(stra22);
		double b1 = Double.parseDouble(strb1);
		double b2 = Double.parseDouble(strb2);
		double d=a11*b2-a21*b1;
		if (d!=0) {
			System.out.println("the system's x1 root is:"+(b1*a22-b2*a12)/d);
			System.out.println("the system's x2 root is:"+(a11*b2-b1*a21)/d);
		}else {
			if (a12*b2==a22*b1) {
				System.out.println("the system has infinite roots x1, x2");
			}else {
				System.out.println("the system has no roots x1, x2");
			}
		}

	}
}
