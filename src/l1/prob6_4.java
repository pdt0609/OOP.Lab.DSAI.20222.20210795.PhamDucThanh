package Lab01;

import javax.swing.JOptionPane;

public class prob6_4 {
	public static void main(String [] args) {
		String mounth1; String strNum2;
		System.out.println("Enter the mounth and the year are");
		mounth1=JOptionPane.showInputDialog("Enter the mounth is:");
		strNum2=JOptionPane.showInputDialog("Enter the year is:");
		String mounth=mounth1;
		double year = Double.parseDouble(strNum2);
		String typeyear;
		if (year%4==0) {
			if (year%100!=0) {
				typeyear="leap";
				
			}else {
				if (year%400==0) {
					typeyear="leap";					
				}else {
				typeyear="not leap";
			}
		}
			}else {
			typeyear="not leap";
		}
		if (typeyear=="leap") {
			if (mounth.equals("January") || mounth.equals("1") || mounth.equals("Jan")||mounth.equals("Jan.")) {
				System.out.println(31);
			}else if(mounth.equals("February") || mounth.equals("2") || mounth.equals("Feb")||mounth.equals("Feb.")) {
				System.out.println(29);
			}else if(mounth.equals("March") || mounth.equals("3") || mounth.equals("Mar")||mounth.equals("Mar.")) {
				System.out.println(31);
			}else if(mounth.equals("April") || mounth.equals("4") || mounth.equals("Apr")||mounth.equals("Apr.")) {
				System.out.println(30);
			}else if(mounth.equals("May") || mounth.equals("5") || mounth.equals("May")||mounth.equals("May.")) {
				System.out.println(31);
			}else if(mounth.equals("June") || mounth.equals("6") || mounth.equals("Jun")||mounth.equals("Jun.")) {
				System.out.println(30);
			}else if(mounth.equals("July") ||mounth.equals("7") || mounth.equals("Jul")||mounth.equals("Jul.")) {
				System.out.println(31);
			}else if(mounth.equals("August") || mounth.equals("8") || mounth.equals("Aus")||mounth.equals("Aug.")) {
				System.out.println(31);
			}else if(mounth.equals("September") || mounth.equals("9") || mounth.equals("Sep")||mounth.equals("Sep.")) {
				System.out.println(30);
			}else if(mounth.equals("October") || mounth.equals("10") || mounth.equals("Oct")||mounth.equals("Oct.")) {
				System.out.println(31);
			}else if(mounth.equals("November") || mounth.equals("11") || mounth.equals("Nov")||mounth.equals("Nov.")) {
				System.out.println(30);
			}else {
				System.out.println(31);
			}
			
		}else{
			if (mounth.equals("January") || mounth.equals("1") || mounth.equals("Jan")||mounth.equals("Jan.")) {
				System.out.println(31);
			}else if(mounth.equals("February") || mounth.equals("2") || mounth.equals("Feb")||mounth.equals("Feb.")) {
				System.out.println(28);
			}else if(mounth.equals("March") || mounth.equals("3") || mounth.equals("Mar")||mounth.equals("Mar.")) {
				System.out.println(31);
			}else if(mounth.equals("April") || mounth.equals("4") || mounth.equals("Apr")||mounth.equals("Apr.")) {
				System.out.println(30);
			}else if(mounth.equals("May") || mounth.equals("5") || mounth.equals("May")||mounth.equals("May.")) {
				System.out.println(31);
			}else if(mounth.equals("June") || mounth.equals("6") || mounth.equals("Jun")||mounth.equals("Jun.")) {
				System.out.println(30);
			}else if(mounth.equals("July") ||mounth.equals("7") || mounth.equals("Jul")||mounth.equals("Jul.")) {
				System.out.println(31);
			}else if(mounth.equals("August") || mounth.equals("8") || mounth.equals("Aus")||mounth.equals("Aug.")) {
				System.out.println(31);
			}else if(mounth.equals("September") || mounth.equals("9") || mounth.equals("Sep")||mounth.equals("Sep.")) {
				System.out.println(30);
			}else if(mounth.equals("October") || mounth.equals("10") || mounth.equals("Oct")||mounth.equals("Oct.")) {
				System.out.println(31);
			}else if(mounth.equals("November") || mounth.equals("11") || mounth.equals("Nov")||mounth.equals("Nov.")) {
				System.out.println(30);
			}else {
				System.out.println(31);
			}
			}
		System.out.println(typeyear);
			
	}
}
