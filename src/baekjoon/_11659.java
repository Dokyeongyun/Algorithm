package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/11659
 */
public class _11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dp = new int[N+1];
        st = new StringTokenizer(br.readLine());
        dp[1] = Integer.parseInt(st.nextToken());
        for (int i = 2; i < N+1; i++) dp[i] = dp[i - 1] + Integer.parseInt(st.nextToken());

        System.out.println(Arrays.toString(dp));
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken());
            System.out.println(dp[end] - dp[start]);
        }
    }
}
