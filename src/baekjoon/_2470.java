package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2470
 */
public class _2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] liquids = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liquids[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liquids);

        int min = Integer.MAX_VALUE;

        int p1 = 0;
        int p2 = N - 1;

        int num1 = 0;
        int num2 = 0;

        while (p1 < p2) {
            int sum = liquids[p1] + liquids[p2];
            int abs = Math.abs(sum);

            if (abs < min) {
                min = abs;
                num1 = liquids[p1];
                num2 = liquids[p2];

                if (min == 0) {
                    break;
                }
            }

            if (sum > 0) {
                p2--;
            } else {
                p1++;
            }
        }

        System.out.println(num1 + " " + num2);
    }
}

/*
7
-2 4 -99 -1 98 1 2

6
-2 -1 -3 -4 -5 -6
 */