package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/5567
 */
public class _5567 {

    static int N, M;
    static List<Integer>[] list;
    static boolean[] visit;
    static boolean[] friends;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        friends = new boolean[N + 1];

        visit[1] = true;

        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(0, 1);
        int answer = 0;
        for (int i = 2; i <= N; i++) {
            if (friends[i]) answer++;
        }

        System.out.println(answer);
    }

    static void dfs(int d, int n) {
        if (d > 2) return;

        friends[n] = true;
        for (int i : list[n]) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(d + 1, i);
                visit[i] = false;
            }
        }
    }
}
