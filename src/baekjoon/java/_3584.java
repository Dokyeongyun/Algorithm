package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/3584
 */
public class _3584 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            List<Integer>[] nodes = new ArrayList[N + 1];
            for (int i = 0; i < nodes.length; i++) {
                nodes[i] = new ArrayList<>();
            }

            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                nodes[B].add(A);
            }

            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            System.out.println(findNearestAncestor(nodes, node1, node2));
        }
    }

    static int findNearestAncestor(List<Integer>[] nodes, int node1, int node2) {
        int[] ancestors1 = new int[10001];
        findAncestors(nodes, ancestors1, node1, 1);

        int[] ancestors2 = new int[10001];
        findAncestors(nodes, ancestors2, node2, 1);

        int minValue = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 1; i < ancestors2.length; i++) {
            if (ancestors1[i] != 0 && ancestors2[i] != 0) {
                if (minValue > ancestors1[i]) {
                    minValue = Math.min(minValue, ancestors1[i]);
                    result = i;
                }
            }
        }

        return result;
    }

    static void findAncestors(List<Integer>[] nodes, int[] ancestors, int node, int numberOfAncestors) {
        ancestors[node] = numberOfAncestors;
        for (int nextNode : nodes[node]) {
            findAncestors(nodes, ancestors, nextNode, numberOfAncestors + 1);
        }
    }
}
