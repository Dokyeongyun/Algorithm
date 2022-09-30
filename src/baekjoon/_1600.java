package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1600
 */
public class _1600 {
    static boolean check = false;
    static int K, W, H, min = Integer.MAX_VALUE;
    static boolean[][][] visit;
    static int[][] map;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static int[] horseDx = new int[]{-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] horseDy = new int[]{-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        visit = new boolean[H][W][K + 1];
        map = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(H==1 && W==1) {
            System.out.println(0);
            return;
        }

        System.out.println(BFS());
    }

    static int BFS() {
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(0, 0, 0, 0));
        visit[0][0][0] = true;

        while (!que.isEmpty()) {
            Point cur = que.poll();

            if (cur.horseCount + 1 <= K) {
                for (int i = 0; i < 8; i++) {
                    int nextX = cur.x + horseDx[i];
                    int nextY = cur.y + horseDy[i];

                    if (!(nextX < H && nextX >= 0 && nextY < W && nextY >= 0)) continue;
                    if (map[nextX][nextY] == 1) continue;
                    if (visit[nextX][nextY][cur.horseCount + 1]) continue;

                    if (nextX == H - 1 && nextY == W - 1) {
                        min = Math.min(min, cur.count + 1);
                        check = true;
                    }

                    que.add(new Point(nextX, nextY, cur.count + 1, cur.horseCount + 1));
                    visit[nextX][nextY][cur.horseCount + 1] = true;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if (!(nextX < H && nextX >= 0 && nextY < W && nextY >= 0)) continue;
                if (map[nextX][nextY] == 1) continue;
                if (visit[nextX][nextY][cur.horseCount]) continue;

                if (nextX == H - 1 && nextY == W - 1) {
                    min = Math.min(min, cur.count + 1);
                    check = true;
                }

                que.add(new Point(nextX, nextY, cur.count + 1, cur.horseCount));
                visit[nextX][nextY][cur.horseCount] = true;

            }
        }

        if (check) {
            return min;
        }
        return -1;
    }

    static class Point {
        int x;
        int y;
        int count;
        int horseCount;

        Point(int x, int y, int count, int horseCount) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.horseCount = horseCount;
        }

        @Override
        public String toString() {
            return "(" + x + " " + y + " " + count + " " + horseCount + ")";
        }
    }
}
