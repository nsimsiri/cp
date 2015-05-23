package HackerRank.InsertionSortP2;

import java.util.Scanner;

/**
 * Created by NatchaS on 5/23/15.
 */
public class Solution {
    public static void print(int[] A){
        for (int j = 0; j < A.length; j++){
            System.out.print(A[j]+" ");
        }
        System.out.println();
    }

    public static void sort(int[] A){
        for(int i = 1; i < A.length; i++){
            int j= i;
            int key = A[i];
            boolean moved = false;
            while(j>0 && A[j-1] > key){
                moved = true;
                A[j]=A[j-1];
                j--;
            }
            A[j]=key;
            print(A);
        }
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        int[] A = new int[N];
        String[] inputs = in.nextLine().split(" ");
        for (int i = 0; i < N; i++){
            A[i] = Integer.parseInt(inputs[i]);
        }
        Solution.sort(A);
    }
}
