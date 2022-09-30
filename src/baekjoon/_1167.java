package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
문제
트리의 지름이란, 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것을 말한다. 트리의 지름을 구하는 프로그램을 작성하시오.

입력
트리가 입력으로 주어진다. 먼저 첫 번째 줄에서는 트리의 정점의 개수 V가 주어지고 (2≤V≤100,000)
둘째 줄부터 V개의 줄에 걸쳐 간선의 정보가 다음과 같이 주어진다. (정점 번호는 1부터 V까지 매겨져 있다고 생각한다)

먼저 정점 번호가 주어지고, 이어서 연결된 간선의 정보를 의미하는 정수가 두 개씩 주어지는데, 하나는 정점번호, 다른 하나는 그 정점까지의 거리이다.
예를 들어 네 번째 줄의 경우 정점 3은 정점 1과 거리가 2인 간선으로 연결되어 있고, 정점 4와는 거리가 3인 간선으로 연결되어 있는 것을 보여준다.
각 줄의 마지막에는 -1이 입력으로 주어진다. 주어지는 거리는 모두 10,000 이하의 자연수이다.

출력
첫째 줄에 트리의 지름을 출력한다.
 */
public class _1167 {
    static int v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        v = Integer.parseInt(br.readLine());

        ArrayList<Node>[] list = new ArrayList[v+1];
        for(int i=0; i<list.length; i++){
            list[i] = new ArrayList<>();
        }


        for(int i=0; i<v; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int next;

            while( (next = Integer.parseInt(st.nextToken())) != -1){
                int weight = Integer.parseInt(st.nextToken());
                list[start].add(new Node(next, weight));
            }
        }

        int[] distance = new int[v+1];
        distance = bfs(list, 1);


        // 누적거리가 가장 긴 노드를 찾아야 함 (누적거리를 찾는게 아니므로 정렬 X)
        int node = 0;
        for(int i=0; i<distance.length; i++){
            if(distance[node] < distance[i]){
                node = i;
            }
        }
//        System.out.println(node);

        // 위에서 찾은 노드에서 다시 bfs로 트리의 지름을 구함
        distance = bfs(list, node);

        // 트리의 지름은 가장 긴 누적거리이므로 정렬
        Arrays.sort(distance);

        System.out.println(distance[v]);
    }

    public static int[] bfs(ArrayList<Node>[] list, int start){
        boolean[] check = new boolean[v+1];
        int[] distance = new int[v+1];

        Queue<Integer> que = new LinkedList<>();

        que.add(start);
        check[start] = true;

        while(!que.isEmpty()) {
            int cur = que.poll();
            check[cur] = true;

            for (int i = 0; i < list[cur].size(); i++) {
                int next = list[cur].get(i).next;
                int weight = list[cur].get(i).weight;

                if (!check[next]) {
                    que.add(next);
                    distance[next] = distance[cur] + weight;
                }
            }
        }

/*        for(int i=1; i<distance.length; i++){
            System.out.print(distance[i]+" ");
        }
        System.out.println();*/

        return distance;
    }

    static class Node{
        int next;
        int weight;
        Node(int n, int w){
            this.next = n;
            this.weight = w;
        }
    }
}
