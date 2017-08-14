import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine);
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = in.nextInt();
        }
        int _min=-1;
        int _max=-1;
        int[] sol = null;
        for(int i=0;i<N-2;i++){
            for(int j=i+1;j<N-1;j++){
                for(int k=j+1;k<N;k++){
                    int a = arr[i];
                    int b = arr[j];
                    int c = arr[k];
                    if(a>b+c && b>a+c && c>a+b){
                        int min_t = Math.min(a, Math.min(b,c));
                        int max_t = Math.max(a, Math.max(b,c));
                        if (_min==-1 && _max==-1){
                            _min_t=_min; _max_t=_max;
                            sol = new int[]{a,b,c};
                        } else {
                            if (_max_t >=_max){
                                if(_max_t == _max && _min_t >= _min){
                                   sol = new int[]{a,b,c};
                                   _min = _min_t;
                                } else if(_max_t > _max) {
                                    _max = _max_t;
                                    sol = new int[]{a,b,c};
                                }
                            }
                        }
                    }
                }
            }
        }
        if (sol == null) System.out.println("-1");
        else{
            Arrays.sort(sol);
            for(int i = 0;i<3;i++){
                System.out.print(sol[i]+" ");
            }
        }
    }
}


