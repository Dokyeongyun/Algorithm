package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1535
 */
public class _1535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[21][101];
        int[] hp = new int[N+1];
        int[] happy = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) hp[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) happy[i] = Integer.parseInt(st.nextToken());


        dp[1][100-hp[1]] = happy[1];

        for (int i=2; i<=N; i++) {
            dp[i][100-hp[i]] = happy[i];
            for (int j=100; j>0; j--) {
                if (j+hp[i]<=100 && dp[i-1][j+hp[i]] != 0) {
                    dp[i][j] = Math.max(dp[i-1][j+hp[i]] + happy[i], dp[i-1][j]);
                } else {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                }
            }
        }

        int max = 0;
        for (int i=100; i>0; i--) {
            max = Math.max(dp[N][i], max);
        }
        System.out.println(max);

    }
}
