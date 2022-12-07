package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        int start = 1;
        int sum = 0;

        if (N <= 1) {
            System.out.println(0);
            return;
        }

        if (arr[0] > 1) {
            sum += arr[0] - 1;
            start = arr[0];
        }

        for (int i = 1; i < N; i++) {
            if (start + 1 < arr[i]) {
                sum += arr[i] - start;
                start = arr[i];
            }
            if (start + 1 == arr[i]) {
                start = arr[i];
            }
        }
        System.out.println(sum);
    }
}
