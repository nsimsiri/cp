import java.util.*;

public class xo {
    public static class board{
        String[][] bd;
        public board(){
            bd = new String[3][3];
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    bd[i][j]="("+(i*3+j)+")";
                }
            }
        }
        public void print(){
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    System.out.print(bd[i][j] == null ? "." : bd[i][j] + "\t|\t");
                } 
                System.out.println();
            }
        }
        public void put(int x, int y, String s){
            bd[x][y] = s;
        }
       
       public boolean winner(String s){
           for(int i= 0; i<3; i++){
               if (bd[0][i].equals(s)&&bd[1][i].equals(s)&&bd[2][i].equals(s)){
                   return true;
               }
                 if (bd[i][0].equals(s)&&bd[i][1].equals(s)&&bd[i][2].equals(s)){
                   return true;
               }
           }
           return (bd[0][0].equals(s) && bd[1][1].equals(s) && bd[2][2].equals(s)) || (bd[2][0].equals(s) && bd[1][1].equals(s) && bd[0][2].equals(s));
       }
       public boolean has(int x, int y){
           return !(bd[x][y].charAt(0) == '(');
       }
        
    }
    public static void game(){
       int p = 1;
       Scanner in = new Scanner(System.in);
       board xo = new board();
       Map<Integer, String> m = new HashMap<>(); 
       m.put(1,"X"); m.put(2, "O");
        while(true){
            System.out.print("\033[H\033[2J");
            xo.print();
            System.out.format("\nPlayer %s 's turn: ", p);
           int inp = Integer.parseInt(in.nextLine());
           int x = inp/3;
           int y = inp%3;
           if(!xo.has(x,y)){
               xo.put(x,y,m.get(p));
               if(xo.winner(m.get(p))){
                    xo.print();
                   System.out.format("Player %d is the winner!\n", p);
                   break;
               }
               p = 3 - p;
           } else{
               System.out.println("try again! :( ");
           }
    
        }
        
    }
    public static void main(String[] args){
        game();
    }
}


