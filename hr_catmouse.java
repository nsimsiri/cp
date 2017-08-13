import java.util.*;
public class hr_catmouse {
    public static void main(String[] args){
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        for(int i = 0; i < N; i++){
            String[] line = in.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);
            if (Math.abs(a-c) > Math.abs(b-c)){
                System.out.println("Cat A");
            } else if (Math.abs(a-c) < Math.abs(b-c)){
                System.out.println("Cat B");
            } else System.out.println("Mouse C");            
            
        }
    }
}
