import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for(int a0 = 0; a0 < p; a0++){
            int x = in.nextInt();
            if(x==2) {
                System.out.println("Prime"); continue; }
            if(x%2==0 || x==1) { System.out.println("Not prime"); continue; }
            
             if(x==3) {
                System.out.println("Prime"); continue; }
            
            else {
                boolean pr=true;
                for(int i = 3; i <= ((int)Math.ceil(Math.sqrt(x))); i+=2){
                    if(x%i==0){
                        System.out.println("Not prime");
                        pr=false;
                        break;
                        
                    }
                }
                if(pr) System.out.println("Prime");
            }
        }
    }
}

