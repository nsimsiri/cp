import java.util.*;

public class Solution {

    // 0 1 1 2 3 
    public static int fibonacci(int n) {
        // Complete the function.
        int[] fib = new int[3];
        fib[0]=0; fib[1]=1;
        if(n<2) return fib[n];
        for(int i = 2;i<=n;i++){
            fib[2]=fib[1]+fib[0];
            fib[0]=fib[1]; fib[1]=fib[2];
            
        }
        return fib[2];
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}

