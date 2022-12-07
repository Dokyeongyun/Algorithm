package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11437
 */
public class _11437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Integer>[] nodes = new ArrayList[N + 1];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            nodes[n1].add(n2);
            nodes[n2].add(n1);
        }

        int[] depths = new int[N + 1];
        int[] parents = new int[N + 1];
        traversal(nodes, depths, parents, 1, 1);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            System.out.println(findNearestCommonAncestor(depths, parents, n1, n2));
        }
    }

    static int findNearestCommonAncestor(int[] depths, int[] parents, int node1, int node2) {

        int depthOfNode1 = depths[node1];
        int depthOfNode2 = depths[node2];

        while (depthOfNode1 > depthOfNode2) {
            node1 = parents[node1];
            depthOfNode1--;
        }
        while (depthOfNode1 < depthOfNode2) {
            node2 = parents[node2];
            depthOfNode2--;
        }

        while (node1 != node2) {
            node1 = parents[node1];
            node2 = parents[node2];
        }

        return node1;
    }

    static void traversal(List<Integer>[] nodes, int[] depths, int[] parents, int node, int depth) {
        depths[node] = depth;
        for (int nextNode : nodes[node]) {
            if (depths[nextNode] == 0) {
                parents[nextNode] = node;
                traversal(nodes, depths, parents, nextNode, depth + 1);
            }
        }
    }
}
