import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static int ctoi(char c){ return ((int) c )-97; }

    static int sherlockAndAnagrams(String s){
        int n = s.length();
        int cnt = 0;
        for(int i=1; i<n; i++){
            Map<List<Integer>, Integer> dupm = new HashMap<>();
            int head_idx = 0;
            List<Integer> a = new ArrayList<>(Collections.nCopies(26, 0));
           
            for(int j=0; j<n; j++){
                char c=s.charAt(j);
                if(j<i){
                    int idx = ctoi(c);
                    a.set(idx, a.get(idx)+1);
                    if(i-1==j) dupm.put(new ArrayList<Integer>(a), 1);
                } else {
                    char ch = s.charAt(head_idx++);
                    int idxc = ctoi(c);
                    int idxch = ctoi(ch);
                    a.set(idxch, a.get(idxch)-1);
                    a.set(idxc, a.get(idxc)+1);
                    dupm.put(new ArrayList<Integer>(a), dupm.getOrDefault(a, 0)+1);
                }
                
            }
            for(Map.Entry<List<Integer>, Integer> e : dupm.entrySet()){
                int k = e.getValue();
                cnt += k*(k-1) >> 1;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = sherlockAndAnagrams(s);
            System.out.println(result);
        }
    }
}
