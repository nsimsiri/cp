import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class hr_picknum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        SortedMap<Integer, Integer> m = new TreeMap<>();
        for(int a_i=0; a_i < n; a_i++){
            int x = in.nextInt();
            if(m.containsKey(x)) m.put(x, m.get(x)+1);
            else m.put(x, 1);
        }
        int i = 0; int prev = 0; int sum = 0; int max = m.get(m.firstKey());
        for(Map.Entry<Integer,Integer> en : m.entrySet()){
            if(i>0){
                sum = m.get(prev) + en.getValue();
                max = Math.max(max, (en.getKey()>prev.getKey()+1) ? en.getValue() : sum); 
            } 
            prev=en.getKey();
            i++;
        }
        System.out.println(max);
    }
}



