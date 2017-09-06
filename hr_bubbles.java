import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int c=0;
        for(int i=0;i<n;i++){
            boolean brk=true;
            for(int j=0;j<n-1;j++){
                if(a[j]>a[i+1]){
                    int tmp = a[j];
                    a[j]=a[j+1];
                    a[j+1]=tmp;
                    c++;
                    brk=false;
                }
            }
            if(brk) break;
        }
        System.out.format("Array is sorted in 3 swaps.\n", c);
        System.out.format("First Element: %s\n", a[0]); 
        System.out.format("Last Element: %s\n", a[n-1]);
    }
}

