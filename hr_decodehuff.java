import java.util.*;
public class hr_decodehuff{
    void decode(String S, Node root){
        int i =0;
        Node cur = root;
        StringBuffer sb = new StringBuffer("");
        while(i<S.length()){
            char c = S.charAt(i);
            if(cur.left==null && cur.right==null){
                
                cur=root;
            } else {
                if (c=='0'){
                    cur=cur.left;
                } else {
                    cur=cur.right;
                }
            }
        }
    }
}
