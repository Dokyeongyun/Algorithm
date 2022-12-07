package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1707
 */
public class _1707 {

    static List<Integer>[] adjacentList;
    static int[] value;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            adjacentList = new ArrayList[V + 1];
            value = new int[V + 1];

            for (int i = 0; i < adjacentList.length; i++) {
                adjacentList[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                adjacentList[u].add(v);
                adjacentList[v].add(u);
            }

            boolean isBipartite = true;
            for (int i = 1; i < V + 1; i++) {
                if (!isBipartite) {
                    break;
                }

                if (value[i] == 0) {
                    isBipartite = bfs(i);
                }
            }

            if (isBipartite) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    private static boolean bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        value[start] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int curSetValue = value[cur];

            for (int i = 0; i < adjacentList[cur].size(); i++) {
                int adjacentNode = adjacentList[cur].get(i);
                // 아직 방문하지 않은 노드 => 현재 노드와 다른 집합으로 분류
                if (value[adjacentNode] == 0) {
                    value[adjacentNode] = curSetValue == 1 ? 2 : 1;
                    queue.add(adjacentNode);
                } else { // 이미 방문한 노드 (집합 분류된 노드) => 현재 노드와 같은 집합인지 확인
                    if (value[adjacentNode] == curSetValue) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
