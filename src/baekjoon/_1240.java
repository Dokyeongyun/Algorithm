package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/1240
 */
public class _1240 {

    static int N, M;
    static ArrayList<Node>[] nodeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nodeList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            nodeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodeList[start].add(new Node(end, weight));
            nodeList[end].add(new Node(start, weight));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            BFS(start, end);
        }
    }

    static void BFS(int start, int end) {
        boolean check = false;
        boolean[] visit = new boolean[N + 1];
        int[] distance = new int[N + 1];

        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visit[start] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();
            int curDistance = distance[cur];

            for (int i = 0; i < nodeList[cur].size(); i++) {
                int nextNode = nodeList[cur].get(i).end;
                int nextWeight = nodeList[cur].get(i).weight;

                if (!visit[nextNode]) {
                    que.add(nextNode);
                    visit[nextNode] = true;
                    distance[nextNode] = curDistance + nextWeight;

                    if (nextNode == end) {
                        check = true;
                        break;
                    }
                }
            }
            if(check) break;
        }

        System.out.println(distance[end]);
    }

    static class Node {
        int end;
        int weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}
