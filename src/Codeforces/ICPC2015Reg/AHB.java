package Codeforces.ICPC2015Reg;

import java.util.*;
/**
 * Created by NatchaS on 11/6/15.
 */
public class AHB {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] info = input.split(" ");
        if (info.length==2){
            String s1 = info[0];
            String s2 = info[1];
            int ii = 0;
            int l = s1.length()-1;
            for(int i = 0; i < s1.length(); i++){
                Integer i1 = Integer.parseInt(new Character(s1.charAt(i)).toString());
                Integer i2 = Integer.parseInt(new Character(s2.charAt(i)).toString());
                ii+= Math.pow(10,(l--))*Math.abs(i1-i2);
            }
            System.out.println(ii);
        }

    }

}
