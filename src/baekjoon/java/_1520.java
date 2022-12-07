package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
https://www.acmicpc.net/problem/1520
 */
public class _1520 {
    static int[][] arr;
    static int[][] dp;
    static boolean[][] visit;
    static int M, N;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        dp = new int[M][N];
        visit = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        BFS();
        System.out.println(dp[M-1][N-1]);
    }

    static void BFS() {
        PriorityQueue<Point> que = new PriorityQueue<>();
        que.add(new Point(0, 0));
        dp[0][0] = 1;

        while (!que.isEmpty()) {
            Point cur = que.poll();
            int curX = cur.x;
            int curY = cur.y;
            int curHeight = arr[curX][curY];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX >= M || nextX < 0 || nextY >= N || nextY < 0) continue;

                int nextHeight = arr[nextX][nextY];
                if (curHeight <= nextHeight) continue;
                dp[nextX][nextY] += dp[curX][curY];
                if (visit[nextX][nextY]) continue;

                visit[nextX][nextY] = true;
                que.add(new Point(nextX, nextY));
            }
        }
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int h;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.h = arr[x][y];
        }

        @Override
        public String toString() {
            return x + " " + y;
        }

        @Override
        public int compareTo(Point o) {
            return o.h - this.h;
        }
    }
}
