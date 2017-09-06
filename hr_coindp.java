import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static long makeChange(int[] In, int n, long[] dp) {
        return 2L;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        int min = Integer.MAX_VALUE;
        
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
            min=Math.min(min,coins[coins_i]);
        }
        long[][] dp = new long[m][n+1];
        for(int i=0;i<m;i++) dp[i][0]=1L;
        for(int i=1;i<n+1;i++){
            for(int j=0; j<m;j++){
                dp[j][i] += (j-1 >= 0) ? dp[j-1][i] : 0L;
                dp[j][i] += (i-coins[j] >= 0) ? dp[j][i-coins[j]] : 0L;
            }
        }
        if(min > n) System.out.println(0);
        else System.out.println(dp[coins.length-1][n]);
    }
}
