package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
https://www.acmicpc.net/problem/1448
 */
public class _1448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] straws = new int[N];
        for (int i = 0; i < N; i++) {
            straws[i] = Integer.parseInt(br.readLine());
        }

        int answer = -1;

        Arrays.sort(straws);
        for (int i = N - 1; i > 1; i--) {
            if (isTriangle(straws[i], straws[i - 1], straws[i - 2])) {
                answer = straws[i] + straws[i - 1] + straws[i - 2];
                break;
            }
        }
        System.out.println(answer);
    }
    static boolean isTriangle(int a, int b, int c) {
        return a < b + c;
    }
}
