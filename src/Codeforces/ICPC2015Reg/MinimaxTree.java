package Codeforces.ICPC2015Reg;

import java.util.*;

/**
 * Created by NatchaS on 12/23/15.
 */
public class MinimaxTree {
    public static void printTree(int[] parents, int[] values, int N){
        for(int i = 1; i < N; i++){
            System.out.format("node=%s parent=%s value=%s\n", i, parents[i], values[i]);
        }
    }

    public static List<Integer> kReachableFrontiers(HashMap<Integer, List<Integer>> tree, int N, int K){
        Queue<Integer> q = new LinkedList<Integer>();
        HashMap<Integer, Integer> htMap = new HashMap<Integer, Integer>();
        List<Integer> reachableFrontier = new ArrayList<Integer>();
        htMap.put(1, 1);
        q.add(1);
        while(!q.isEmpty()){
            int vtx = q.poll();
            int ht= htMap.get(vtx);
            if (ht > K) break;
            if (ht==K){
                reachableFrontier.add(vtx);
            } else {
                for(int nVtx : tree.get(vtx)){
                    htMap.put(nVtx, ht+1);
                    q.add(nVtx);
                }
            }
        }
        return reachableFrontier;
    }

    public static void Solution1(int[] labels, int[] values, int N, int K, HashMap<Integer, List<Integer>> tree){
        List<Integer> kReachbles = kReachableFrontiers(tree, N, K);
        Set<Integer> kReachSet = new HashSet<Integer>(kReachbles);


    }

    public static void main(String args[]){
        System.out.println("MinimaxTree:");
        Scanner in = new Scanner(System.in);
        String[] headerInfo = in.nextLine().split(" ");
        int N = Integer.parseInt(headerInfo[0]) + 1; // 1-index based
        int K = Integer.parseInt(headerInfo[1]);

        String[] parentsInfo = in.nextLine().split(" ");
        String[] valuesInfo = in.nextLine().split(" ");
        int parents[] = new int[N];
        int values[] = new int[N];
        HashMap<Integer,List<Integer>> adjList = new HashMap<Integer,List<Integer>>();

        for(int i = 1; i < N; i++){
            if (i==1){
                parents[i] = 1;
            }
            else{
                parents[i]= Integer.parseInt(parentsInfo[i-2]);
                if (!adjList.containsKey(parents[i])){
                    ArrayList<Integer> newAdj = new ArrayList<Integer>();
                    newAdj.add(i);
                    adjList.put(parents[i], newAdj);
                } else {
                    adjList.get(parents[i]).add(i);
                }
            }
            values[i] = Integer.parseInt(valuesInfo[i-1]);
        }
        System.out.println(adjList);
//        MinimaxTree.printTree(parents,values,N);
        MinimaxTree.Solution1(parents, values, N, K, adjList);


    }
}
