import java.util.*;

public class hr_lca {
    public static class Node {
        int data;
        Node left;
        Node right;
        public Node(Node left, int data, Node right){
            this.left=left;
            this.right=right;
            this.data=data;
        }
    }
    
    static Node _lca(Node root, int a, int b){
        Map<Integer,Integer> m = new HashMap<>();
        int[] In=new int[]{a,b};
        for(int i=0;i<2;i++){
            Stack<Node> st = new Stack<>();
            st.push(In[i]);
            boolean found = false
            while(!found && !st.isEmpty()){
                
            }
        }    
    }
    public static void main(String[] args){
        System.out.println("hilekj");
    }
}
    
