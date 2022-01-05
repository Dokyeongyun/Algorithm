package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14501
 */
public class BAEKJOON14501 {

    static int N;
    static int max = 0;
    static int[] tArr;
    static int[] pArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        tArr = new int[N];
        pArr = new int[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            tArr[i] = Integer.parseInt(st.nextToken());
            pArr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            if (i + tArr[i] <= N) {
                dp[i + tArr[i]] = Math.max(dp[i + tArr[i]], dp[i] + pArr[i]);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }
        System.out.println(dp[N]);
    }
}