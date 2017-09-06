import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class TrNode {
        int[] freq;
        TrNode[] nodes;
        TrNode(){
            this.freq = new int[26];
            this.nodes = new TrNode[26];
        }
        public void add(String s){
            TrNode cur=this;
            for(int i=0;i<s.length();i++){
                int c = ((int) s.charAt(i))-97;
                cur.freq[c]++;
                if(cur.nodes[c]==null){
                    cur.nodes[c]=new TrNode();
                } 
                cur=cur.nodes[c];
            }
        }
        
        public int find(String s){
            TrNode cur = this;
            int sum=0;
            for(int i=0;i<s.length();i++){
                int c = ((int) s.charAt(i))-97;
                if(i==s.length()-1) return cur.freq[c];
                if(cur.nodes[c]==null) return 0;
                else {
                    cur=cur.nodes[c];
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        TrNode root = new TrNode();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if(op.equals("add")) root.add(contact);
            else System.out.println(root.find(contact));
        }
    }
}

