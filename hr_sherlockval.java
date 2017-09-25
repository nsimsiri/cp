import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String isValid(String s){
        int[] cnts = new int[26];
        for(int i = 0;i<s.length();i++){
            cnts[((int) s.charAt(i))-97]++;
        }
        Map<Integer, Integer> m = new HashMap<>();
        for(int i=0;i<26;i++){
            int k = cnts[i];
            if(k>0){
                 m.put(k, m.getOrDefault(k, 0)+1);
            }
           
            if(m.keySet().size()>2) break;
        }
        Set<Integer> cntset = m.keySet();
        if(cntset.size()==2){
            Iterator<Integer> itr = cntset.iterator();
            int a = itr.next(); int b = itr.next();
            int x = m.get(a); int y = m.get(b);
            return (Math.abs(a-b) == 1 && ((x == 1 && a > b) || (y==1 && a < b))) || ((x==1 && a==1)||(y==1 && b==1))? "YES" : "NO";
        }
        
        return cntset.size()==1 ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
    }
}

