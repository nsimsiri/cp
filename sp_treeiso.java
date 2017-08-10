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
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            int k = nextInt();
            Map<Integer,List<Integer>> t1 = new Map<>();
            Map<Integer,List<Integer>> t2 = new Map<>();
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

