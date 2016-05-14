package Codeforces.EducationalR11;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by NatchaS on 5/10/16.
 */
public class A {

    public static int precomp_prime(int max_n){
        int k = (int)Math.floor(Math.sqrt(max_n));
        if (k%2==0) k+=1;
        for(int i = k; k < max_n; k+=2){
            int c = 3;
            boolean st = true;
            while(c<(int)Math.sqrt(k)){
                if (i%c==0) {
                    st=false;
                    break;
                }
            }
            if(st) return i;
        }
        return 0;
    }
    public static int coprime(int a, int b){
        if (b < a) return coprime(b, a);
        boolean status = false;
        int r = 3;
        int s = a;
//        if (b > 24) s = (int)Math.ceil(Math.sqrt(b));
        if (a%2==0&&b%2==0) return 1;
        for(int k = 3; k <= s; k+=2){;
            if (a%k!=0 && b%k!=0) {
                r = k;
                if(status) break;
            }
            if (a%k==0&&b%k==0) status = true;
        }
        if (status) return r;
        return -1;
    }

    public static boolean isCoprime(int a, int b){
        if (b < a) return isCoprime(b, a);
        boolean status = false;
        int r = 0;
        int s = (int)Math.floor(Math.sqrt(a));
        if (a%2==0&&b%2==0) return false;
        for(int i = 1; 2*i+1 <= a; i=2*i+1){
            int k = 2*i+1;
            if (a%k==0&&b%k==0) return false;
        }
        return true;
    }

    public static int findPrime(int a, int b){
        if (b<a) return findPrime(b,a);
//        int k = (int)Math.floor(Math.sqrt(b));
//        if (a > k ) k = a+1;
        int k = a+1;
        if (k%2==0) k+=1;
//        int k = 3;
        for(int i = k; i < b; i+=2){
            int c = 3;
            boolean found = true;
            while(c<i) {
                if (i % c == 0){
                    found = false;
                    break;
                }
                c+=2;
            }
            if (found && a%i!=0 && b%i!=0) return i;
        }
        return -1;
    }

    public static int gcd(int a, int b){
        if (b<a) return gcd(b,a);
        while(a!=0){
            int t = a;
            a = b%a;
            b = t;
        }
        return b;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] Inn = new int[N];
        int[] Out = new int[2*N];
        for(int i = 0; i < N; i++){
            Inn[i] = in.nextInt();
        }
        int count=0;
        int j = 0;
        Out[j++] = Inn[0];
        for(int i = 0; i < Inn.length - 1; i++){
            int a = Inn[i];
            int b = Inn[i+1];
            int f = gcd(a, b);
            if (f!=1){
                Out[j++] = 1;
                Out[j++] = Inn[i+1];
                count+=1;
            } else {
                Out[j++] = Inn[i+1];
            }
        }
        System.out.println(count);
        for(int i = 0; i < N+count; i++){
            System.out.print(Out[i] + " ");
        }
    }
}
