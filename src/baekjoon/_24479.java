package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _24479 {

    static List<List<Integer>> adjacentNodeList = new ArrayList<>();
    static int[] orders;

    static int order = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        orders = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            adjacentNodeList.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjacentNodeList.get(u).add(v);
            adjacentNodeList.get(v).add(u);
        }

        for (List<Integer> nodes : adjacentNodeList) {
            Collections.sort(nodes);
        }

        dfs(R);
        for (int i = 1; i < orders.length; i++) {
            System.out.println(orders[i]);
        }
    }

    private static void dfs(int r) {
        orders[r] = ++order;
        for (int i = 0; i < adjacentNodeList.get(r).size(); i++) {
            if (orders[adjacentNodeList.get(r).get(i)] == 0) {
                dfs(adjacentNodeList.get(r).get(i));
            }
        }
    }
}
