package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1629
 */
public class _1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(cal(A, B, C) % C);
    }

    static long cal(long a, long b, long c) {
        if (b == 0) {
            return 1;
        } else if (b == 1) {
            return a;
        } else if (b % 2 == 0) {
            long n = cal(a, b / 2, c) % c;
            return (n * n) % c;
        } else {
            long n = cal(a, b / 2, c) % c;
            return (((n * n) % c) * a) % c;
        }
    }
}
