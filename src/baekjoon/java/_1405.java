package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1405
 */
public class _1405 {

    static boolean[][] visit = new boolean[29][29];
    static int n;
    static double percentage = 0;
    static double E, W, S, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        E = Double.parseDouble(st.nextToken()) / 100;
        W = Double.parseDouble(st.nextToken()) / 100;
        S = Double.parseDouble(st.nextToken()) / 100;
        N = Double.parseDouble(st.nextToken()) / 100;

        // 처음 위치 14, 14
        visit[14][14] = true;
        dfs(14, 14, 0, -1, 1);
        System.out.println(percentage);
    }

    static void dfs(int x, int y, int d, int direction, double per) {
//        for (int i = 0; i < d; i++) { System.out.print("\t"); }
//        System.out.println(x + " " + y + " " + d + " " + direction + " " + per);
        if (d == n) {
            percentage += per;
//            System.out.println(percentage);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (direction == 0 && i == 1) continue;
            if (direction == 1 && i == 0) continue;
            if (direction == 2 && i == 3) continue;
            if (direction == 3 && i == 2) continue;
            if (i == 0 && !visit[x][y + 1]) {
                visit[x][y + 1] = true;
                dfs(x, y + 1, d + 1, i, per * E);
                visit[x][y + 1] = false;
            } else if (i == 1 && !visit[x][y - 1]) {
                visit[x][y - 1] = true;
                dfs(x, y - 1, d + 1, i, per * W);
                visit[x][y - 1] = false;
            } else if (i == 2 && !visit[x + 1][y]) {
                visit[x + 1][y] = true;
                dfs(x + 1, y, d + 1, i, per * S);
                visit[x + 1][y] = false;
            } else if (i == 3 && !visit[x - 1][y]) {
                visit[x - 1][y] = true;
                dfs(x - 1, y, d + 1, i, per * N);
                visit[x - 1][y] = false;
            }
        }
    }
}
