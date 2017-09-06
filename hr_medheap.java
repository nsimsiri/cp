import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
    public static class mmheap {
        int[] heap;
        int com;
        int head = -1;
        public mmheap(int n, int com){
           int k = (int) Math.pow(2,Math.ceil(Math.log(n)/Math.log(2)));
           this.com=com;
           heap = new int[k];
        }
        public int p(int x){ return x >> 1; }
        public int l(int x){ return x==0 ? 1 : x << 1; }
        public int r(int x){ return x==0 ? 2 : (x << 1)+1; }
        public int pop(){
            if(head == -1) throw new IllegalArgumentException();
            int res = heap[0];
            int cur = 0;
            while(cur<head){
                int l = l(cur);
                int r = r(cur);
                Integer li = new Integer(heap[l]);
                Integer ri = new Integer(heap[r]);
                if(l==head){
                    heap[cur]=heap[l];
                    heap[l] = 0;
                    cur=l;
                } else if(r <= head){
                    if (ri.compareTo(li)==com){
                        heap[cur]=ri;
                        cur=r;
                    } else {
                        heap[cur]=li;
                        cur=l;
                    }
                    heap[cur]=0;
                } else break;
            }
            if(cur!=head){
                heap[cur]=heap[head--];
                fixheap(cur);
            } else heap[head--]=0;
            
            return res;
        }
        public void add(int x){
            heap[++head] = x;
            fixheap(head);
        }
        private void fixheap(int head){
            int cur = head;
            if(head==-1) return;
            while(cur!=0){
                Integer a = new Integer(heap[cur]);
                int pp = p(cur);
                Integer b = new Integer(heap[pp]);
                if(a.compareTo(b)==com){
                    heap[cur] = b;
                    heap[pp] = a;
                }
                cur=pp;
            }
        }
        public int size(){
            return head+1;
        }
        public int peek(){
            return heap[0];
        }
         
        @Override
        public String toString(){ return Arrays.toString(heap) + "_ " + head; }
        
    }

    public static void main(String[] args) {
        /*mmheap m = new mmheap(10, 1);
        for(int i=0;i<10;i++) m.add(i);
        System.out.println(m);
        for(int i=0;i<10;i++){
            System.out.format("%s %s\n", m.pop(), m);
        }*/
   
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        mmheap minh = new mmheap(n, -1);
        mmheap maxh = new mmheap(n, 1);
        for(int a_i=0; a_i < n; a_i++){
            int x = in.nextInt();
            if (minh.size() < maxh.size()){
                if(x < maxh.peek()){
                    minh.add(maxh.pop());
                    maxh.add(x);
                } else {
                    minh.add(x);
                }
            } else if (minh.size() > maxh.size()){
                if(minh.peek() < x){
                    maxh.add(minh.pop());
                    minh.add(x);
                } else maxh.add(x);
            } else {
                if(maxh.peek() > x) maxh.add(x);
                else minh.add(x);
            }
            if(minh.size() > maxh.size()){
                System.out.format("%.1f\n", (float)minh.peek());
            } else if (minh.size() < maxh.size()){
                System.out.format("%.1f\n", (float)maxh.peek());
            } else System.out.format("%.1f\n", (float)(minh.peek()+maxh.peek())/2);
            //System.out.println(maxh);
            //System.out.println(minh);
        }
    }
}


