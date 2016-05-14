package Codeforces.EducationalR10;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by NatchaS on 4/2/16.
 */
public class FoePairs {
    public static class Pair{
        public int L;
        public int R;
        public Pair(int a, int b){
            if(a>b){
                L =b;
                R =a;
            }
            else {
                L=a;
                R=b;
            }
        }
        public boolean contains(Pair pair){
            return pair.L >= L && pair.R <= R;
        }
    }

    public static void main(String[] args){
        try {
            String removedSpaceSignature = "java.lang.Comparable".replaceAll("\\s+","");
            Comparable<Integer> comp2o = (Comparable<Integer>)new Integer(1);
            System.out.println("===="+comp2o.getClass().getCanonicalName());
            Class<?> comp = Class.forName(removedSpaceSignature);

            System.out.println(comp.getGenericSuperclass());
            System.out.println(Integer.class.getGenericSuperclass());

//            for (Type t : comp.getGenericInterfaces()){
//                System.out.println(t instanceof ParameterizedType);
//            }
//            System.out.println("--");
//            for (Type t : Integer.class.getTypeParameters()){
//                System.out.println(t instanceof ParameterizedType);
//            }

        } catch (Exception e){
            e.printStackTrace();
        }

        String inv = "1 + 1 == 2";
        String[] sp = inv.split("==");
        System.out.println(Arrays.toString(sp));
        for(int i = 0 ;i < sp.length; i++){
            sp[i] = sp[i].replaceAll("\\s+","");
        }
        System.out.println(Arrays.toString(sp));
//        Scanner in = new Scanner(System.in);
//        int N = in.nextInt();
//        int M = in.nextInt();
//        int[] p = new int[N];
//        Pair[] foes = new Pair[M];
//        for(int i = 0; i < N; i++){
//            p[i] = in.nextInt();
//        }
//        for(int i = 0; i < N; i++){
//            int a = in.nextInt();
//            int b = in.nextInt();
//            foes[i] = new Pair(a,b);
//        }
//        for(int i = 0; i < N; i++){
//            for(int j = i+1; j < N; j++){
//                Pair check = new Pair(p[i], p[j]);
//
//
//
//            }
//        }

    }
}
