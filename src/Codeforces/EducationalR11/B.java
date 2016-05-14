package Codeforces.EducationalR11;

import java.util.Scanner;

/**
 * Created by NatchaS on 5/10/16.
 */
public class B {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] lo = new int[N];
        int[] li = new int[N];
        int[] ri = new int[N];
        int[] ro = new int[N];
        int m = 1;
        for(int i = 0; i < N; i++){
            lo[i] = m++;
            ro[i] = m++;
        }

        for(int i = 0; i < N; i++){
            li[i] = m++;
            ri[i] = m++;
        }

        for(int i =0; i < N; i++){
            if (li[i] <= M) System.out.print(li[i]+" ");
            if (lo[i] <= M) System.out.print(lo[i]+" ");
            if (ri[i] <= M) System.out.print(ri[i]+" ");
            if (ro[i] <= M) System.out.print(ro[i]+" ");
        }

    }
}
