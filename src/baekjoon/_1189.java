package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1189 {

    static int R, C, K;
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, -1, 0};
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        visit[R-1][0] = true;
        backtracking(R - 1, 0, 1);

        System.out.println(count);
    }

    static void backtracking(int x, int y, int distance) {
        if (x == 0 && y == C - 1) {
            if (distance == K) {
                count++;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) continue;
            if (map[nextX][nextY] == 'T') continue;
            if (visit[nextX][nextY]) continue;

            visit[nextX][nextY] = true;
            backtracking(nextX, nextY, distance + 1);
            visit[nextX][nextY] = false;
        }
    }
}

