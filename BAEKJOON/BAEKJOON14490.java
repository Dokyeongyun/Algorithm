package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/14490
 */
public class BAEKJOON14490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(":");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int gcd = gcd(Math.max(N, M), Math.min(N, M));

        System.out.println(N / gcd + ":" + M / gcd);
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
