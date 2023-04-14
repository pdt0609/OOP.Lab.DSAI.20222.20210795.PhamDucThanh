package thanh;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;
class Test{
public static void main(String[] args) 
    {
        int n, sum = 0;
        float average;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        int [] a = new int[n];
        System.out.println("Enter all the elements:");
        for(int i = 0; i < n ; i++)
        {
            a[i] = s.nextInt();
            sum = sum + a[i];
        }
        System.out.println("Sum:"+sum);
        average = (float)sum / n;
        System.out.println("Average:"+average);
        Arrays.sort(a);
        for (int num : a) {
            System.out.print(num + " ");
        }
        
}}