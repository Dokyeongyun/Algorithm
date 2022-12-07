package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/13565
 */
public class _13565 {
    static int M, N;
    static int[][] map;
    static boolean result;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];

        for (int i = 0; i < M; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            if (result) {
                break;
            }

            if (map[0][i] == 0) {
                boolean[][] visited = new boolean[M][N];
                visited[0][i] = true;
                dfs(0, i, visited);
            }
        }

        System.out.println(result ? "YES" : "NO");
    }

    private static void dfs(int x, int y, boolean[][] visited) {
        if (x == (M - 1)) {
            result = true;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) {
                continue;
            }

            if (map[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                visited[nextX][nextY] = true;
                dfs(nextX, nextY, visited);
            }
        }
    }
}
