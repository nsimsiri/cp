import java.util.*;

public class Solution {
    Map<String, Integer> m;
    boolean ans;
    
    public Solution(String magazine, String note) {
        ans=true;
        m=new HashMap<>();
        for(String s : magazine.split(" ")){
            m.put(s,m.getOrDefault(s, 0)+1);
        }
        for(String s : note.split(" ")){
            if(m.containsKey(s)){
                int x=m.get(s);
                m.put(s,x-1);
                if(x==0){
                    ans=false;break;
                }
            } else {
                ans=false;
                break;
            }
       }
    }
    
    public boolean solve() {
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}


