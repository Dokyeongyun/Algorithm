package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2847
 */
public class BAEKJOON2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int score = Integer.parseInt(br.readLine());
            arr[i] = score;
        }

        if (n == 1) {
            System.out.print(0);
            return;
        }

        int count = 0;

        for (int i = n - 2; i >= 0; i--) {
            int high = arr[i + 1];
            int low = arr[i];

            if (low >= high) {
                count += low - (high - 1);
                arr[i] = high - 1;
            }
        }

        System.out.print(count);
    }
}
