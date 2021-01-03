package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BAEKJOON5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            String[] fnArr = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());
            String arrString = br.readLine();
            String[] arr = arrString.substring(1, arrString.length()-1).split(",");

            Deque<Integer> deque = new LinkedList<>();
            for (String s : arr) {
                if(!arrString.equals("[]")){
                    deque.add(Integer.parseInt(s));
                }
            }

            boolean exit = false;
            boolean reverse = false;
            for (String fn : fnArr) {
                switch (fn) {
                    case "R":
                        reverse = !reverse;
                        break;
                    case "D":
                        if(deque.size()==0){
                            exit = true;
                            break;
                        }
                        if(reverse){
                            deque.pollLast();
                        }else{
                            deque.pollFirst();
                        }
                        break;
                }
                if (exit) {
                    break;
                }
            }
            if(exit){
                System.out.println("error");
            }else{
                print(deque, reverse);
            }
        }
    }
    static void print(Deque<Integer> deque, boolean reverse){
        int size = deque.size();
        if(size==0){
            System.out.println("[]");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0; i<size-1; i++) {
            if (reverse) {
                sb.append(deque.pollLast()).append(",");
            }else{
                sb.append(deque.pollFirst()).append(",");
            }
        }
            sb.append(deque.pollFirst()).append("]");
        System.out.println(sb);
    }
}
