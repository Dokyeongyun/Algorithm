package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1916
 */
public class _1916 {

    static List<Node>[] adjacentNodeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        adjacentNodeList = new ArrayList[N + 1];
        for (int i = 1; i < adjacentNodeList.length; i++) {
            adjacentNodeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjacentNodeList[start].add(new Node(end, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        long[] costs = dijkstra(N, start);
        System.out.println(costs[end]);
    }

    private static long[] dijkstra(int numberOfNodes, int start) {
        boolean[] visit = new boolean[numberOfNodes + 1];
        long[] costs = new long[numberOfNodes + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        costs[start] = 0;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            if (visit[curNode.id]) {
                continue;
            }

            visit[curNode.id] = true;

            for (Node nextNode : adjacentNodeList[curNode.id]) {
                if (!visit[nextNode.id]) {
                    if (costs[nextNode.id] >= costs[curNode.id] + nextNode.cost) {
                        costs[nextNode.id] = costs[curNode.id] + nextNode.cost;
                        queue.add(new Node(nextNode.id, costs[nextNode.id]));
                    }
                }
            }
        }

        return costs;
    }

    private static class Node implements Comparable<Node> {
        int id;
        long cost;

        Node(int id, long cost) {
            this.id = id;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", id, cost);
        }
    }
}
