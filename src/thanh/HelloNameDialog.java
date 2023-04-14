package thanh;

import javax.swing.JOptionPane;
public class HelloNameDialog{

	    public static void main(String[] args){

	        String name = JOptionPane.showInputDialog("Enter your name:");
	        System.out.println(name);
	        String age = (JOptionPane.showInputDialog("Enter your age:"));
	        float aging=Float.parseFloat(age);
	        System.out.println(aging);
	        String gender = JOptionPane.showInputDialog("Enter your gender:");
	        System.out.println(gender);
			String call;
			if (gender=="female") {
				
				if (aging < 30) {
					call="Miss";
				}else {
					call="Mrs";
			}} else {
				call="Mr";System.out.println("true");
			}

			JOptionPane.showMessageDialog(null,"Hello"+ call + name + age+"!");
			}
}