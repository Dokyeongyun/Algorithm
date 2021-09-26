package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1652
 */
public class BAEKJOON1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[][] room = new String[N][N];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                room[i][j] = split[j];
            }
        }

        int horizontalCount = 0;
        int verticalCount = 0;
        for (int i = 0; i < N; i++) {
            int hTemp = 0;
            int vTemp = 0;
            for (int j = 0; j < N; j++) {
                if (room[i][j].equals(".")) hTemp++;
                if (room[i][j].equals("X") || (j == N - 1)) {
                    if (hTemp >= 2) horizontalCount++;
                    hTemp = 0;
                }

                if (room[j][i].equals(".")) vTemp++;
                if (room[j][i].equals("X") || (j == N - 1)) {
                    if (vTemp >= 2) verticalCount++;
                    vTemp = 0;
                }
            }
        }
        System.out.println(horizontalCount + " " + verticalCount);
    }
}
