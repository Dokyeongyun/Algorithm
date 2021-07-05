package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/9507
 */
public class BAEKJOON9507 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        long[] dp = new long[69];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4; i<68; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3] + dp[i-4];
        }

        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }

    }
}
