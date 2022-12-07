package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/3273
 */
public class _3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int X = Integer.parseInt(br.readLine());

        Arrays.sort(numbers);

        int p1 = 0;
        int p2 = N - 1;
        int count = 0;
        while (p1 < p2) {
            int sum = numbers[p1] + numbers[p2];
            if (sum > X) {
                p2--;
            } else if (sum == X) {
                count++;
                p1++;
                p2--;
            } else if (sum < X) {
                p1++;
            }
        }
        System.out.println(count);

        // 1 2 3 4 5 9 10 13 14 19 20
        // 합이 14
        // 1 / 13
        //
    }
}
