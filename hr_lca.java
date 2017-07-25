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
        
        public String toString(){
            return "Node("+this.data+")";
        }
    }
    
    public static Node find(Node root, int x, Map<Node,Node> m){
        Node cur = root;
        while(cur!=null){
            Node child = null;
            if(cur.left!=null && cur.data > x){
                child = cur.left;
            } else if(cur.right!=null && cur.data < x){
                child = cur.right;
            } else if(cur.data == x){
                return cur;
            } else {
                break;
            }
            m.put(child, cur);
            cur = child;
        }
        return null;
    }
    
    static Node _lca(Node root, int a, int b){
        Map<Node,Node> m = new HashMap<>();
        Node n1 = find(root, a, m);
        Node n2 = find(root, b, m);
        System.out.println("n1 " + n1);
        System.out.println("n2 " + n2);
        System.out.println(m);
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
                if(mb.contains(n2.data)){
                    return n2;
                } else {
                    mb.add(n2.data);
                    n2 = m.get(n2);
                }
            }
        }
        return root;
    }
    
    public static Node lca(Node root, int a, int b){
        if (root.data < a && root.data < b){
            return lca(root.right, a, b);
        } else if (root.data > a && root.data >b){
            return lca(root.left, a, b);
        } else {
            return root;
        }
       
    }
    public static void main(String[] args){
        System.out.println("running");
        Map<Node,Node> m = new HashMap<>();
        Node n1 = new Node(null, 1, null);
        Node n2 = new Node(null, 2, null);
        Node n3 = new Node(null, 3, null);
        Node n4 = new Node(null, 4, null);
        Node n5 = new Node(null, 5, null);
        Node n6 = new Node(null, 6, null);
        Node n7 = new Node(null, 7, null);
        n4.left=n2; n2.left=n1; n2.right=n3;
        n4.right=n5;
        n5.right=n7;
        n7.left=n6;
       
        Node ans1 = lca(n4, 1, 3);
        System.out.println(ans1);
        
        ans1 = lca(n4, 1, 4);
        System.out.println(ans1);
        
        ans1 = lca(n4, 1, 5);
        System.out.println(ans1);
        
        
        
    }
}
    




