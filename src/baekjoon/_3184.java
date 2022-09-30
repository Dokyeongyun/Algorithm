package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/3184
 */
public class _3184 {

    static int R, C;
    static char[][] map;
    static boolean[][] visit;
    static int sheepCount = 0, wolfCount = 0;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                map[i][j] = temp[j].charAt(0);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visit[i][j] && map[i][j] != '#') {
                    BFS(i, j);
                }
            }
        }
        System.out.println(sheepCount + " " + wolfCount);
    }

    static void BFS(int x, int y) {
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(x, y));
        visit[x][y] = true;

        int sheep = 0;
        int wolf = 0;

        while (!que.isEmpty()) {
            Point cur = que.poll();

            if (map[cur.x][cur.y] == 'o') sheep++;
            if (map[cur.x][cur.y] == 'v') wolf++;
            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) continue;
                if (visit[nextX][nextY]) continue;
                if (map[nextX][nextY] == '#') continue;

                que.add(new Point(nextX, nextY));
                visit[nextX][nextY] = true;
            }
        }

        if (sheep > wolf) {
            sheepCount += sheep;
        } else {
            wolfCount += wolf;
        }
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

}
