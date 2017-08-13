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

    public static boolean isLeaf(int node, Map<Integer,List<Integer>> m) {
        List<Integer> l = m.getOrDefault(node, null);
        return null == l ? false : l.size() == 1;
    }

    public static int walkcnt(int x, Map<Integer,List<Integer>> m, int[] len){
        int n = len.length;
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[n];
        len[x]=0;
        st.push(x);
        while(!st.isEmpty()){
            int cur = st.pop();
            vis[cur]=true;
            for(Integer nei : m.get(cur)){
                if (!vis[nei]) {
                  len[nei]=len[cur]+1;
                  st.push(nei);
                }
            }
        }
        int cand=x;
        for(int i=0;i<n;i++){
            if(len[i] > len[cand] && isLeaf(i,m)) cand = i;
        }
        return cand;
    }

    public static void findcen(Map<Integer,List<Integer>> m, List<Integer> Out, int n){
        int start = 0;
        int[] len1 = new int[n];
        int[] len2 = new int[n];
        int endl1 = walkcnt(start, m, len1);
        int endl2 = walkcnt(endl1, m, len2);
        List<Integer> path = new ArrayList<>();
        int nextNode = endl1;
        path.add(nextNode);
        while(nextNode!=endl2){
            for(Integer nei : m.get(nextNode)){
                if(len2[nei] < len2[nextNode]){
                    nextNode = nei;
                    path.add(nextNode);
                    break;
                }
            }
        }
        int mid=path.size()/2;
        if(path.size()%2==0){
            Out.add(path.get(mid-1));
        }
        Out.add(path.get(mid));
    }

    public static int hashtree(Map<String, Integer> hash, Map<Integer, List<Integer>> m, int root, int n){
      Stack<Integer> st = new Stack<>();
      boolean[] vis = new boolean[n];
      int[] canon = new int[n];
      int[] lvl = new int[n];
      int _max = 0;
      for(Map.Entry<String, Integer> ent : hash.entrySet()){
        _max = ent.getValue() > _max ? ent.getValue() : _max;
      }
      int c = _max == 0 ? 2 : _max + 1;
      st.push(root);
      lvl[root] = 0;
      while(!st.isEmpty()){
        int cur = st.pop();
        if (!vis[cur]){
          vis[cur] = true;
          st.push(cur);
          for(Integer nei : m.get(cur)){
            if (!vis[nei]){
              st.push(nei);
              lvl[nei] = lvl[cur]+1;
            }
          }
        } else {
          List<Integer> names = new ArrayList<>();
          for(Integer nei : m.get(cur)){
            if (lvl[nei] > lvl[cur]){
              names.add(canon[nei]);
            }
          }
          Collections.sort(names);
          StringBuffer sb = new StringBuffer("1");
          for(Integer i : names){
            sb.append(i);
          }
          sb.append("0");
          String canonName = sb.toString();
          if (!hash.containsKey(canonName)){
            hash.put(canonName, c++);
          }
          canon[cur] = hash.get(canonName);
        }
      }
      return canon[root];
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextInt());
        for(int i = 0; i < n; i++){
            int k = Integer.parseInt(in.nextLine());
            System.out.format("k= %s\n", k);
            Map<Integer,List<Integer>> t1 = new HashMap<>();
            Map<Integer,List<Integer>> t2 = new HashMap<>();
            for(int j = 0;j<2*n-2;j++){
                String line = in.nextLine();
                System.out.format("++==== " + line + "\n");
                String[] inp = line.split(" ");
                System.out.format("== %s\n", Arrays.toString(inp));
                int v1 = Integer.parseInt(inp[0]);
                int v2 = Integer.parseInt(inp[1]);
                if(j<n) bldtr(v1,v2,t1);
                else bldtr(v1,v2,t2);
                System.out.println(t1);
                System.out.println(t2);
                System.out.println("-=====");


            }

        }
    }
}
