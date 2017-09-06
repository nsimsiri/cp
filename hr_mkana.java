import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
    public static int numberNeeded(String a, String b) {
        int[] aa=new int[26];
        int[] bb=new int[26];
        for(int i=0;i<a.length();i++) aa[((int)a.charAt(i))-97]+=1;
        for(int i=0;i<b.length();i++) bb[((int)b.charAt(i))-97]+=1;
        int su=0;
        for(int i=0;i<26;i++) su+=Math.abs(aa[i]-bb[i]);
        return su;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}

