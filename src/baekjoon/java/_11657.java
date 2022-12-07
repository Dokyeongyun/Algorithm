package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11657
 */
public class _11657 {

    static int N, M;
    static final int INFINITY = 100000000;
    static List<Node>[] nodes;
    static long[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            nodes[A].add(new Node(B, C));
        }

        if (bellmanFord()) {
            for (int i = 2; i < N + 1; i++) {
                if (distance[i] == INFINITY) {
                    System.out.println("-1");
                } else {
                    System.out.println(distance[i]);
                }
            }
        } else {
            System.out.println("-1");
        }
    }

    private static boolean bellmanFord() {
        int startNode = 1;

        distance = new long[N + 1];
        Arrays.fill(distance, INFINITY);
        distance[startNode] = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N + 1; j++) {
                for (Node next : nodes[j]) {
                    if (distance[j] == INFINITY) {
                        continue;
                    }
                    distance[next.id] = Math.min(distance[next.id], distance[j] + next.weight);
                }
            }
        }

        for (int j = 1; j < N + 1; j++) {
            for (Node next : nodes[j]) {
                if (distance[j] == INFINITY) {
                    continue;
                }
                if (distance[next.id] > distance[j] + next.weight) {
                    return false;
                }
            }
        }

        return true;
    }

    static class Node {
        int id;
        int weight;

        Node(int id, int weight) {
            this.id = id;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return String.format("(%s, %s)", id, weight);
        }
    }
}
