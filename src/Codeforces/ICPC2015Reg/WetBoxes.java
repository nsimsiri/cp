package Codeforces.ICPC2015Reg;

        import java.lang.reflect.Array;
        import java.util.*;
/**
 * Created by NatchaS on 11/8/15.
 */
public class WetBoxes {

    public ArrayList<Integer> computeFast(int[] xs, int[] ys, int n){
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int maxDiag[] = new int[n]; // x->index, y->element
        for (int i = 0; i < n; i++) maxDiag[i] = -1;
        for (int i = 0; i < xs.length; i++){
            int count = 0;
            int cur_y = ys[i];
            for (int cur_x = xs[i]; cur_x <= xs[i]+ys[i]; cur_x++){
                if (maxDiag[cur_x] <= cur_y) {
                    count += cur_y - maxDiag[cur_x];
                    maxDiag[cur_x] = cur_y;
                    cur_y--;
                } else break;
            }
            ans.add(count);
        }
        return ans;
    }

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        Integer N = Integer.parseInt(in.nextLine());
        int[] xs = new int[N];
        int[] ys = new int[N];
        int max_length = 0;
        for(int i = 0; i < N; i++){
            String[] info = in.nextLine().split(" ");
            xs[i] = Integer.parseInt(info[0]);
            ys[i] = Integer.parseInt(info[1]);
            max_length = Math.max(max_length, ys[i]+xs[i]);
        }
        WetBoxes wb = new WetBoxes();
        ArrayList<Integer> ans = wb.computeFast(xs, ys, max_length + 1);
        for(Integer i : ans){
            System.out.println(i);
        }
    }
}
