package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/24444
 */
public class _24444 {

    static List<Integer>[] adjacentList;
    static int[] visit;
    static int visitOrder = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        adjacentList = new ArrayList[N + 1];
        visit = new int[N + 1];

        for (int i = 0; i < adjacentList.length; i++) {
            adjacentList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjacentList[u].add(v);
            adjacentList[v].add(u);
        }

        for (List<Integer> nodes : adjacentList) {
            Collections.sort(nodes);
        }

        bfs(R);
        for (int i = 1; i < visit.length; i++) {
            System.out.println(visit[i]);
        }
    }

    private static void bfs(int r) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);
        visit[r] = ++visitOrder;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < adjacentList[cur].size(); i++) {
                int adjacentNode = adjacentList[cur].get(i);
                if (visit[adjacentNode] == 0) {
                    visit[adjacentNode] = ++visitOrder;
                    queue.add(adjacentNode);
                }
            }
        }
    }
}
