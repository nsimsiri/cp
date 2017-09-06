import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        for (int i=0;i<N;i++){
            String s = in.readLine();
            if(s.equals("1") || s.equals("4") || s.equals("78")){
                System.out.println("+");
            } else if (s.length()>=3 && s.substring(s.length()-2,s.length()).equals("35")){
                System.out.println("-");
            } else if (s.length()>=3 && s.charAt(0)=='9' && s.charAt(s.length()-1)=='4'){
                System.out.println("*");
            } else if (s.length()>=4 && s.substring(0, 3).equals("190")){
                System.out.println("?");
            }
        }
    }
}
