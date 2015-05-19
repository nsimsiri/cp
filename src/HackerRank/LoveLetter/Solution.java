package HackerRank.LoveLetter;
import java.util.*;

public class Solution {

    public static int compute(String word){
        Stack<Character> st = new Stack<Character>();
        int mid = word.length()/2;
        for (int i = 0; i < mid; i++){
            st.push(new Character(word.charAt(i)));
        }
        int count = 0;
        for (int j = mid+1; j < word.length(); j++){
            char c = word.charAt(j);
            while(st.peek().charValue()!=c){
                c = (char)(c-1);
                count+=1;
            }
            st.pop();
        }
        return 0;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        for (int i = 0; i < N; i++){
            Solution.compute(in.nextLine());
        }

    }
}