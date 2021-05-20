package BAEKJOON;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2502
 */
public class BAEKJOON2502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (D == 3) {
            System.out.println(1);
            System.out.println(K - 1);
            return;
        }

        int[] arr1 = new int[D + 1];
        int[] arr2 = new int[D + 1];

        arr1[3] = arr2[3] = 1;
        arr1[4] = 1;
        arr2[4] = 2;

        for (int i = 5; i <= D; i++) {
            arr1[i] = arr1[i - 1] + arr1[i - 2];
            arr2[i] = arr2[i - 1] + arr2[i - 2];
        }

        int first;
        int second;

        for (int i = 1; ; i++) {
            int result = K - arr1[D] * i;

            if (result % arr2[D] == 0) {
                first = i;
                second = result / arr2[D];
                break;
            }

        }

        sb.append(first).append("\n").append(second).append("\n");
        System.out.println(sb);
    }
}
