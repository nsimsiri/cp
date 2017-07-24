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
            st.push(root);
            while(!st.isEmpty()){
                Node cur = st.pop();
                if(cur.left!=null){
                    st.push(cur.left);
                    m.put(cur.left.data, cur.data);
                }
                if(cur.right!=null){
                    st.push(cur.right);
                    m.put(cur.right.data, cur.data);
                }
                if (cur.data == In[i]) break;
            }
        }
        Set<Integer> mb = new HashSet<>();
        int n1 = a; int n2 = b;
        while(!(n1==root.data && n2==root.data)){
            if(n1!=root.data){
                
            }
            if(n2!=root.data){
                
            }
        }
        return root;
        
    }
    public static void main(String[] args){
        System.out.println("hilekj");
    }
}
    
