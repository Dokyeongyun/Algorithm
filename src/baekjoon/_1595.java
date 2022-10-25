package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1595
 */
public class _1595 {

    static List<Node>[] nodes;

    static int maxIndex = 0;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = 0;
        List<Edge> edges = new ArrayList<>();
        while (true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) {
                break;
            }

            StringTokenizer st = new StringTokenizer(line);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            size = Math.max(size, start);
            size = Math.max(size, end);
            edges.add(new Edge(start, end, distance));
        }

        if (size == 0) {
            System.out.println(0);
            return;
        }

        nodes = new ArrayList[size + 1];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (Edge edge : edges) {
            nodes[edge.start].add(new Node(edge.end, edge.distance));
            nodes[edge.end].add(new Node(edge.start, edge.distance));
        }

        boolean[] visited = new boolean[nodes.length];
        visited[1] = true;
        dfs(1, 0, visited);

        visited = new boolean[nodes.length];
        visited[maxIndex] = true;
        max = Integer.MIN_VALUE;
        dfs(maxIndex, 0, visited);

        System.out.println(max);
    }

    private static void dfs(int start, int sumOfDistance, boolean[] visited) {
        if (max < sumOfDistance) {
            max = sumOfDistance;
            maxIndex = start;
        }

        for (Node next : nodes[start]) {
            if (!visited[next.destination]) {
                visited[next.destination] = true;

                dfs(next.destination, sumOfDistance + next.distance, visited);
                visited[next.destination] = false;
            }
        }
    }

    static class Node {
        int destination;
        int distance;

        public Node(int destination, int distance) {
            this.destination = destination;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", destination, distance);
        }
    }

    static class Edge {
        int start;
        int end;
        int distance;

        public Edge(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d, %d)", start, end, distance);
        }
    }
}
