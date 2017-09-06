import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class MyQueue {
        Stack<Integer> enq = new Stack<>();
        Stack<Integer> deq = new Stack<>();
        boolean isenq=true;
        public MyQueue(){
        }
        private void swap(Stack from, Stack to){
            while(!from.isEmpty()){
                to.push(from.pop());
            }
        }
        public void enqueue(int x){
            enq.push(x);
            }
        public Integer dequeue(){
            if(deq.isEmpty()){
                swap(enq,deq);
            }
            if(deq.isEmpty()) return null;
            return deq.pop();
        }
        public int peek(){
            if(deq.isEmpty()){
                swap(enq,deq);
            }
            return deq.peek();
        } 

    }
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

