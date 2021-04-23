package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/3036
 */
public class BAEKJOON3036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int firstRing = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            int ring = Integer.parseInt(st.nextToken());
            int bigger = Math.max(firstRing, ring);
            int smaller = Math.min(firstRing, ring);
            int gcd = getGCD(bigger, smaller);

            System.out.println(firstRing/gcd+"/"+ring/gcd);
        }
    }

    static int getGCD(int a, int b) {
        while (b > 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
}
