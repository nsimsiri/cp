public class hr_isbst{
    boolean checkBst(Node root){
        if (root==null) return true;
        boolean a = (root.left == null) true : root.left.data < root.data;
        boolean b = (root.right == null) true : root.right.data > root.data;
        return a && && b && checkBst(root.left) && checkBst(root.right);
    }
    void inotr(Node root, List<Integer> In){
        if(root.left != null){
            inotr(root.left, In);
        }
        In.add(In.data);
        if(root.right != null){
            inotr(root.right, In);
        }
    }
    boolean checkBST(Node root){
        List<Integer> In = new ArrayList<>();
        inotr(root, In);
        for(int i = 0; i < In.size()-1; i++){
            if (In.get(i) >= In.get(i+1)) return false;
        }
        return true;
        
    }
}
