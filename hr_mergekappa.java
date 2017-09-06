import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static long msort(int[] a, int lo, int hi){
        long cnt = 0;
        int mid = (lo+hi)/2;
        if(hi-lo == 1){
            if (a[hi]<a[lo]){
                int tmp = a[hi]; a[hi]=a[lo]; a[lo]=tmp;
                cnt++;
            }
        } else if(hi-lo>1){
            cnt += msort(a, lo, mid);
            cnt += msort(a, mid+1, hi);
            cnt += merge(a, lo, mid, hi);
        }
        return cnt;
    }
    
    static long merge(int[] a, int lo, int mid, int hi){
        long cnt = 0;
        List<Integer> b = new ArrayList<>();
        int i =lo; int j=mid+1;
        while(i <= mid && j <= hi){
            if(a[i] <= a[j]){
                b.add(a[i++]);
            } else {
                cnt += (mid+1)-i;
                b.add(a[j++]);
            }
            
            if(i>mid && j <= hi){
                while(j<=hi) b.add(a[j++]);
            } else if (j>hi && i <= mid){
                while(i<=mid) b.add(a[i++]);
            }
        }
        for(i = lo; i <= hi; i++) a[i] = b.get(i-lo);
        return cnt;
    }

    static long insort(int[] arr) {
        // Complete this function
        long cnt=0;
        for(int i=1;i<arr.length;i++){
            int s = i;
            while(s>= 1 && arr[s]<arr[s-1]){
                int tmp = arr[s];
                arr[s]=arr[s-1];
                arr[s-1]=tmp;
                cnt++;
                s--;
            }
       }
        return cnt;
    }
    
    static long countInversions(int[] arr) {
        long cnt = msort(arr, 0, arr.length-1);
        return cnt;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            long result = countInversions(arr);
            System.out.println(result);
        }
        in.close();
    }
}


