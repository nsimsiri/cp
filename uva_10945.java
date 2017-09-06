import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s;
        while(!(s=in.nextLine()).equals("DONE")){
            StringBuffer sb = new StringBuffer();
            String[] lines = s.split(" ");
            for(int i=0;i<lines.length;i++){
                sb.append(lines[i]);
            }
            StringBuffer sb2 = new StringBuffer();
            s=sb.toString();
            for(int i=0;i<sb.toString().length();i++){
                char cc = Character.toString(s.charAt(i)).toLowerCase().charAt(0);
                int cci = (int)cc;
                if (cci>=97 && cci<97+26){
                    sb2.append(cc);
                }
                
            }
            s=sb2.toString();
            boolean ispal=true;
            for(int i=0;i<s.length()/2 && s.length()>1;i++){
                String a = Character.toString(s.charAt(i));
                String b = Character.toString(s.charAt(s.length()-1-i));
                if(!a.equals(b)){
                    ispal=false;
                    break;
                }
            }
            if(ispal){
                System.out.println("You won't be eaten!");
            } else{
                System.out.println("Uh oh..");
            }
        }
    }
}
