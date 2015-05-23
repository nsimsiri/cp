package HackerRank.LoveLetterSt;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int[] compute(String[] words){
        int[] ans = new int[words.length];
        for (int i = 0; i < words.length; i++){
            int count = 0;
            char[] word = words[i].toCharArray();
            for(int st = 0; st < word.length/2; st++){
                int ed = word.length-1-st;
                count += Math.abs(word[st]-word[ed]);
            }
            ans[i] = count;
        }
        return ans;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        String[] words = new String[N];
        for(int i = 0; i < N; i++){
            words[i] = in.nextLine();
        }
        int[] res = Solution.compute(words);
        for (int i = 0 ; i < N; i++){
            System.out.println(res[i]);
        }
    }
}
