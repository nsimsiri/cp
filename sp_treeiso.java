import java.util.*;

public class sp_treeiso {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            int k = nextInt();
            int[][] t1 = new int[n-1][2];
            int[][] t2 = new int[n-1][2];
            for(int j = 0;j<2*n-2;j++){
                String[] inp = in.nextLine().split(" ");
                int v1 = Integer.parseInt(inp[0]);
                int v2 = Integer.parseInt(inp[1]);
                if(j<n){
                    t1[j]= new int[]{v1,v2};
                } else {
                    t2[j-n]= new int[]{v1,v2};
                }
            }
           
        }
    }
}
