package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/18352
 */
public class BAEKJOON18352 {

    static int N, M, K, X;
    static List<Integer>[] list;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list[A].add(B);
        }

        dijkstra();

        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            if (distance[i] == K) answer.add(i);
        }

        if (answer.size() == 0) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }

    static void dijkstra() {
        PriorityQueue<Integer> que = new PriorityQueue<>();
        distance[X] = 0;
        que.add(X);

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int i = 0; i < list[cur].size(); i++) {
                int next = list[cur].get(i);
                if (distance[next] > distance[cur] + 1) {
                    distance[next] = distance[cur] + 1;
                    que.add(next);
                }
            }
        }
    }
}
