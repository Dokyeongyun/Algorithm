package BAEKJOON;

import java.util.*;

/*
문제
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

입력
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다.
입력으로 주어지는 간선은 양방향이다.

출력
첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
 */
public class BAEKJOON1260 {

    static ArrayList<Integer>[] list;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();
        int v = scan.nextInt();

        list = new ArrayList[n + 1];

        for (int i = 1; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int node1 = scan.nextInt();
            int node2 = scan.nextInt();

            list[node1].add(node2);
            list[node2].add(node1);
        }

        for (int i = 1; i < list.length; i++) {
            Collections.sort(list[i]);
        }

        check = new boolean[n + 1];
        dfs(v);

        sb.append("\n");

        check = new boolean[n + 1];
        bfs(v);

        System.out.println(sb);
    }

    public static void dfs(int startNode) {

        // 1. 방문 노드 true
        // 2. 해당 노드의 인접 노드 중 false 인 노드에 대해 dfs

        if (check[startNode]) {
            return;
        }

        check[startNode] = true;
        sb.append(startNode + " ");

        for (int i = 0; i < list[startNode].size(); i++) {
            if (!check[list[startNode].get(i)]) {
                dfs(list[startNode].get(i));
            }
        }


    }

    public static void bfs(int startNode) {
        Queue<Integer> que = new LinkedList<>();
        que.add(startNode);
        check[startNode] = true;

        while (!que.isEmpty()) {
            int temp = que.peek();
            sb.append(temp + " ");

            startNode = que.poll();

            for(int i=0; i<list[startNode].size(); i++){
                if(!check[list[startNode].get(i)]){
                    check[list[startNode].get(i)] = true;
                    que.add(list[startNode].get(i));
                }
            }

        }

    }
}
