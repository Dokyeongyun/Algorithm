package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2294
 */
public class _2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] isCoinUsable = new boolean[100001];
        for (int i = 0; i < n; i++) {
            isCoinUsable[Integer.parseInt(br.readLine())] = true;
        }

        int[] dp = new int[k + 1];
        Arrays.fill(dp, 987654321);
        for (int i = 1; i <= k; i++) {
            if (isCoinUsable[i]) {
                dp[i] = 1;
            } else {
                int bigger = i - 1;
                int smaller = 1;
                while (bigger >= smaller) {
                    if (dp[bigger] == 0 || dp[smaller] == 0) {
                        continue;
                    }

                    dp[i] = Math.min(dp[i], dp[bigger] + dp[smaller]);
                    bigger--;
                    smaller++;
                }
            }
        }


        System.out.println(dp[k] == 987654321 ? -1 : dp[k]);
    }
}