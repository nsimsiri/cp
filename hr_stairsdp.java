import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int count(int n, int[] dp){
        int cnt = 0;
        if(n==0){
            return 1;
        } else {
            for(int i=1;i<=3;i++){
                if(n-i>=0){
                    if(dp[n-i]==0){
                        dp[n-i]=count(n-i, dp);
                    }                  
                    cnt+=dp[n-i];
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] In = new int[s];
        int max = 0;
        for(int a0 = 0; a0 < s; a0++){
            In[a0] = in.nextInt();
            max=Math.max(max,In[a0]);
        }
        int[] dp = new int[max+1];
        dp[0]=1;dp[1]=1;
        dp[max] = count(max, dp);
        for(int i = 0;i < s; i++){
            System.out.println(dp[In[i]]);
        }
    }
}

