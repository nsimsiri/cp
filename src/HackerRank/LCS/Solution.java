package HackerRank.LCS;
// LONGEST COMMON SUBSEQUENCE
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {

    public class DPNode {
        int row;
        int col;
        int data;
        public DPNode(int row, int col, int data){this.row=row;this.col=col;this.data=data;}
        @Override public String toString(){return String.format("(%s, %s)=%s", row, col, data);}
    }
    public static void print(DPNode[][] dp){
        for(int i =0 ; i < dp.length; i++){
            for (int j =0 ; j < dp[0].length; j++){
                if (dp[i][j]!=null)System.out.print(dp[i][j].toString() + " ");
                else System.out.print("null      ");
            }
            System.out.println(" ");
        }
    }

    public static ArrayList<Integer> compute(int[] A, int[] B){
//        Integer[][] a = new Integer[5][5];
        Solution Sol = new Solution();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        DPNode[][] dp = new DPNode[A.length][B.length];
        //initialize first row/col
        if (A[0]==B[0]) dp[0][0] = Sol.new DPNode(0,0,1);
        else dp[0][0] = Sol.new DPNode(0,0,0);
        for (int i =1 ; i < B.length;i ++){
            boolean taken = false;
            if (A[0]==B[i] && !taken) {dp[0][i]=Sol.new DPNode(0, i, 1); taken=true;}
            else dp[0][i]=Sol.new DPNode(0, i-1, dp[0][i-1].data);
        }
        for (int i = 1; i < A.length; i++){
            boolean taken = false;
            if (A[i]==B[0]&&!taken){dp[i][0]=Sol.new DPNode(i, 0, 1);taken=true;}
            else dp[i][0] = Sol.new DPNode(i-1, 0 , dp[i-1][0].data);
        }
        // build dp table
        for(int row = 1; row<A.length; row++){
            for(int col = 1; col<B.length; col++){
                DPNode node;
                int left = dp[row][col-1].data;
                int up = dp[row-1][col].data;
                int leftup = dp[row-1][col-1].data;
                if (A[row]==B[col]){
                    node = Sol.new DPNode(row-1, col-1, dp[row-1][col-1].data);// look at max of A_i-1, B_j-1
                    if (node.data==0){
                        node.row=row;
                        node.col=col;
                    }
                    node.data+=1;
                } else {
                    if (left >= up) node = Sol.new DPNode(row, col-1, left);
                    else node = Sol.new DPNode(row-1, col, up);
                }
                dp[row][col]=node;
            }
        }

        Solution.print(dp);
        int _row = A.length-1;
        int _col = B.length-1;
        int curRow = _row+1;
        while(!(_row==dp[_row][_col].row && _col==dp[_row][_col].col)){
            if (A[_row]==B[_col] && curRow != _row){
                ans.add(A[_row]);
                curRow=_row;
            }
            int __row = dp[_row][_col].row;
            int __col = dp[_row][_col].col;
            _row = __row;
            _col = __col;
        }
        if (A[_row]==B[_col]) ans.add(A[_row]);
        return ans;
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

        ArrayList<Integer> ans = Solution.compute(A, B);

        for(int i =  ans.size()-1; i>=0; i--){
            System.out.print(ans.get(i) + " ");
        }
        /*
        *
        5 6
        1 2 3 4 1
        3 4 1 2 1 3
        * */

    }
}
