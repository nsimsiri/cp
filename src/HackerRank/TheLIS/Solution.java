package HackerRank.TheLIS;

import java.util.*;

public class Solution {
    // naive DP - O(n^2)
    public static void compute(int[] A){
        int[] dp = new int[A.length];
        for (int i = A.length-1; i >= 0; i--){
            dp[i] = 0;
            int max = dp[i];
            for (int j = i+1; j < A.length; j++){
                if (A[i] < A[j] && dp[j] > max){
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
        }
        int max = dp[0];
        for (int x = 0; x < dp.length; x++){
            if (max < dp[x]) max = dp[x];
        }
        System.out.println(max);
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        int[] inputs = new int[N];
        for (int i = 0; i < N; i++){
            inputs[i] = Integer.parseInt(in.nextLine());
        }
        Solution.compute(inputs);
    }
    // 20 2 7 4 3 8 1
}





