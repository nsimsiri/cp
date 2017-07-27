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
            Node a = new Node(null, Integer.parseInt(sl[0]), null);
            Node b = new Node(null, Integer.parseInt(sl[1]), null);
            vtx[i].left = a; vtx[i].right = b;
            if(k < N-1){
                vtx[k++]=a;
                vtx[k++]=b;
            }
        }
        System.out.println(n1);
  
        int T = Integer.parseInt(in.nextLine());
        for (int i = 0; i < T; i++){
            int lv = Integer.parseInt(in.nextLine());
            System.out.println(lv);
        }
        
    }
}



