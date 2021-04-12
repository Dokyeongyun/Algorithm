package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/1303
 */
public class BAEKJOON1303 {
    static String[][] soldier;
    static boolean[][] visit;
    static int N, M, bSum = 0, wSum = 0;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        soldier = new String[M][N];
        visit = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                soldier[i][j] = split[j];
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    if (soldier[i][j].equals("B")) {
                        bSum += Math.pow(BFS(i, j), 2);
                    } else {
                        wSum += Math.pow(BFS(i, j), 2);
                    }
                }
            }
        }

        System.out.println(wSum+" "+bSum);
    }

    static int BFS(int x, int y) {
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(x, y));
        visit[x][y] = true;
        int count = 1;

        while (!que.isEmpty()) {
            Point cur = que.poll();
            int curX = cur.x;
            int curY = cur.y;
            String curSoldier = soldier[curX][curY];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) continue;
                if (visit[nextX][nextY]) continue;

                String nextSoldier = soldier[nextX][nextY];
                if (curSoldier.equals(nextSoldier)) {
                    que.add(new Point(nextX, nextY));
                    visit[nextX][nextY] = true;
                    count++;
                }
            }
        }
        return count;
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
