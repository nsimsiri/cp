import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static int lonelyInteger(int[] a) {
        long l = 0;
        long r = 0;
        for(int i = 0;i<a.length;i++){
            int x = a[i];
            //String cc = String.format("%s=%64s\n",x, Long.toBinaryString(l)).replace(' ', '0');
            //System.out.println(cc);
            if(x < 64){
                r ^= (1L << x);
            } else {
                l ^= (1L << (x-64));
            }
        }
                    //String cc = String.format("%64s\n",Long.toBinaryString(l)).replace(' ', '0');
            //System.out.println(cc);
        return (int) (r>0 ? Math.log(r)/Math.log(2) : 64+(Math.log(l)/Math.log(2)));
    }
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        System.out.println(lonelyInteger(a));
    }
}

