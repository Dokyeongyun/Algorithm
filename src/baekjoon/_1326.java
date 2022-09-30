package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1326
 */
public class _1326 {
    static int N, a, b;
    static int[] arr;
    static boolean[] visit;
    static int count;
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        visit = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        if(a==b){
            System.out.println(0);
            return;
        }

        BFS();

        if (!check) {
            System.out.println(-1);
            return;
        }

        System.out.println(count);
    }

    static void BFS() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(a, 0));
        visit[a] = true;

        while (!que.isEmpty()) {
            Node cur = que.poll();

            if (cur.idx == b) {
                count = cur.count;
                check = true;
                break;
            }

            int mul = 1;
            while (true) {
                int nextIdx = cur.idx + arr[cur.idx] * mul;

                if (nextIdx > N) break;

                if (visit[nextIdx]) {
                    mul++;
                    continue;
                }

                que.add(new Node(nextIdx, cur.count + 1));
                visit[nextIdx] = true;
                mul++;
            }

            mul = 1;
            while (true) {
                int nextIdx = cur.idx - arr[cur.idx] * mul;

                if (nextIdx <= 0) break;

                if (visit[nextIdx]) {
                    mul++;
                    continue;
                }

                que.add(new Node(nextIdx, cur.count + 1));
                visit[nextIdx] = true;
                mul++;
            }
        }
    }

    static class Node {
        int idx;
        int count;

        Node(int idx, int count) {
            this.idx = idx;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "idx=" + idx +
                    ", count=" + count +
                    '}';
        }
    }
}
/*
10
2 1 1 2 1 1 2 1 1 2
1 10
 */