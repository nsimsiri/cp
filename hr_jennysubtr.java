import java.util.*;
import java.io.*;
class hr_jennysubtr {
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
        int start = m.keySet().iterator().next();
        int[] len1 = new int[n];
        int[] len2 = new int[n];
        int endl1 = walkcnt(start, m, len1);
        int endl2 = walkcnt(endl1, m, len2);
        //System.out.format(" == %s -> %s %s \n", endl1, endl2, Arrays.toString(len2));
        List<Integer> path = new ArrayList<>();
        int nextNode = endl2;
        path.add(nextNode);
        while(nextNode!=endl1){
            for(Integer nei : m.get(nextNode)){
                if(len2[nextNode] > len2[nei]){
                    nextNode = nei;
                    path.add(nextNode);
                    break;
                }
            }
        }
        //System.out.format("path = %s\n", path);
        int mid=path.size()/2;
        if(path.size()%2==0){
            Out.add(path.get(mid-1));
        }
        Out.add(path.get(mid));
    }

    public static long hashtree(Map<Integer, List<Integer>> m, int root, int n){
      Stack<Integer> st = new Stack<>();
      boolean[] vis = new boolean[n];
      long[] canon = new long[n];
      int[] lvl = new int[n];
      int _max = 0;
      /*for(Map.Entry<String, Integer> ent : hash.entrySet()){
        _max = ent.getValue() > _max ? ent.getValue() : _max;
      }*/
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
          List<Long> names = new ArrayList<>();
          names.add(191L);
          for(Integer nei : m.get(cur)){
            if (lvl[nei] > lvl[cur]){
              names.add(canon[nei]);
            }
          }
          Collections.sort(names);
          Long[] lnames = new Long[names.size()];
          for(int ll=0;ll< names.size();ll++) lnames[ll]=names.get(ll);
              
          /*StringBuffer sb = new StringBuffer("");
          for(Long i : names){
            sb.append(i+"-");
          }
          String canonName = sb.toString();*/
          
          //canon[cur] = Arrays.hashCode(lnames);
          canon[cur] = _hash(lnames,31L,2999999929L);
          System.out.println(Arrays.toString(lnames));
          
          /*if(hash.containsKey(canon[cur])){
              if (!hash.get(canon[cur]).equals(canonName)){
                  System.out.println(canonName);
                  System.out.println(hash.get(canon[cur]));
                  System.out.println(canon[cur]);
                  System.exit(1);
              }
          }else hash.put(canon[cur], canonName);*/
        }
      }
      return canon[root];
    }
    
    static Map<Integer,List<Integer>> gensubtr(Map<Integer,List<Integer>> m, int x, int n, int r){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        int[] lv = new int[n];
        lv[x]=1;
        Map<Integer,List<Integer>> out = new HashMap<>();
        while(!q.isEmpty()){
            int cur = q.poll();
            if(lv[cur]>r) break;
            for(Integer nei : m.get(cur)){
                if(lv[nei]==0){
                    lv[nei] = lv[cur]+1;
                    q.add(nei);
                    bldtr(cur,nei,out);
                }
            }
        }
        return out;
    }
    
    public static long _hash(Long[] arr, long a, long mod){
        long res=0;
        for(int i=0;i<arr.length;i++){
            res+=(Math.pow(a,i+1)*arr[i]);
        }
        
        return res%mod;
    }

    public static void main(String[] args) throws IOException{
        long t0 = System.currentTimeMillis();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       
        String[] tup = in.readLine().split(" ");
        Map<Long,String> hash = new TreeMap<>();
        int n = Integer.parseInt(tup[0]);
        int r = Integer.parseInt(tup[1]);
        Map<Integer,List<Integer>> m= new HashMap<>();
        for(int i=0;i<n-1;i++){
            tup=in.readLine().split(" ");
            int a = Integer.parseInt(tup[0])-1;
            int b = Integer.parseInt(tup[1])-1;
            bldtr(a,b,m);
        }
        int[][] hashEdges = new int[n][2];
        Set<String> uniq = new HashSet<>();
        for(int i=0;i<n;i++){
            Map<Integer,List<Integer>> subtr = gensubtr(m,i,n,r);
            List<Integer> cens = new ArrayList<>();
            findcen(subtr, cens, n);
            //System.out.format("findcen %s - %s\n", i, System.currentTimeMillis()-t3);
            long[] hashes = new long[]{-1,-1};
            
            for(int j=0;j<cens.size();j++){
                
                            
                hashes[j] = hashtree(subtr,cens.get(j),n);
                //System.out.format("hash %s - %s\n", i, System.currentTimeMillis()-t3);
            }
            if(hashes[1]==-1) uniq.add(new Long(hashes[0]).toString());
            else uniq.add(Math.max(hashes[0],hashes[1])+"-"+Math.min(hashes[0],hashes[1]));
            
            //System.out.format("=> %s = %s\n\n", cens, Arrays.toString(hashes));
            
        }
        //System.out.println("time " + new Long((System.currentTimeMillis()-t0)).toString());
        System.out.println(uniq.size());       
    }
} 


