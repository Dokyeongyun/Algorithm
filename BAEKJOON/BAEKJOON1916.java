package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
https://www.acmicpc.net/problem/1916
 */
public class BAEKJOON1916 {

    static ArrayList<Node>[] list;
    static int[] minWeight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        minWeight = new int[n+1];
        for(int i=1; i<minWeight.length; i++){
            minWeight[i] = Integer.MAX_VALUE;
        }
        list = new ArrayList[n+1];
        for(int i=1; i<list.length; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[cur].add(new Node(next, weight));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        System.out.println(minWeight[end]);
    }

    static void dijkstra(int start){

        PriorityQueue<Integer> que = new PriorityQueue<>();
        que.add(start);
        minWeight[start] = 0;

        while(!que.isEmpty()){
            int cur = que.poll();

            for(int i=0; i<list[cur].size(); i++){
                int next = list[cur].get(i).p;
                int weight = list[cur].get(i).w;

                if(minWeight[next] > minWeight[cur] + weight){
                    minWeight[next] = minWeight[cur] + weight;
                    que.add(next);
                    System.out.println(que);
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int p;
        int w;

        Node(int p, int w){
            this.p = p;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            if(this.w - o.w < 0 ){
                return 1;
            }else{
                return 0;
            }
        }
    }
}
