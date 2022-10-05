package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1766
 */
public class _1766 {

    static int[] inDegree;
    static int[] result;
    static List<Integer>[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        inDegree = new int[N + 1];
        result = new int[N + 1];
        nodes = new ArrayList[N + 1];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            nodes[A].add(B);
            inDegree[B]++;
        }

        topologySort();
        for (Integer integer : result) {
            if (integer == 0) {
                continue;
            }
            System.out.print(integer + " ");
        }
    }

    private static void topologySort() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        for (int j = 1; j < inDegree.length; j++) {
            if (queue.peek() == null) {
                break;
            }

            int cur = queue.poll();
            result[j] = cur;

            for (int i : nodes[cur]) {
                inDegree[i] -= 1;
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }
        }
    }
}
