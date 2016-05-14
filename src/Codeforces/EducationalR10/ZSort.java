package Codeforces.EducationalR10;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by NatchaS on 3/27/16.
 */
public class ZSort {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = in.nextInt();
        }
        Arrays.sort(A);
        int[] Out = new int[N];
        int i = 0;
        int j = N-1;
        for(int c = 0; c < N; c++){
            if (c%2==0){
                Out[c] = A[i++];
            } else {
                Out[c] = A[j--];
            }
        }

        for(int k = 0; k < N; k++){
            System.out.format("%s ", Out[k]);
        }
    }
}
