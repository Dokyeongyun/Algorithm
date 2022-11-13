package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14002
 */
public class _14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N + 1];
        int[] dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = 1;
        int lisLength = 1;
        for (int i = 2; i < N + 1; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (numbers[i] > numbers[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
            lisLength = Math.max(lisLength, dp[i]);
        }

        int index = lisLength;
        Stack<Integer> stack = new Stack<>();
        for (int i = N; i > 0; i--) {
            if (index == dp[i]) {
                stack.push(numbers[i]);
                index--;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(lisLength);
        System.out.println(sb);
    }

}
