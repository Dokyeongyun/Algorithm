package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/12852
 */
public class _12852 {
    static Node answer;
    static int N;
    static boolean[] visit = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        BFS();
        System.out.println(answer.count);
        String[] split = answer.path.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            sb.append(split[i]).append(" ");
        }
        System.out.println(sb);
    }

    static void BFS() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(1, 0, "1"));

        while (!que.isEmpty()) {
            Node cur = que.poll();
            if (cur.value == N) {
                answer = cur;
                break;
            }

            if ((cur.value + 1 <= 1000000) && !visit[cur.value + 1]) {
                que.add(new Node(cur.value + 1, cur.count + 1, cur.path + " " + (cur.value + 1)));
                visit[cur.value + 1] = true;
            }
            if ((cur.value * 2 <= 1000000) && !visit[cur.value * 2]) {
                que.add(new Node(cur.value * 2, cur.count + 1, cur.path + " " + (cur.value * 2)));
                visit[cur.value * 2] = true;
            }
            if ((cur.value * 3 <= 1000000) && !visit[cur.value * 3]) {
                que.add(new Node(cur.value * 3, cur.count + 1, cur.path + " " + (cur.value * 3)));
                visit[cur.value * 3] = true;
            }
//            System.out.println(que);
        }
    }

    static class Node {
        int value;
        int count;
        String path;

        Node(int value, int count, String path) {
            this.value = value;
            this.count = count;
            this.path = path;
        }

        @Override
        public String toString() {
            return value + " " + path;
        }
    }
}
