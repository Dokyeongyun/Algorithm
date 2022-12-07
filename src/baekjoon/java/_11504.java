package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11054
 */
public class _11504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        int[] dp = new int[N];
        int[] dp2 = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i = numbers.length - 1; i >= 0; i--) {
            dp2[i] = 1;
            for (int j = numbers.length - 1; j > i; j--) {
                if (numbers[j] < numbers[i]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i] + dp2[i]);
        }

        System.out.println(max - 1);
    }
}
