package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/13023
 */
public class _13023 {

    static List<Integer>[] friends;
    static boolean result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        friends = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            friends[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friends[a].add(b);
            friends[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            boolean[] visit = new boolean[N];
            dfs(i, visit, 0);
            if (result) {
                break;
            }
        }

        System.out.println(result ? 1 : 0);
    }

    private static void dfs(int start, boolean[] visit, int depth) {
        if (depth == 4) {
            result = true;
            return;
        }

        visit[start] = true;
        for (int friend : friends[start]) {
            if (!visit[friend]) {
                visit[friend] = true;
                dfs(friend, visit, depth + 1);
                visit[friend] = false;
            }
        }
    }
}
