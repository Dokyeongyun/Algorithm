package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/1527
 */
public class BAEKJOON1527 {
    static int A, B;
    static long count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        solve(4);
        solve(7);

        System.out.println(count);
    }

    static void solve(long num) {
        if (num > B) return;
        if (A <= num && num <= B) count++;
        solve(num*10 + 4);
        solve(num*10 + 7);
    }
}
