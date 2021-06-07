package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1388
 */
public class BAEKJOON1388 {
    static int N, M;
    static String[][] arr;
    static boolean[][] visit;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new String[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = split[j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j]) {
                    BFS(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static void BFS(int x, int y) {
        String s = arr[x][y];

        Queue<Point> que = new LinkedList<>();
        que.add(new Point(x, y));

        while (!que.isEmpty()) {
            Point cur = que.poll();

            if (s.equals("-")) {
                int i = 1;
                while (true) {
                    int nextY = cur.y + i;
                    if (nextY >= M) break;
                    if (!arr[x][nextY].equals("-")) break;
                    if (visit[x][nextY]) break;

                    que.add(new Point(x, nextY));
                    visit[x][nextY] = true;
                }
            }

            if (s.equals("|")) {
                int i = 1;
                while (true) {
                    int nextX = cur.x + i;
                    if (nextX >= N) break;
                    if (!arr[nextX][y].equals("|")) break;
                    if (visit[nextX][y]) break;

                    que.add(new Point(nextX, y));
                    visit[nextX][y] = true;
                }
            }
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
