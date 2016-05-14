package HackerRank.Knapsack1;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void printDP(int[][] dp, int S, int N){
        for(int i =0 ; i < S+1; i++){
            for(int j=0; j < N; j++){
                System.out.print(dp[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static int compute(int[] weights, int[] values, int S, int N){
        int[][] dp = new int[S+1][N];
        for(int i = 0; i < N; i++) {
            if (weights[i]==0) dp[0][i] = values[i];
            else dp[0][i]=0;
        }
        for(int j = 1; j < S+1; j++){
            if (weights[0]<=j) dp[j][0]=values[0];
            else dp[j][0]=dp[j-1][0];
        }
        for(int i = 1; i < S+1; i++){
            for(int j = 1; j < N; j++){
                if (weights[j]<=i){
//                    int m =Math.max(dp[i][j-1], dp[i-weights[j]][i-1]+values[j]);
////                    System.out.println(dp[i-weights[j]][i-1] + " + " + values[j]);
//                    System.out.println("i: "+(i-weights[j])+" j: "+(j-1)+ " = " + dp[i-weights[j]][j-1]);
                    dp[i][j]=Math.max(dp[i][j-1], dp[i-weights[j]][j-1]+values[j]);
                }
                else dp[i][j]=dp[i][j-1];
            }
        }
//        printDP(dp, S, N);
        return dp[S][N-1];
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        System.out.println("Knapsack \n");
        Scanner in = new Scanner(System.in);
        String[] info = in.nextLine().split(" ");
        int S = Integer.parseInt(info[0]);
        int N = Integer.parseInt(info[1]);
        int[] weights = new int[N];
        int[] values = new int[N];
        for(int i = 0; i  < N; i++){
            info = in.nextLine().split(" ");
            weights[i] = Integer.parseInt(info[0]);
            values[i] = Integer.parseInt(info[1]);
        }

        int ans =Solution.compute(weights, values, S, N);
        System.out.println(ans);

    }
}