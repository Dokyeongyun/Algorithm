package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/14651
 */
public class BAEKJOON14651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N==1) {
            System.out.println("0");
            return;
        }

        long[] dp = new long[N + 1];
        dp[1] = 0;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i-1] * 3 % 1000000009;
        }

        System.out.println(dp[N]);
    }
}
