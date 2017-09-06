import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class Graph {
        int n;
        List<List<Integer>> m;
        public Graph(int size) {
            n=size;
            m=new ArrayList<>();
            for(int i=0;i<n;i++){
                m.add(new ArrayList<Integer>());
            }
        }

        public void addEdge(int u, int v) {
            m.get(u).add(v);
            m.get(v).add(u);
        }
        
        public int[] shortestReach(int x) { // 0 indexed
            Queue<Integer> q = new ArrayDeque();
            int[] dis = new int[n];
            boolean[] vis = new boolean[n];
            dis[x]=0; vis[x]=true;
            q.add(x);
            while(!q.isEmpty()){
               int u = q.poll();
               
               for(Integer v : m.get(u)){
                   if(!vis[v]){
                       q.add(v);
                       dis[v]=dis[u]+6;
                       vis[v]=true;
                   }
               }
            }
            for(int i=0;i<n;i++){
                if(dis[i]==0) dis[i]=-1;
            }
            return dis;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        int queries = scanner.nextInt();
        
        for (int t = 0; t < queries; t++) {
            
            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();
            
            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                
                // add each edge to the graph
                graph.addEdge(u, v);
            }
            
            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);
 
            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();            
        }
        
        scanner.close();
    }
}


