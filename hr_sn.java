import java.util.;

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
    public static void(String[] args){
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.readLine());
        Node[] vtx = new Node[];
        Node n1 = new(null, 1, null);
        vtx[0] = n1;
        int k = 1;
        for(int i = 0; i < N; i++){
            String ss = in.readLine();
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
  
        int T = Integer.parseInt(in.readLine());
        for (int i = 0; i < T; i++){
            int lv = Integer.parseInt(in.readLine());
            System.out.println(lv);
        }
        
    }
}



