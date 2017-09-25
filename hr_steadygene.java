import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n =Integer.parseInt(in.nextLine().trim());
        int k = n/4;
        String s = in.nextLine();
        Map<Character, Integer> mcnt = new HashMap<>();
        mcnt.put('T', 0); mcnt.put('C', 0); mcnt.put('A', 0); mcnt.put('G', 0);
        for(int i=0;i<n;i++){
            Character c = s.charAt(i);
            mcnt.put(c, mcnt.get(c)+1);
        }
        
        int val = 0;
        for(Map.Entry<Character, Integer> en : mcnt.entrySet()){
            if(en.getValue()<=k) val+= k-en.getValue(); 
        }
        //System.out.println(val);
        int i=0; int j=0;
        int cnt = n; 
        if(val==0) {
            System.out.println(0); 
        } else {
            Map<Character, Integer> mwin = new HashMap<>();
            mwin.put('A',0);mwin.put('G',0);mwin.put('C',0);mwin.put('T',0);
            while((i<n||j<n) && i>=j){
                System.out.format("%s, %s = val %s\n",i,j,val);
                if(i==n && val>0) break;
                if(val>0){
                    Character c = new Character(s.charAt(i));
                    mwin.put(c, mwin.get(c)+1);
                    if(mcnt.get(c)-mwin.get(c)>=k){
                        val--;
                    } 
                    ++i;
                } else {
                // val ==0
                    Character c = new Character(s.charAt(j));
                     mwin.put(c, mwin.get(c)-1);
                    if(mcnt.get(c)-mwin.get(c)>k){
                        val++;
                    }
                    
                    cnt = Math.min(cnt, i-j);
                    ++j;
                }
            }
            System.out.println(cnt);
        }
        
    }
}




