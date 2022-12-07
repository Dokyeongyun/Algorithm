package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/1563
 */
public class _1563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // DP[날짜][지각 횟수][연속으로 결석한 수]
        int[][][] dp = new int[N + 1][2][3];

        // 하루에 가능한 경우의 수 => 출석, 지각, 결석
        dp[1][0][0] = 1;
        dp[1][1][0] = 1;
        dp[1][0][1] = 1;

        for (int i = 2; i <= N; i++) {
            // 1. 지각 0회
            // 1-1. 오늘 출석 + 결석 0회 => 어제는 결석 1회 or 결석 2회
            dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % 1000000;
            // 1-2. 오늘 출석 + 결석 1회 => 어제는 결석 0회
            dp[i][0][1] = dp[i - 1][0][0] % 1000000;
            // 1-3. 오늘 출석 + 결석 2회 => 어제는 결석 1회
            dp[i][0][2] = dp[i - 1][0][1] % 1000000;
            // 2. 지각 1회
            // 2-1. 오늘 출석 + 결석 0회 => 어제는 (지각 1회 + 결석 1회) or (지각 1회 + 결석 0회)
            dp[i][1][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2] + dp[i - 1][1][0] + dp[i - 1][1][1] + dp[i - 1][1][2]) % 1000000;
            // 2-2. 오늘 출석 + 결석 1회 => 어제는 (지각 1회 + 결석 0회)
            dp[i][1][1] = dp[i - 1][1][0];
            // 2-3. 오늘 출석 + 결석 2회 => 어제는 (지각 1회 + 결석 1회)
            dp[i][1][2] = dp[i - 1][1][1];
        }

        int count = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                count += dp[N][i][j];
            }
        }
        System.out.println(count % 1000000);
    }
}
