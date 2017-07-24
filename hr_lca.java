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
        Node cur = root;
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
            cur = child;
        }
        return null;
    }
    
    static Node lca(Node root, int a, int b){
        Map<Node,Node> m = new HashMap<>();
        Node n1 = find(root, a, m);
        Node n2 = find(root, b, m);
        Set<Integer> mb = new HashSet<>();
        while(!(n1.data==root.data && n2.data==root.data)){
            if(n1.data!=root.data){
                if (mb.contains(n1.data)){
                    return n1;
                } else {
                    mb.add(n1.data);
                    n1 = m.get(n1);
                }
            }
            if(n2.data!=root.data){
                if(mb.contains(n2)){
                    return n2;
                } else {
                    mb.add(n2.data);
                    n2 = m.get(n2);
                }
            }
        }
        return root;
        
    }
    public static void main(String[] args){
        System.out.println("hilekj");
    }
}
    
