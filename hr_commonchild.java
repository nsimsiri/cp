import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static int ctoi(char c) { return ((int) c) - 65; }
    static int commonChild(String s1, String s2){
        int n = s1.length(); int m = s2.length();
        int[][] cnt1 = new int[n][26];
        int[][] cnt2 = new int[m][26];
        for(int i=0;i<Math.max(n,m);i++){
            if(i==0 && i < n) cnt1[i][ctoi(s1.charAt(i))]++;
            else if(i < n){
                System.arraycopy(cnt1[i-1], 0, cnt1[i], 0, 26);
                cnt1[i][ctoi(s1.charAt(i))]++;
            }
            if(i==0 && i < m) cnt2[i][ctoi(s2.charAt(i))]++;
            else if(i < m){
                System.arraycopy(cnt2[i-1], 0, cnt2[i], 0, 26);
                cnt2[i][ctoi(s2.charAt(i))]++;
            }
        }
        int dp[][] =  new int[n][m];
        char s10 = s1.charAt(0); char s20 = s2.charAt(0);
        for(int i=0;i<n;i++){
            char s1i = s1.charAt(i);
            dp[i][0] = (cnt1[i][ctoi(s1i)]==1 && s1i==s20) ? ((i==0)?0:dp[i-1][0]-1) : (i==0?2:dp[i-1][0]+1);
        }
        for(int i=0;i<m;i++){
            char s2i = s2.charAt(i);
            dp[0][i] = (cnt2[i][ctoi(s2i)]==1 && s2i==s10) ? ((i==0)?0:dp[0][i-1]-1) : (i==0?2:dp[0][i-1]+1);
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);
                if(c1==c2){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j]+1, dp[i][j-1]+1);
                }
            }
        }
        //for(int i=0;i<n;i++)System.out.println(Arrays.toString(dp[i]));
        int cnt = 0; int ii = n-1; int jj = m-1;
        while(ii>0 || jj>0){
            if(ii>0 && jj>0){
                if(dp[ii-1][jj-1]<=dp[ii-1][jj] && dp[ii-1][jj-1]<=dp[ii][jj-1]){
                    if(dp[ii-1][jj-1]==dp[ii][jj]) cnt++;
                    ii--; jj--;
                } else if(dp[ii-1][jj]<=dp[ii-1][jj-1] && dp[ii-1][jj]<=dp[ii][jj-1]){
                    ii--;
                } else if(dp[ii][jj-1]<=dp[ii-1][jj-1] && dp[ii][jj-1]<=dp[ii-1][jj]){
                    jj--;
                }
            } else if (ii>0){
                if(dp[ii-1][jj]>=dp[ii][jj]) cnt++;
                ii--;
            } else if(jj>0){
                if(dp[ii][jj-1]>=dp[ii][jj]) cnt++;
                jj--;
            }
        }
        if(dp[0][0]==0) cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = commonChild(s1, s2);
        System.out.println(result);
    }
}


