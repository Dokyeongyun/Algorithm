package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1806
 */
public class _1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(Arrays.toString(numbers));

        for (int i = 1; i <= N; i++) {
            numbers[i] += numbers[i - 1];
        }
        System.out.println(Arrays.toString(numbers));

        if(numbers[N] < S) {
            System.out.println(0);
            return;
        }
        int p1 = 0;
        int p2 = 1;
        int minLength = Integer.MAX_VALUE;
        while (p1 != p2) {
            boolean check = false;

            for (int i = p2; i <= N; i++) {
                if (numbers[i] - numbers[p1] >= S) {
                    p2 = i;
                    check = true;
                    break;
                }
            }

            if (check) {
                minLength = Math.min(minLength, p2 - p1);
            }
            p1++;
        }

        System.out.println(minLength);
    }
}
/*
10 10
1 1 1 1 1 1 1 1 1 10

10 21
11 2 5 6 8 9 2 3 10 9 10
 */