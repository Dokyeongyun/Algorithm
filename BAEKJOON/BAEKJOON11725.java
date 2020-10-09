package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
문제
루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.

출력
첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
 */
public class BAEKJOON11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] list = new ArrayList[n+1];
        for(int i=0; i< list.length; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            list[cur].add(next);
            list[next].add(cur);
        }


        boolean[] visit = new boolean[n+1];
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        visit[1] = true;

        int[] parent = new int[n+1];
        while(!que.isEmpty()){
            int cur = que.poll();
            visit[cur] = true;

            for(int i=0; i<list[cur].size(); i++){
                int next = list[cur].get(i);

                if(!visit[next]){
                    que.add(next);
                    parent[next] = cur;
                }
            }
        }

        for(int i=2; i<parent.length; i++){
            System.out.println(parent[i]);
        }
    }
}
