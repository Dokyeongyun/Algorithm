package BAEKJOON;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
문제
방향성이 없는 그래프가 주어진다. 세준이는 1번 정점에서 N번 정점으로 최단 거리로 이동하려고 한다.
또한 세준이는 두 가지 조건을 만족하면서 이동하는 특정한 최단 경로를 구하고 싶은데, 그것은 바로 임의로 주어진 두 정점은 반드시 통과해야 한다는 것이다.

세준이는 한번 이동했던 정점은 물론, 한번 이동했던 간선도 다시 이동할 수 있다.
하지만 반드시 최단 경로로 이동해야 한다는 사실에 주의하라.
1번 정점에서 N번 정점으로 이동할 때, 주어진 두 정점을 반드시 거치면서 최단 경로로 이동하는 프로그램을 작성하시오.

입력
첫째 줄에 정점의 개수 N과 간선의 개수 E가 주어진다. (2 ≤ N ≤ 800, 0 ≤ E ≤ 200,000)
둘째 줄부터 E개의 줄에 걸쳐서 세 개의 정수 a, b, c가 주어지는데, a번 정점에서 b번 정점까지 양방향 길이 존재하며, 그 거리가 c라는 뜻이다. (1 ≤ c ≤ 1,000)
다음 줄에는 반드시 거쳐야 하는 두 개의 서로 다른 정점 번호 v1과 v2가 주어진다. (v1 ≠ v2, v1 ≠ N, v2 ≠ 1)

출력
첫째 줄에 두 개의 정점을 지나는 최단 경로의 길이를 출력한다. 그러한 경로가 없을 때에는 -1을 출력한다.
 */
public class BAEKJOON1504 {
    private static final int INF = 200_000_000;
    static ArrayList<Node>[] list;
    static int[] distance;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        distance = new int[n + 1];
        visit = new boolean[n + 1];


        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Node(next, weight));
            list[next].add(new Node(start, weight));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 1 -> v1 -> v2 -> N
        int sum1 = 0;
        sum1 += dijkstra(1, v1);
        sum1 += dijkstra(v1, v2);
        sum1 += dijkstra(v2, n);

        // 1 -> v2 -> v1 -> N
        int sum2 = 0;
        sum2 += dijkstra(1, v2);
        sum2 += dijkstra(v2, v1);
        sum2 += dijkstra(v1, n);

        int answer;
        if(sum1 >= INF && sum2 >= INF){
            answer = -1;
        }else{
            answer = Math.min(sum1, sum2);
        }

        System.out.println(answer);
    }

    public static int dijkstra(int start, int end) {
        Arrays.fill(distance, INF);
        Arrays.fill(visit, false);

        PriorityQueue<Node> que = new PriorityQueue<>();
        que.add(new Node(start, 0));
        distance[start] = 0;

        while (!que.isEmpty()) {

            Node current = que.poll();
            int currentNode = current.point;
            int currentWeight = current.weight;

            if (!visit[currentNode]) {
                visit[currentNode] = true;

                for (int i = 0; i < list[currentNode].size(); i++) {
                    int next = list[currentNode].get(i).point;
                    int weight = list[currentNode].get(i).weight;

                    if (!visit[next] && distance[next] > currentWeight + weight) {
                        distance[next] = currentWeight + weight;
                        que.add(new Node(next, distance[next]));
                    }
                }
            }
        }
        return distance[end];
    }


    public static class Node implements Comparable<Node> {
        int point;
        int weight;

        Node(int point, int weight) {
            this.point = point;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
