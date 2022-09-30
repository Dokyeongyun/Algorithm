package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
https://www.acmicpc.net/problem/1967
 */
public class _1967 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        ArrayList<Node>[] list = new ArrayList[n+1];

        for(int i=0; i< list.length; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[cur].add(new Node(next, weight));
            list[next].add(new Node(cur, weight));
        }

        int[] distance = new int[n+1];
        distance = bfs(list, 1);

        int node = 0;
        for(int i=0; i<distance.length; i++){
            if(distance[node] < distance[i]){
                node = i;
            }
        }

        distance = bfs(list, node);
        Arrays.sort(distance);
        System.out.println(distance[n]);
    }

    public static int[] bfs(ArrayList<Node>[] list, int start){

        int[] distance = new int[n+1];
        boolean[] visit = new boolean[n+1];

        Queue<Integer> que = new LinkedList<>();
        que.add(start);

        while(!que.isEmpty()){
            int cur = que.poll();
            visit[cur] = true;

            for(int i=0; i<list[cur].size(); i++){
                int next = list[cur].get(i).next;
                int weight = list[cur].get(i).weight;

                if(!visit[next]){
                    que.add(next);
                    distance[next] = distance[cur] + weight;
                }
            }
        }
        return distance;
    }

    public static class Node{
        int next;
        int weight;
        Node(int n, int w){
            this.next = n;
            this.weight = w;
        }
    }
}
