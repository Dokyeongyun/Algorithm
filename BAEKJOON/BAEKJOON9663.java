package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/9663
 */
public class BAEKJOON9663 {

    static int N;
    static int count;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        backtracking(0);
        System.out.println(count);
    }

    static void backtracking(int d) {
        // 종료조건
        if (d == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[d] = i;
            if (isPossible(d)) {
                backtracking(d + 1);
            }
        }
    }

    static boolean isPossible(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[col] == arr[i]) return false;
            if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) return false;
        }
        return true;
    }
}
