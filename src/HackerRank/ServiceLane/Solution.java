package HackerRank.ServiceLane;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public class pair {
        public pair(int st, int ed){this.st=st;this.ed=ed;}
        int st;
        int ed;
    }

    public static int[] compute(int[] segments, pair[] tests){
        int[] sol = new int[tests.length];
        for(int i = 0; i < tests.length; i++){
            int min = segments[tests[i].st];
            for (int j = tests[i].st; j <= tests[i].ed; j++){
                if (min > segments[j]) min = segments[j];
            }
            sol[i] = min;
        }
        return sol;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Solution Sol = new Solution();
        Scanner in = new Scanner(System.in);
        String[] info = in.nextLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int T = Integer.parseInt(info[1]);
        String[] segs = in.nextLine().split(" ");
        int[] segments = new int[N];
        pair[] tests = new pair[T];
        for (int i = 0; i < N; i++){
            segments[i] = Integer.parseInt(segs[i]);
        }

        for (int i = 0; i < T; i++){
            String[] pairStr = in.nextLine().split(" ");
            tests[i] = Sol.new pair(Integer.parseInt(pairStr[0]), Integer.parseInt(pairStr[1]));
        }
        int[] sol = Solution.compute(segments, tests);
        for (int i = 0; i < T; i++){
            System.out.println(sol[i]);
        }

    }
}
