import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int[] readTuple(String in){
      String[] args = in.split(" ");
      return new int[]{Integer.parseInt(args[0]), Integer.parseInt(args[1])}
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] nk = readTuple(bf.readLine());
        int N = nk[0]; int K = nk[1];
        int lucks = 0;
        List<Integer> tos = new ArrayList<>();
        for(int i=0;i<N;i++){
          int[] tup = bf.readTuple();
          int luck = tup[0]; int imp = tup[1];
          if (imp == 0){
            lucks += luck;
          } else {
            tos.add(luck);
          }
          Collections.sort(tos);
          for(int i = tos.size()-1; i >= tos.size()-1-k; i--){
            luck+=tos.get(i);
          }
          System.out.println(luck);
        }
    }
  }
