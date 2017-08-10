import java.util.*;

public class hr_mabsd {
    public static void main(String[] args){
        Arrays.sort(a);
        int min = Math.abs(a[0]-a[1]);
        for(int i = 0;i<n-1;i++){
            int t = Math.abs(a[i+1], a[i]);
            min = (min > t) ? t : min;
        }
        System.out.println(min);        
    }
}
