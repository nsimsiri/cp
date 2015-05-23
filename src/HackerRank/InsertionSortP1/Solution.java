package HackerRank.InsertionSortP1;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void print(int[] A){
        for (int j = 0; j < A.length; j++){
            System.out.print(A[j]+" ");
        }
        System.out.println();
    }
    public static void sort(int[] A){
        int k = A[A.length-1];
        int i = A.length-1;
        for(; i > 0; i--){
            if (A[i-1] > k){
                A[i] = A[i-1];
                print(A);
            } else break;
        }
        A[i] = k;
        print(A);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        int[] A = new int[N];
        String[] inputs = in.nextLine().split(" ");
        for (int i = 0; i < N; i++){
            A[i] = Integer.parseInt(inputs[i]);
        }
        Solution.sort(A);
    }
}

