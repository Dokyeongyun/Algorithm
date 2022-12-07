package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2252
 */
public class _2252 {

    static int[] inDegree;
    static List<Integer>[] nodes;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        inDegree = new int[N + 1];
        result = new ArrayList<>();
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
            System.out.print(integer + " ");
        }
    }

    private static void topologySort() {
        Queue<Integer> queue = new LinkedList<>();
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
            result.add(cur);

            for (int i : nodes[cur]) {
                inDegree[i] -= 1;
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }
        }
    }
}
