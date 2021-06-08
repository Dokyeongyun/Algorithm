package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1446
 */
public class BAEKJOON1446 {
    static int N, D;
    static int[] distance;
    static Edge[] shortCuts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        distance = new int[D + 1];

        // 지름길을 타지 않았을 때
        for (int i = 0; i < D + 1; i++) {
            distance[i] = i;
        }

        shortCuts = new Edge[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

//            if (e - s <= l) continue;
            shortCuts[i] = new Edge(s, e, l);
        }

        dijkstra(0);
        System.out.println(distance[D]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Edge> que = new PriorityQueue<>();

        que.add(new Edge(start, 0, 0));
        distance[start] = 0;

        while (!que.isEmpty()) {
            Edge cur = que.poll();
            int curEnd = cur.end;

            for (int i = 0; i < shortCuts.length; i++) {
                int nextStart = shortCuts[i].start;
                int nextEnd = shortCuts[i].end;
                int shortCutLength = shortCuts[i].length;

                if (nextStart < curEnd) continue;
                if (nextEnd > D) continue;

                int diff = nextStart - curEnd;
                if (distance[nextEnd] > distance[curEnd] + shortCutLength + diff) {
                    distance[nextEnd] = distance[curEnd] + shortCutLength + diff;
                    que.add(new Edge(curEnd, nextEnd, distance[nextEnd]));
                }
            }

            distance[D] = Math.min(distance[curEnd] + D - curEnd, distance[D]);
        }
    }

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int length;

        Edge(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "start=" + start +
                    ", end=" + end +
                    ", length=" + length +
                    '}';
        }

        @Override
        public int compareTo(Edge o) {
            return this.length - o.length;
        }
    }
}
