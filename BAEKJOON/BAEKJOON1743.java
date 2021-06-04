package BAEKJOON;

/**
 * https://www.acmicpc.net/problem/1743
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BAEKJOON1743 {
    static int N, M;
    static String[][] map;
    static boolean[][] isVisited;
    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};
    static int biggestGarbage = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new String[N + 1][M + 1];
        isVisited = new boolean[N + 1][M + 1];

        for(int i=0; i<N+1; i++){
            Arrays.fill(map[i], "-");
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = "#";
        }


        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                if (!isVisited[i][j] && map[i][j].equals("#")) {
                    biggestGarbage = Math.max(biggestGarbage, BFS(i, j));
                }
            }
        }
        System.out.println(biggestGarbage);
    }


    static int BFS(int r, int c) {
        int count = 0;
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(r, c));

        while (!que.isEmpty()) {
            Point cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];

                if (nextR <= 0 || nextR >= N + 1 || nextC <= 0 || nextC >= M + 1) continue;
                if (isVisited[nextR][nextC]) continue;
                if (!map[nextR][nextC].equals("#")) continue;

                que.add(new Point(nextR, nextC));
                isVisited[nextR][nextC] = true;
                count++;
            }
        }
        return count;
    }


    static class Point {
        int r;
        int c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
