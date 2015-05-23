package HackerRank.LCS;
// LONGEST COMMON SUBSEQUENCE
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {

    public static int[] compute(int[] A, int[] B){
        return null;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
    	String[] info = in.nextLine().split(" ");
        int N1 = Integer.parseInt(info[0]);
        int N2 = Integer.parseInt(info[1]);
        int[] A = new int[N1];
        int[] B = new int[N2];
        String[] input1 = in.nextLine().split(" ");
        String[] input2 = in.nextLine().split(" ");
        for(int i = 0; i < N1; i++){
            A[i] = Integer.parseInt(input1[i]);
        }
        for (int j = 0; j < N2; j++){
            B[j] = Integer.parseInt(input2[j]);
        }

        int[] ans = Solution.compute(A, B);


    }
}
