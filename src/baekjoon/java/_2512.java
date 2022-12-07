package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2512
 */
public class _2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;
        int total = 0;
        int[] budgets = new int[N];
        for (int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, budgets[i]);
            total += budgets[i];
        }

        int M = Integer.parseInt(br.readLine());
        if (total <= M) {
            System.out.println(max);
            return;
        }

        Arrays.sort(budgets);

        int result = 0;
        int left = 0;
        int right = budgets[budgets.length - 1];
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            int sumOfBudget = 0;
            for (int budget : budgets) {
                sumOfBudget += Math.min(budget, mid);
            }

            if (sumOfBudget > M) {
                right = mid - 1;
            } else {
                left = mid + 1;
                result = mid;
            }
        }

        System.out.println(result);
    }
}
