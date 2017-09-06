import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class IceCream implements Comparable{
    int flavor;
    int index;

    public IceCream(int flavor, int index) {
      this.flavor = flavor; this.index=index;
    }
   
    @Override
    public int compareTo(Object o) {
       IceCream ic = (IceCream) o;
       return new Integer(flavor).compareTo(ic.flavor);
    }

    @Override
    public boolean equals(Object o){
       IceCream ic = (IceCream) o;
       return ic.flavor == flavor && ic.index == index;
    }
        
}

public class Solution {
   
    public static int binarySearch(int lo, int hi, IceCream[] In, int s) {
        int mid = (lo+hi)/2;
        if(hi-lo < 2){
            if (In[lo].flavor==s) return In[lo].index;
            else if (In[hi].flavor==s) return In[hi].index;
        } else {
            if (In[mid].flavor == s) return In[mid].index;
            else if(In[mid].flavor > s){
                return binarySearch(lo,mid,In,s);
            } else if (In[mid].flavor < s){
                return binarySearch(mid,hi,In,s);
            }
        }
        return -1;
        
    }

    public static void main(String[] args) {
        
        int t;
        int n, m;
 
        Scanner in = new Scanner(System.in);
        t = in.nextInt();
       for(int test = 0; test < t; test++) {       
            
            m = in.nextInt();
            n = in.nextInt(); 
            IceCream[] arr = new IceCream[n];
    
            for (int i = 0; i < n; i++)
                arr[i] = new IceCream(in.nextInt(), i + 1);
            
            Arrays.sort(arr);
            int firstIndex = 100000, secondIndex = 100000;
            for(int i = 0; i < n - 1 ; i++) {
                int search = m - arr[i].flavor;
                if(search >= arr[i].flavor) {
                    int index = binarySearch( i + 1, n-1 , arr, search);
                    if( index != -1 ) {
                        System.out.println( Math.min(arr[i].index, index) + " " + Math.max(arr[i].index, index));
                        break;

                    }
                }
            } 
            
        }
        
    }
                        
}


