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
    
    public static Node find(Node root, int x, Map<Node,Node> m){
        Node cur = root
        while(cur!=null){
            Node child = null;
            if(cur.left!=null && cur.data < x){
                child = cur.left;
            } else if(cur.right!=null && cur.data > x){
                child = cur;
            } else if(cur.data == x){
                return cur.right;
            } else {
                break;
            }
            m.put(child, cur);
            cur = child
        }
    }
    
    static Node _lca(Node root, int a, int b){
        Map<Integer,Integer> m = new HashMap<>();
        
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
    
