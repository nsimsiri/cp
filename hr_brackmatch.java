import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static boolean isBalanced(String e) {
        Stack<Character> st = new Stack<>();
        Map<Character,Character> cl = new HashMap<>();
        cl.put(')','('); cl.put('}','{'); cl.put(']','[');
        for(int i=0;i<e.length();i++){
            Character c = new Character(e.charAt(i));
            if(cl.containsKey(c)){
                if(st.isEmpty()||!st.pop().equals(cl.get(c))){
                    return false;
                }
            } else {
                st.push(c);
            }
        }
            
        return st.isEmpty();
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}

