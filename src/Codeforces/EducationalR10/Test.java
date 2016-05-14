package Codeforces.EducationalR10;

import java.util.Arrays;

/**
 * Created by NatchaS on 4/8/16.
 */
public class Test {
    public static String[] parseExprParen(String exp) {return exp.split("[\\(\\)]");}
    public static String[] parseArray(String exp) {
        return exp.split("[\\[\\]]");
    }
    public static void main(String[] args){
//        System.out.println(Arrays.toString(parseArray("this.theArray[..]")));
//        String[] var = parseArray("this.theArray[..]");
//        System.out.println(parseExprParen(var[0]));
//        System.out.println("!=".contains("=="));
//        Integer n1 = new Integer(1);
//        Double n2 = new Double(2);

        int k = 6;
        int count = k/2;
        int starInit = 0;
        int starEnd = 1;
        for(int i = 0; i < k; i++){
            for(int j = 1; j <= count; j++) {
                System.out.print(" ");
            }
            for(int j = starInit; j < starEnd; j++){
                System.out.print("*");
            }
            if (i<k/2){
                count--;
                starEnd = 2*(i+1)+1;
            } else {
                count++;
                starInit = -1*(2*(k-i-1)+1);
                starEnd = 0;
            }
            System.out.println();
        }


    }
}
