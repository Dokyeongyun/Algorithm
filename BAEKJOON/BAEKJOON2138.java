package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2138
 */
public class BAEKJOON2138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int ans1 = 1;
        int ans2 = 0;
        int max = Integer.MAX_VALUE;
        String str1 = br.readLine();
        String str2 = br.readLine();

        int[] arr1 = new int[N];
        int[] arr2 = new int[N];
        int[] arr3 = new int[N];

        for (int i = 0; i < N; i++) {
            arr1[i] = str1.charAt(i) - '0';
            arr2[i] = str1.charAt(i) - '0';
            arr3[i] = str2.charAt(i) - '0';
        }

        arr1[0] = 1 - arr1[0];
        arr1[1] = 1 - arr1[1];

        for (int i = 1; i < N; i++) {
            if (arr1[i - 1] != arr3[i - 1]) {
                arr1[i - 1] = 1 - arr1[i - 1];
                arr1[i] = 1 - arr1[i];
                ans1++;
                if (i != N - 1) {
                    arr1[i + 1] = 1 - arr1[i + 1];
                }
            }
            if (arr2[i - 1] != arr3[i - 1]) {
                arr2[i - 1] = 1 - arr2[i - 1];
                arr2[i] = 1 - arr2[i];
                ans2++;
                if (i != N - 1) {
                    arr2[i + 1] = 1 - arr2[i + 1];
                }
            }
        }

        if (arr1[N - 1] != arr3[N - 1]) ans1 = max;
        if (arr2[N - 1] != arr3[N - 1]) ans2 = max;

        if (ans1 == max && ans2 == max) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(ans1, ans2));
        }
    }
}
