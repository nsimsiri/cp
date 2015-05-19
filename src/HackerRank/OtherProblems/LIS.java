package HackerRank.OtherProblems;

/**
 * Created by NatchaS on 5/3/15.
 */
public class LIS {
    // Longest Increasing Subsequence
    //

    public static void print(int[] a){
        for (int i =0 ; i< a.length; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public static void compute(int[] A){
        int[] dp = new int[A.length];
        int[] s = new int[A.length];
        s[A.length-1] = A.length-1;
        for (int i = A.length-1; i >= 0; i--){
            dp[i] = 0;
            int max = dp[i];
            int parent = i;
            for (int j = i+1; j < A.length; j++){
                if (A[i] < A[j] && dp[j] > max){
                    max = dp[j];
                    parent = j;
                }
            }
            dp[i] = max +1;
            s[i] = parent;
        }
        System.out.println(dp[0]);
//        int i = 0;
//        while(i!=s[i]){
//            System.out.println(A[i]);
//            i = s[i];
//        }
//        System.out.println(A[i]);
    }
    public static void main(String[] args){
        // 2 7 3 4 8 5 -> {2, 3, 4, 5},
        /*
        * dp[5] = 0
        * dp[4] = 1
        * dp[3] = 2
        * dp[5]
        * */

        int[] inputs = new int[]{2,7,3,4,8,5};
        LIS.compute(inputs);

    }
}
