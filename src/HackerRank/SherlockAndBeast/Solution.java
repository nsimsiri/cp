package HackerRank.SherlockAndBeast;

import java.util.*;

public class Solution {

    public static StringBuffer compute(int k) {
        StringBuffer s;
        if (k<=-1) return new StringBuffer("-1");
        else if (k==0) return new StringBuffer("");
        else {
            if (k%3==0){
                s = new StringBuffer("");
                for (int i = 0; i < k/3; i++){
                    s.append("555");
                }
            }
            else {
                s = compute(k - 5);
                if (s.length()==2){
                    if (s.toString().equals("-1")) return s;
                }
                else {
                    s.append("33333");
                }
            }
            return s;
        }
    }

//    public static String compute(int k){
//        StringBuffer result = Solution._compute(k);
//        if (result.length()==2){
//            if (result.toString().equals("-1")) return "-1";
//        }
////        System.out.println("solved");
//        int[] set = new int[6];
//        String res = result.toString();
//        for (int i = 0; i < res.length(); i++){
//            set[Integer.parseInt(res.substring(i,i+1))]+=1;
//        }
//        StringBuffer newResult = new StringBuffer();
//        for (int j = 0; j < res.length(); j++){
//            if (set[5]!=0){
//                newResult.append("5");
//                set[5]-=1;
//            } else if (set[3]!=0){
//                newResult.append("3");
//            }
//        }
//        return newResult.toString();
//    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n ; i++){
            int k = Integer.parseInt(in.nextLine());
            System.out.println(Solution.compute(k).toString());
        }

    }
}