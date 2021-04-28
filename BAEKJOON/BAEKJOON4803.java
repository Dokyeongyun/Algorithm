package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
https://www.acmicpc.net/problem/4803
 */
public class BAEKJOON4803 {
    static ArrayList<Integer>[] adjacency;
    static boolean[] visit;
    static int[] parent;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseNum = 0;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break; // 종료 조건

            caseNum++;

            adjacency = new ArrayList[N + 1];
            visit = new boolean[N + 1];
            parent = new int[N + 1];

            for (int i = 0; i < N + 1; i++) {
                adjacency[i] = new ArrayList();
            }

            // 인접성 추가
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                adjacency[start].add(end);
                adjacency[end].add(start);
            }

            int count = BFS();

            if (count == 0) {
                System.out.println("Case " + caseNum + ": No trees.");
            } else if (count == 1) {
                System.out.println("Case " + caseNum + ": There is one tree.");
            } else {
                System.out.println("Case " + caseNum + ": A forest of " + count + " trees.");
            }
        }
    }

    static int BFS() {
        int count = 0;
        boolean isTree = true;
        Queue<Integer> que = new LinkedList<>();

        for (int i = 1; i < N + 1; i++) {
            if (!visit[i]) {
                isTree = true;
                visit[i] = true;
                que.add(i);

                while (!que.isEmpty()) {
                    int cur = que.poll();

                    for (int j = 0; j < adjacency[cur].size(); j++) {
                        int next = adjacency[cur].get(j);

                        if (visit[next] && parent[cur] != next) {
                            isTree = false;
                        } else if (visit[next]) {
                            continue;
                        } else {
                            que.add(next);
                            visit[next] = true;
                            parent[next] = cur;
                        }
                    }
                }
                if (isTree) count++;
            }
        }
        return count;
    }
}