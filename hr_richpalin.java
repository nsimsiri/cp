import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static int[] read(String s, int i, int n){
        return new int[]{
            Integer.parseInt(Character.toString(s.charAt(i))),
            Integer.parseInt(Character.toString(s.charAt(n-1-i))) };
    }
    static String richieRich(String s, int n, int k){
        int l=0;
        for(int i=0;i<n>>1; i++){
            int[] pair = read(s, i, n);
            l+=(pair[0]==pair[1] ? 0 : 1);
        }
        
        if(k<l){
            return "-1";
        } else {
            Set<Integer> chg = new HashSet<>();
            StringBuilder res = new StringBuilder(s);
            for(int i=0;i<n>>1;i++){
                int[] pair = read(s, i, n);
                if (pair[0]!=pair[1]){
                     chg.add(i);
                     res.setCharAt(pair[0]<pair[1] ? i : n-1-i, 
                        new Integer(Math.max(pair[0],pair[1])).toString().charAt(0));
                     k--;
                }
            }
            
            if(k!=0){
                s=res.toString();
                for(int i=0; i<n>>1 && k>0; i++){
                    int[] pair = read(,i,n);
                    if(pair[0]==9&&pair[1]==9) continue;
                    if(chg.contains(i)){
                        res.setCharAt(i,'9');
                        res.setCharAt(n-i-1,'9');
                        --k;
                    } else if(k>=2){
                        res.setCharAt(i,'9');
                        res.setCharAt(n-i-1,'9');
                        k-=2;
                    }
                }
                if(k>0 && n%2==1)
                        res.setCharAt(n>>1, '9');
                        
            }
            return res.toString();
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();
        String result = richieRich(s, n, k);
        System.out.println(result);
    }
}

