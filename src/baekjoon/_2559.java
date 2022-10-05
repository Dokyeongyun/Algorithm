package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2559
 */
public class _2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                arr[i] = Integer.parseInt(st.nextToken());
            } else {
                arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
            }
        }

        int max = arr[K - 1];
        for (int i = 1; i < arr.length; i++) {
            if (i + K - 1 >= arr.length) {
                break;
            }
            int sum = arr[i + K - 1] - arr[i - 1];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
