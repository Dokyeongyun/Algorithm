package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BAEKJOON2615 {
    static int[][] map;
    static Deque<int[]> deque = new ArrayDeque();
    static int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
    static int[] dy = {-1, 1, 1, 0, -1, 1, -1, 0};
    static boolean[][][] visited = new boolean[19][19][4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[20][20];
        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1 || map[i][j] == 2) {
                    deque.add(new int[]{i, j});
                }
            }
        }

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];
                if (!isRange(nextX, nextY)) continue;
                if (!visited[nextX][nextY][i] && countFive(nextX, nextY, i, map[cur[0]][cur[1]])) {
                    if (!isRange(cur[0] + dx[i + 4], cur[1] + dy[i + 4])) {
                        System.out.println(map[cur[0]][cur[1]]);
                        System.out.print((cur[0] + 1) + " " + (cur[1] + 1));
                        return;
                    }
                    if (isRange(cur[0] + dx[i + 4], cur[1] + dy[i + 4]) && map[cur[0] + dx[i + 4]][cur[1] + dy[i + 4]] != map[nextX][nextY]) {
                        System.out.println(map[cur[0]][cur[1]]);
                        System.out.print((cur[0] + 1) + " " + (cur[1] + 1));
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }

    static boolean countFive(int x, int y, int dir, int color) {
        if (color == 0) return false;
        int cnt = 1;
        while (map[x][y] == color) {
            cnt++;
            visited[x][y][dir] = true;
            x += dx[dir];
            y += dy[dir];
        }
        return cnt == 5;
    }

    static boolean isRange(int nx, int ny) {
        return nx >= 0 && nx < 19 && ny >= 0 && ny < 19;
    }
}
