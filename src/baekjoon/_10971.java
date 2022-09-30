package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10971
 */
public class _10971 {
    static int N;
    static int[][] w;
    static boolean[] visit;
    static int s = 0;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        w = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            s = i;
            dfs(i, 0, 0);
        }

        System.out.println(min);
    }

    static void dfs(int p, int depth, int sum) {
        if (depth == N && s == p) {
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visit[i]) continue;
            if (w[p][i] == 0) continue;
            if (sum + w[p][i] > min) continue;
            visit[i] = true;
            dfs(i, depth + 1, sum + w[p][i]);
            visit[i] = false;
        }
    }
}
