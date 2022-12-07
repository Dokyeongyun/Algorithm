package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1756
 */
public class _1756 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] depths = new int[D + 1];
        st = new StringTokenizer(br.readLine());

        depths[0] = Integer.MAX_VALUE;
        for (int i = 1; i <= D; i++) {
            depths[i] = Integer.parseInt(st.nextToken());
            depths[i] = Math.min(depths[i], depths[i - 1]);
        }

        int index = D + 1;
        int prev = 0;
        int cur = 0;
        st = new StringTokenizer(br.readLine());
        while (N-- > 0) {
            prev = cur;
            cur = Integer.parseInt(st.nextToken());

            if (index == 0) continue;

            if (cur <= prev) {
                index--;
                continue;
            }

            int min = 0;
            int mid;
            int max = index - 1;

            while (min <= max) {
                mid = (min + max) / 2;
                if (cur <= depths[mid]) {
                    index = mid;
                    min = mid + 1;
                } else {
                    max = mid - 1;
                }
            }
        }
        System.out.println(index);
    }
}
/*
7 4
5 6 4 3 6 2 3
3 2 5 5

7 7
5 6 4 3 6 2 3
3 2 6 3 4 6 5
 */