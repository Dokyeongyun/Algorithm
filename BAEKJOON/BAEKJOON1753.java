package BAEKJOON;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
문제
방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오. 단, 모든 간선의 가중치는 10 이하의 자연수이다.

입력
첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다. (1≤V≤20,000, 1≤E≤300,000)
모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정한다. 둘째 줄에는 시작 정점의 번호 K(1≤K≤V)가 주어진다.
셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다.
이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. u와 v는 서로 다르며 w는 10 이하의 자연수이다.
서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.

출력
첫째 줄부터 V개의 줄에 걸쳐, i번째 줄에 i번 정점으로의 최단 경로의 경로값을 출력한다.
시작점 자신은 0으로 출력하고, 경로가 존재하지 않는 경우에는 INF를 출력하면 된다.
 */
public class BAEKJOON1753 {
    static ArrayList<Node>[] listArr;
    static int[] distance;
    static boolean[] visit;
    static int v, e, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
/*        String[] split = br.readLine().split(" ");
        v = Integer.parseInt(split[0]);
        e = Integer.parseInt(split[1]);
        k = Integer.parseInt(br.readLine());*/

        listArr = new ArrayList[v + 1];
        distance = new int[v + 1]; // 출발점으로부터 각 노드간 거리 계산

        for (int i = 0; i <= v; i++) {
            listArr[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            listArr[start].add(new Node(end, weight));
        }
/*
        for (int i = 0; i < e; i++) {
            String[] split2 = br.readLine().split(" ");
            listArr[Integer.parseInt(split2[0])].add(new Node(Integer.parseInt(split2[1]), Integer.parseInt(split2[2])));
        }*/

        Arrays.fill(distance, Integer.MAX_VALUE);

        dijkstra(k);


        for (int i = 1; i < distance.length; i++) {
            if (visit[i]) {
                bw.append(String.valueOf(distance[i])).append("\n");
            } else {
                bw.append("INF").append("\n");
            }
        }
        bw.flush();
        bw.close();
    }
    public static void dijkstra(int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>();
        visit = new boolean[v + 1];

        que.add(k);
        distance[k] = 0;

        while (!que.isEmpty()) {
            int current = que.poll();
            if (!visit[current]) {
                visit[current] = true;
                for (int i = 0; i < listArr[current].size(); i++) {
                    int a = listArr[current].get(i).point;
                    int b = listArr[current].get(i).value;
                    if (distance[a] > distance[current] + b) {
                        distance[a] = Math.min(distance[a], b + distance[current]);
                        que.add(a);
                    }
                }
            }
        }
    }

    static class Node {
        int point;
        int value;

        Node(int point, int value) {
            this.point = point;
            this.value = value;
        }
    }
}
