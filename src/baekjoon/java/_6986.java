package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/6986
 */
public class _6986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        double[] arr = new double[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        Arrays.sort(arr);

        double sum = 0;
        for (int i = 0; i + 2 * K < N; i++) {
            sum += arr[i + K];
        }

        System.out.printf("%.3g%n", sum / (N - 2 * K) + 1e-8);
        sum += (arr[K] + arr[N - 1 - K]) * K;
        System.out.printf("%.3g%n", sum / N + 1e-8);
    }
}
