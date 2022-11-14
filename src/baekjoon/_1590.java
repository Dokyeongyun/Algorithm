package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1590
 */
public class _1590 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int nextBus = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int I = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            for (int j = 0; j < C; j++) {
                int temp = S + I * j;
                if (temp < T) {
                    continue;
                }
                nextBus = Math.min(nextBus, temp);
            }
        }

        System.out.println(nextBus == Integer.MAX_VALUE ? -1 : nextBus - T);
    }
}