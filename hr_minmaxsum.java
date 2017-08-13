import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for(int arr_i=0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        Arrays.sort(arr); int _min, _max;
        for(int i = 0; i < 4; i++){
            _min+=arr[i];
            _max+=arr[4-i];
        }
        System.out.format("%s %s/n", _min, _max);
    }
}
