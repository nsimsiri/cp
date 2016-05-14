package Codeforces.EducationalR10;

import java.util.Scanner;
import java.lang.Math;

/**
 * Created by NatchaS on 4/2/16.
 */
public class GabAndCat {
    public static int compute(int a, int b, int h1, int h2){
        if (a<=b && (h2-h1) > a*8) {
            return -1;
        } else {
            h1 = h1+a*8;
            if (h1>=h2) return 0;
            int movePerDay = (a-b)*12;
            return (int)Math.ceil(((double)(h2-h1))/((double)movePerDay));
        }

    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int h1 = in.nextInt();
        int h2 = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int res = compute(a,b,h1,h2);
        System.out.println(res);
    }
}
