package Sandbox;

import com.sun.org.apache.bcel.internal.generic.Type;

/**
 * Created by NatchaS on 3/1/16.
 */
public class Box1 {
    public static void main(String[] args){
        System.out.println("hel.lo".replace(".", "_"));
        System.out.println(Type.INT.getClass());
        int i = new Integer(1);
        System.out.println(i);
        Class ic = int.class;
        System.out.println(boolean.class.getName().equals("boolean"));
        System.out.println(boolean[].class);

    }

//    interface MathOperation(){
//        int operation(int a, int b);
//    }

}
