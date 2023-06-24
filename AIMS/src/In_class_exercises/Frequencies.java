package In_class_exercises;
import java.util.*;
public class Frequencies {
	static void count_freq(String str)
    {
        Map<String,Integer> mp=new TreeMap<>();
        String arr[]=str.split(" ");

        for(int i=0;i<arr.length;i++)
        {
            if(mp.containsKey(arr[i]))
            {
                mp.put(arr[i], mp.get(arr[i])+1);
            }
            else
            {
                mp.put(arr[i],1);
            }
        }

        for(Map.Entry<String,Integer> entry:
                    mp.entrySet())
        {
            System.out.println(entry.getKey()+
                    " - "+entry.getValue());
        }
    }
    public static void main(String[] args) {
        String str = "a bc a a";
        count_freq(str);
    }
}
