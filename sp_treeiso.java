import java.util.*;

public class sp_treeiso {
    public static void bldtr(int a,int b,Map<Integer,List<Integer>> m){
        if(m.containsKey(a)) m.get(a).add(b);
        else{
            List<Integer> l = new ArrayList<>();
            l.add(b);
            m.put(a,l);
        }
        if(m.containsKey(b)) m.get(b).add(a);
        else {
            List<Integer> l = new ArrayList<>();
            l.add(a);
            m.put(b,l);
        }
    }
    
    static boolean isLeaf(int node, Map<Integer,List<Integer>> m) {
        return m.getOrDefault(node, new ArrayList<>()).size()==1;
    }
    
    static int walkcnt(int x, Map<Integer,List<Integer>> m, int[] len){
        int n = len.length;
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[n];
        len[x]=0;
        st.push(x);
        while(!st.isEmpty()){
            int cur = st.pop();
            vis[cur]=true;
            for(Integer nei : m.get(cur)){
                len[nei]=len[cur]+1;
                if (!vis[nei]) st.push(nei);
            }
        }
        int cand=x;
        for(int i=0;i<n;i++){
            if(len[i] > len[cand] && isLeaf(i,m)) cand = i;
        }
        return cand;
    }
    
    static int findcen(Map<Integer,List<Integer>> m, int n){
        int start = 0;
        for(int i=0;i<n;i++){
            start = isLeaf(i, m) ? i : start;
        }
        int[] len1 = new int[n];
        int[] len2 = new int[n];
        int endl1 = walkcnt(start, m, len1);
        int endl2 = walkcnt(endl1, m, len2);
        
        
    }
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            int k = in.nextInt();
            Map<Integer,List<Integer>> t1 = new HashMap<>();
            Map<Integer,List<Integer>> t2 = new HashMap<>();
            for(int j = 0;j<2*n-2;j++){
                String[] inp = in.nextLine().split(" ");
                int v1 = Integer.parseInt(inp[0]);
                int v2 = Integer.parseInt(inp[1]);
                if(j<n) bldtr(v1,v2,t1);
                else bldtr(v1,v2,t2);
                    
              
            }
           
        }
    }
}


