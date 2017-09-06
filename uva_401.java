import java.util.*;
class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Map<String,String> m = new HashMap<>();
        m.put("A","A"); m.put("E","3"); m.put("H","H");
        m.put("J","L"); m.put("M","M"); m.put("O","O");
        m.put("S","2"); m.put("T","T"); m.put("U","U");
        m.put("V","V"); m.put("X","X"); m.put("W","W");
        m.put("Y","Y"); m.put("Z","5"); m.put("8","8");
        m.put("1","1"); m.put("I","I");
        /*
        Iterator<Map.Entry<String,String>> itr = m.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry<String,String> en = itr.next();
            m.put(en.getValue(),en.getKey());
        }*/
        
        for(String key : new HashSet<String>(m.keySet())){
            m.put(m.get(key),key);
        }
        while(in.hasNextLine()){
            String s = in.nextLine();
            int n = s.length();
            if(n==0) break;
            if(n==1){
               if(!m.getOrDefault(s,"").equals(s)) System.out.format("%s -- is a regular palindrome.\n\n", s);
               else System.out.format("%s -- is a mirrored palindrome.\n\n", s);
               continue;
            }
            boolean ispal=true;
            boolean ismir=true;
            for(int i=0; i<n/2; i++){
                String a = Character.toString(s.charAt(i));
                String b = Character.toString(s.charAt(n-1-i));
                if(!a.equals(b) && ispal){
                    ispal=false;
                }
                if(!a.equals(m.get(b)) && ismir){
                    ismir=false;
                }
                if(!ispal && !ismir){
                    System.out.format("%s -- is not a palindrome.\n\n", s);
                    break;
                }
            }
            if(ismir && n%2==1){
                String x = Character.toString(s.charAt(n/2));
                ismir = m.getOrDefault(x,"").equals(x);
            }
            if(ispal && ismir){
                System.out.format("%s -- is a mirrored palindrome.\n\n", s);
            } else if (ispal && !ismir){
                System.out.format("%s -- is a regular palindrome.\n\n", s);
            } else if (!ispal && ismir){
                System.out.format("%s -- is a mirrored string.\n\n", s);
            }
        }
    }
}
