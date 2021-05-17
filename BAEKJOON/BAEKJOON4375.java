package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/4375
 */
public class BAEKJOON4375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                int N = Integer.parseInt(br.readLine());
                int num = 0;
                for (int i = 1; i <= N; i++) {
                    num = num * 10 + 1;
                    num %= N;
                    if (num == 0) {
                        System.out.println(i);
                        break;
                    }
                }
            } catch (Exception e) {
                break;
            }
        }
    }
}
