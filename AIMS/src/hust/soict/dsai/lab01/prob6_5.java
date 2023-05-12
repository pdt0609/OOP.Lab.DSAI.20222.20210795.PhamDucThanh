package hust.soict.dsai.lab01;

import java.util.Arrays;

public class prob6_5 {
public static void main(String[] args) {
		
		int[] my_array = {1789, 2035, 1899, 1456, 2013};
		System.out.println("Original numeric array : " + Arrays.toString(my_array));
	    Arrays.sort(my_array);
	    System.out.println("Sorted numeric array : " + Arrays.toString(my_array));
		
	    double sum = 0;
	    double count = 0;
	    for (int value : my_array) {
	    	sum += value;
	    	count += 1;
	    }
	    System.out.println("Sum: " + sum);
	    System.out.println("Average: " + (sum / count));

	}
}
