package hust.soict.dsai.lab01;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class prob6_4 {
public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("enter year:");
		int year = keyboard.nextInt();
		System.out.println("enter mounth:");
		String month = keyboard.next();
		
		switch (month) {
		case "January":
		case "Jan":
		case "Jan.":
		case "1":
		case "March":
		case "Mar":
		case "Mar.":
		case "3":
		case "May":
		case "5":
		case "July":
		case "Jul":
		case "7":
		case "August":
		case "Aug":
		case "Aug.":
		case "8":
		case "October":
		case "Oct":
		case "Oct.":
		case "10":
		case "December":
		case "Dec":
		case "Dec.":
		case "12":
			System.out.println("31");
			keyboard.close();
			return;
		case "April":
		case "Apr":
		case "Apr.":
		case "4":
		case "June":
		case "Jun":
		case "6":
		case "September":
		case "Sep":
		case "Sept.":
		case "9":
		case "November":
		case "Nov":
		case "Nov.":
		case "11":
			System.out.println("31");
			keyboard.close();
			return;
		case "February":
		case "Feb":
		case "Feb.":
		case "2":
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					System.out.println("29");
					keyboard.close();
					return;
				} else {
					System.out.println("28");
					keyboard.close();
					return;
				}
			}
			if (year % 4 == 0) {
				System.out.println("29");
				keyboard.close();
				return;
			} else {
				System.out.println("28");
				keyboard.close();
				return;
			}
		}
		
		keyboard.close();
		
	}

}