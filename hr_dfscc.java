import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int dfsMark(int[][] mat, int n,int m, int i, int j, boolean[][] vis){
        int cnt = 1;
        vis[i][j]=true;
        for(int ii = i-1; ii <= i+1; ii++){
            for(int jj = j-1; jj <= j+1; jj++){
                if(ii < n && ii >=0 && jj < m && jj >= 0 && !vis[ii][jj] && mat[ii][jj]==1){
                    cnt+=dfsMark(mat,n,m,ii,jj,vis);
                }
            }
        }
        return cnt;
    }
    
    public static int getBiggestRegion(int[][] mat,int n,int m) {
        boolean[][] vis = new boolean[n][m];
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1 && !vis[i][j]){
                    max = Math.max(max,dfsMark(mat,n,m,i,j,vis));
                }
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getBiggestRegion(grid,n,m));
    }
}

