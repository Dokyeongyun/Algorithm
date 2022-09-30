package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/13549
 */
public class _13549 {

    static int N, K;
    static int answer = Integer.MAX_VALUE;
    static boolean[] visit = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        BFS();
        System.out.println(answer);
    }

    static void BFS() {
        Queue<Info> que = new LinkedList<>();
        que.add(new Info(N, 0));
        visit[N] = true;

        while (!que.isEmpty()) {
            Info cur = que.poll();
            visit[cur.value] = true;

            if (cur.value == K) {
                answer = Math.min(answer, cur.sec);
            }

            if (cur.value * 2 <= 100000 && !visit[cur.value * 2]) {
                que.add(new Info(cur.value * 2, cur.sec));
            }

            if (cur.value + 1 <= 100000 && !visit[cur.value + 1]) {
                que.add(new Info(cur.value + 1, cur.sec + 1));
            }

            if (cur.value - 1 >= 0 && !visit[cur.value - 1]) {
                que.add(new Info(cur.value - 1, cur.sec + 1));
            }
        }
    }

    static class Info {
        int value;
        int sec;

        Info(int value, int sec) {
            this.value = value;
            this.sec = sec;
        }

        @Override
        public String toString() {
            return value + " " + sec;
        }
    }
}
