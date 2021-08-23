package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON1965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] dp = new int[2][1001];
        int max = 0;

        for (int i = 1; i <= N; i++) {
            dp[0][i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dp[1][i] = 1;
            for (int j = 1; j < i; j++) {
                if (dp[0][j] < dp[0][i] && dp[1][i] < dp[1][j] + 1) {
                    dp[1][i] = dp[1][j] + 1;
                }
            }
            max = Math.max(max, dp[1][i]);
        }
        System.out.println(max);
    }
}
