package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * https://www.acmicpc.net/problem/11049
 */
public class _11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        Matrix[] arr = new Matrix[N];
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            arr[i] = new Matrix(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int length = 1; length < N; length++) {
            for (int j = 0; j < N - length; j++) {
                dp[j][j + length] = Integer.MAX_VALUE;

                for (int k = 0; k < length; k++) {
                    int value =
                            dp[j][j + k] +
                                    dp[j + k + 1][j + length] +
                                    arr[j].row * arr[j + k].col * arr[j + length].col;

                    dp[j][j + length] = Math.min(dp[j][j + length], value);
                }
            }
        }

        System.out.println(dp[0][N - 1]);
    }

    static class Matrix {
        int row;
        int col;

        Matrix(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}

