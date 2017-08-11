public class hr_cupcal{
    public static void main(String[] args){
        // n and calories 
        Arrays.sort(calories);
        int s =0;
        for(int i = n-1; i >= 0;i--){
            s+= Math.pow(2, i-n-1)*calories[i];
        }
        System.out.println(s);
    }
}
