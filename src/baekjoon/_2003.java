package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2003
 */
public class _2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        int sp = 0;
        int ep = 0;

        int sum = 0;

        while (true) {
            if (sum >= M) {
                sum -= arr[sp];
                sp++;
            } else if (ep >= arr.length) {
                break;
            } else {
                sum += arr[ep];
                ep++;
            }

            if (sum == M) count++;
        }

        System.out.println(count);
    }
}
