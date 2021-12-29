package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1987
 */
public class BAEKJOON1987 {

    static int R, C, max = 0;
    static boolean[] visit = new boolean[26];
    static int[][] board;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j) - 'A';
            }
        }

        dfs(0, 0, 0);
        System.out.println(max);
    }

    public static void dfs(int x, int y, int count) {
        if (visit[board[x][y]]) {
            max = Math.max(max, count);
        } else {
            visit[board[x][y]] = true;
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < R && nextY < C) {
                    dfs(nextX, nextY, count + 1);
                }
            }
            visit[board[x][y]] = false;
        }
    }


}
