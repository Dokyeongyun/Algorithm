package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/1926
 */
public class _1926 {

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count;
    static int tmp_square;
    static List<Integer> square = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] k = br.readLine().split(" ");
        N = Integer.parseInt(k[0]);
        M = Integer.parseInt(k[1]);

        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    tmp_square = 1;
                    dfs(i, j);
                    count++;
                    square.add(tmp_square);
                }
            }
        }

        System.out.println(count);
        try {
            System.out.println(Collections.max(square));
        } catch (Exception e) {
            System.out.println(0);
        }

    }

    static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];


            if (!(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)) {
                if (map[nextX][nextY] == 1) {
                    if (!visit[nextX][nextY]) {
                        tmp_square++;
                        dfs(nextX, nextY);
                    }
                }
            }
        }
    }
}

