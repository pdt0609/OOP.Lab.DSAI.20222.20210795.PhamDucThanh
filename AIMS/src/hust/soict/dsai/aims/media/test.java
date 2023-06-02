package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class test {
	public static void main(String args[]) {
		String a[]={"c","tiger","lion","1"};
	    String value="c";
	    int c=-1;
	    for(int i=0;i<a.length;i++){
	        if(value.compareTo(a[i])==0){
	           c=i;
	        }
	    }
	System.out.print(c);
	}
}
