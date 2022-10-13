package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1238 {

    static List<Node>[] adjacentList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        adjacentList = new ArrayList[N + 1];
        for (int i = 0; i < adjacentList.length; i++) {
            adjacentList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            adjacentList[start].add(new Node(end, time));
        }

        int[] sum = new int[N + 1];
        int[] n2x = dijkstra(X);
        for (int i = 1; i <= N; i++) {
            int[] x2n = dijkstra(i);
            sum[i] = n2x[i] + x2n[X];
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, sum[i]);
        }

        System.out.println(max);
    }

    private static int[] dijkstra(int start) {
        int[] times = new int[adjacentList.length];
        Arrays.fill(times, 987654321);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        times[start] = 0;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            for (Node nextNode : adjacentList[curNode.id]) {
                if (times[nextNode.id] >= times[curNode.id] + nextNode.time) {
                    times[nextNode.id] = times[curNode.id] + nextNode.time;
                    queue.add(new Node(nextNode.id, times[nextNode.id]));
                }
            }
        }

        System.out.println(Arrays.toString(times));
        return times;
    }

    static class Node implements Comparable<Node> {
        int id;
        int time;

        Node(int id, int time) {
            this.id = id;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(time, o.time);
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", id, time);
        }
    }
}
