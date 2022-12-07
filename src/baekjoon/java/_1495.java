package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/1495
 */
public class _1495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] v = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < v.length; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][M + 1];

        //첫번째 곡은 초기 볼륨을 이용해 먼저 계산
        if (S + v[0] <= M) dp[0][S + v[0]] = 1;
        if (S - v[0] >= 0) dp[0][S - v[0]] = 1;


        for (int i = 1; i < N; i++) {
            int changeVol = v[i];
            int prev = i - 1;
            for (int j = 0; j <= M; j++) {
                if (dp[prev][j] == 1) {
                    if (j + changeVol <= M) dp[i][j + changeVol] = 1;
                    if (j - changeVol >= 0) dp[i][j - changeVol] = 1;
                }
            }
        }

        int answer = -1;
        for (int i = M; i >= 0; i--) {
            if (dp[N - 1][i] == 1) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
