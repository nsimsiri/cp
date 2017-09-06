public class hr_isbst{
    void inotr(Node root, List<Integer> In){
        if(root.left != null){
            inotr(root.left, In);
        }
        In.add(root.data);
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
