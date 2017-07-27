public class hr_isbst{
    boolean checkBst(Node root){
        if (root==null) return true;
        boolean a = (root.left == null) true : root.left.data < root.data;
        boolean b = (root.right == null) true : root.right.data > root.data;
        return a && && b && checkBst(root.left) && checkBst(root.right);
    }
}
