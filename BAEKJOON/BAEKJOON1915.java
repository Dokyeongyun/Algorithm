package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1915
 */
public class BAEKJOON1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int[][] dp = new int[N][M];
        int size = 0;

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(split[j]);

                if (arr[i][j] == 1) {
                    dp[i][j] = 1;
                    size = 1;
                }
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (arr[i - 1][j] == 1 && arr[i - 1][j - 1] == 1 && arr[i][j - 1] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]) + 1;
                }
                size = Math.max(dp[i][j], size);
            }
        }

        System.out.println(size*size);
    }
}
