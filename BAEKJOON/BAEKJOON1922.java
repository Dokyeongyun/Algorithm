package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/1922
 */
public class BAEKJOON1922 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        PriorityQueue<Edge> que = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            que.add(new Edge(start, end, weight));
        }

        int min = 0;
        while (!que.isEmpty()) {
            Edge curEdge = que.poll();

            int parentOfStartNode = findParent(curEdge.start);
            int parentOfEndNode = findParent(curEdge.end);

            if (parentOfStartNode == parentOfEndNode) continue;

            parent[parentOfEndNode] = parentOfStartNode;
            min += curEdge.weight;
        }
        System.out.println(min);
    }

    static int findParent(int num) {
        if (parent[num] == num) return num;
        return parent[num] = findParent(parent[num]);
    }

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;

        Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
