package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/1890
 */
public class _1890 {

    static int[][] arr;
    static long[][] dp;
    static int count = 0, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (i == N - 1 && j == N - 1) continue;

                int next = arr[i][j];
                if (i + next < N) {
                    dp[i + next][j] += dp[i][j];
                }
                if (j + next < N) {
                    dp[i][j + next] += dp[i][j];
                }
            }
        }
        System.out.println(dp[N - 1][N - 1]);

//        BFS();
//        System.out.println(count);
    }


    // BFS : 메모리초과!
    static void BFS() {
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(0, 0));

        while (!que.isEmpty()) {
            Point cur = que.poll();

            int move = arr[cur.x][cur.y];
            Point rightPoint = new Point(cur.x, cur.y + move);
            Point belowPoint = new Point(cur.x + move, cur.y);

            if (boundaryCheck(rightPoint)) {
                dp[rightPoint.x][rightPoint.y]++;
                if (rightPoint.x == N - 1 && rightPoint.y == N - 1) {
                    count++;
                } else {
                    que.add(rightPoint);
                }
            }

            if (boundaryCheck(belowPoint)) {
                dp[belowPoint.x][belowPoint.y]++;
                if (belowPoint.x == N - 1 && belowPoint.y == N - 1) {
                    count++;
                } else {
                    que.add(belowPoint);
                }
            }

            System.out.println(que);
        }
    }

    static boolean boundaryCheck(Point point) {
        return point.x >= 0 && point.x < N && point.y >= 0 && point.y < N;
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

