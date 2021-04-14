package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEKJOON1865 {

    static final int INF = 987654321;
    static int N, M, W;
    static ArrayList<Edge>[] list;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            list = new ArrayList[N + 1];
            for (int i = 1; i < N + 1; i++) list[i] = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                list[start].add(new Edge(end, cost));
                list[end].add(new Edge(start, cost));
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                list[start].add(new Edge(end, -cost));
            }

            boolean check = false;
            for (int i = 1; i < N + 1; i++) {
                if (bellmanFord(i)) {
                    check = true;
                    sb.append("YES\n");
                    break;
                }
            }
            if(!check){
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean bellmanFord(int start) {
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        boolean update = false;

        for (int i = 1; i < N; i++) {
            update = false;

            for (int j = 1; j < N + 1; j++) {
                for (Edge edge : list[j]) {
                    if (dist[j] != INF && dist[edge.v] > dist[j] + edge.w) {
                        dist[edge.v] = dist[j] + edge.w;
                        update = true;
                    }
                }
            }
            if (!update) break;
        }

        if (update) {
            for (int i = 1; i < N + 1; i++) {
                for (Edge edge : list[i]) {
                    if (dist[i] != INF && dist[edge.v] > dist[i] + edge.w) return true;
                }
            }
        }

        return false;
    }

    static class Edge {
        int v, w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}