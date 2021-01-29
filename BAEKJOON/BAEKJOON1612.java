package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1612
 */
public class BAEKJOON1612 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N%2==0 || N%5==0){
            System.out.println(-1);
            return;
        }

        int count = 1;
        int one = 1;

        while(one % N != 0) {
            one %= N;
            one = one * 10 + 1;
            count++;
        }

        System.out.println(count);
    }
}
