package BAEKJOON;

import java.util.Scanner;

public class BAEKJOON4803 {
    static boolean[] visited = new boolean[501];
    static Area[][] graph = new Area[501][501];

    static int nodes = 0;
    static int edges = 0;

    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder result = new StringBuilder();

        n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 1; i <= 500; i++) {
            for (int j = 1; j <= 500; j++) graph[i][j] = new Area();
            visited[i] = false;
        }

        int count = 0;
        int caseCount = 1;
        while ((n != 0) || (m != 0)) {
            for (int i = 0; i < m; i++) {
                int parentNode = sc.nextInt();
                int childNode = sc.nextInt();

                graph[parentNode][childNode].isPath = true;
                graph[childNode][parentNode].isPath = true;
            }

            for (int i = 1; i <= n; i++) {
                nodes = 0;
                edges = 0;
                if (!visited[i]) {
                    searchTree(i);
                    if (nodes == edges + 1) count++; // 트리의 조건을 이용해 트리여부 판단
                }
            }

            result.append("Case " + caseCount + ": ");
            if (count == 0) result.append("No trees.\n");
            else if (count == 1) result.append("There is one tree.\n");
            else result.append("A forest of " + count + " trees.\n");

            resetGlobalVars();
            count = 0;
            caseCount++;

            n = sc.nextInt();
            m = sc.nextInt();
        }

        System.out.print(result.toString());
    }

    static void resetGlobalVars() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) graph[i][j].initVars();
            visited[i] = false;
        }
    }

    static void searchTree(int node) {
        if (!visited[node]) {
            visited[node] = true;
            nodes++;
        }

        for (int i = 1; i <= n; i++) {
            if (graph[node][i].isPath && !graph[node][i].isWent) {
                edges++;
                graph[node][i].isWent = true;
                graph[i][node].isWent = true;

                searchTree(i);
            }
        }
    }


    static class Area {
        public boolean isPath;
        public boolean isWent;

        public Area() {
            isPath = false;
            isWent = false;
        }

        public void initVars() {
            isPath = false;
            isWent = false;
        }
    }
}