import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static int[] read_tup(String s){
        String[] se = s.split(" ");
        return new int[]{
            Integer.parseInt(se[0]), Integer.parseInt(se[1]) };
    }
    
    static int cut(List<List<Integer>> adj, int u, int[] cnt, int p){
        int cuts = 0;
        for(Integer v : adj.get(u)){
            if(v!=p){
                cuts += cut(adj, v, cnt, u);
                cnt[u] += cnt[v];
            }
        }
        if(cnt[u]%2==1) {
            cuts++; cnt[u]=0;
        } else cnt[u]++;
        return cuts;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = read_tup(in.readLine())[0];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<Integer>());
        for(int i=0;i<n-1;i++){
            int[] e = read_tup(in.readLine());
            int u = e[0]-1; int v = e[1]-1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] cnt = new int[n];
        System.out.println(cut(adj,0,cnt, -1)-1);
    
    }
}

