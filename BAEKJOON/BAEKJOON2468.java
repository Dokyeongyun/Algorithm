package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2468
 */
public class BAEKJOON2468 {

    static int N, max = 1, count;
    static int[][] map;
    static int[][] tempMap;
    static boolean[][] visit;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < 101; i++) {
            tempMap = new int[N][N];
            count = 0;
            visit = new boolean[N][N];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] <= i) {
                        tempMap[j][k] = 0;
                    } else {
                        tempMap[j][k] = 1;
                    }
                }
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (tempMap[j][k] == 1 && !visit[j][k]) {
                        goSearch(j, k);
                        count++;
                    }
                }
            }

            max = Math.max(max, count);
        }
        System.out.println(max);
    }

    static void goSearch(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                if (tempMap[nextX][nextY] == 1 && !visit[nextX][nextY]) {
                    goSearch(nextX, nextY);
                }
            }
        }
    }
}
