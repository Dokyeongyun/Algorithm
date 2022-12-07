package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2240
 */
public class _2240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][][] dp = new int[T + 1][W + 2][3];

        for (int i = 1; i <= T; i++) {
            int temp = Integer.parseInt(br.readLine());

            for (int j = 1; j <= W + 1; j++) {
                if (temp == 1) {
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]) + 1;
                    dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i - 1][j - 1][1]);
                } else {
                    if (i == 1 && j == 1) continue;
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]);
                    dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i - 1][j - 1][1]) + 1;
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= W + 1; i++) {
            answer = Math.max(answer, Math.max(dp[T][i][1], dp[T][i][2]));
        }

        System.out.println(answer);
    }
}
