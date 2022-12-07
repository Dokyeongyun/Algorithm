package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
https://www.acmicpc.net/problem/1174
 */
public class _1174 {
    static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if(N > 1023){
            System.out.println(-1);
            return;
        }

        for(int i=0; i<10; i++) {
            getDecreaseNum(i);
        }
        Collections.sort(list);
        System.out.println(list.get(N-1));
    }

    static void getDecreaseNum(long num){
        list.add(num);
        for(int i=0; i<10; i++) {
            if(num%10 > i) {
                getDecreaseNum((num*10)+i);
            }
        }
    }
}
