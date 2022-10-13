package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2096
 */
public class _2096 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] maxDp = new int[3];
        int[] minDp = new int[3];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (i == 0) {
                maxDp[0] = minDp[0] = a;
                maxDp[1] = minDp[1] = b;
                maxDp[2] = minDp[2] = c;
            } else {
                int maxZero = maxDp[0];
                int maxTwo = maxDp[2];
                maxDp[0] = Math.max(maxDp[0], maxDp[1]) + a;
                maxDp[2] = Math.max(maxDp[1], maxDp[2]) + c;
                maxDp[1] = Math.max(Math.max(maxZero, maxDp[1]), maxTwo) + b;

                int minZero = minDp[0];
                int minTwo = minDp[2];
                minDp[0] = Math.min(minDp[0], minDp[1]) + a;
                minDp[2] = Math.min(minDp[1], minDp[2]) + c;
                minDp[1] = Math.min(Math.min(minZero, minDp[1]), minTwo) + b;
            }
        }

        int max = Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2]));
        int min = Math.min(minDp[0], Math.min(minDp[1], minDp[2]));

        System.out.println(max + " " + min);
    }
}
