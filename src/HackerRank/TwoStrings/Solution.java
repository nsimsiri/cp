package HackerRank.TwoStrings;

import java.util.Scanner;

/**
 * Created by NatchaS on 4/12/15.
 */
public class Solution {

    public static void run(String s1, String s2){
        boolean [] set = new boolean[26];
        for (int i = 0; i < s1.length(); i++){
            set[s1.charAt(i)%26] = true;
        }
        for (int i = 0; i < s2.length();i++){
            if (set[s2.charAt(i)%26]){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");

    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int argCount = Integer.parseInt(in.nextLine());
        for (int i = 0; i < argCount; i++){
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            Solution.run(s1,s2);
        }
    }
}
