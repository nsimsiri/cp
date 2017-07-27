import java.util.*;

public class hr_sn {
    public static class Node{
        Node left; Node right; int data;
        public Node(Node left, int data, Node right){
            this.left=left; this.right=right; this.data=data;
        }
        @Override public String toString(){
            return "Node("+this.left+", "+this.data+", "+this.right+")";
        }
    }
    
    public static void inotr(Node root){
        if (root.left!=null){
            inotr(root.left);
        }
        System.out.print(root.data + " ");
        if (root.right!=null){
            inotr(root.right);
        }
    }
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        Node[] vtx = new Node[2*N+1];
        Node n1 = new Node(null, 1, null);
        vtx[0] = n1;
        int k = 1;
        for(int i = 0; i < N; i++){
            String ss = in.nextLine();
            String[] sl = ss.split(" ");
            int ai = Integer.parseInt(sl[0]);
            int bi = Integer.parseInt(sl[1]);
            Node a = (ai == -1) ? null : new Node(null, ai, null);
            Node b = (bi == -1) ? null : new Node(null, bi, null);
            vtx[i].left = a; vtx[i].right = b;
            if(a!=null) vtx[a.data-1] = a;
            if(b!=null) vtx[b.data-1] = b;
           
        }
        
        int T = Integer.parseInt(in.nextLine());
        int[] rots= new int[T];
        for(int i=0; i<T; i++){
            rots[i]=in.nextInt();
        }
        for (int i = 0; i < T; i++){
            int lv = rots[i];
            Queue<Node> q = new LinkedList<>();
            q.add(n1);
            int[] hgt = new int[N+1];
            hgt[n1.data]=1;
            while(!q.isEmpty()){
                Node cur=q.poll();
                if(hgt[cur.data]%lv==0){
                    Node tempL = cur.left;
                    cur.left=cur.right;
                    cur.right = tempL;
                }
                if(cur.left!=null){
                    q.add(cur.left);
                    hgt[cur.left.data] = hgt[cur.data]+1;
                }
                if(cur.right!=null){
                    q.add(cur.right);
                    hgt[cur.right.data] = hgt[cur.data]+1;
                }
            }
            System.out.println();
            inotr(n1);
            
            
        }
        
    }
}






