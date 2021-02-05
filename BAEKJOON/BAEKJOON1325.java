package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BAEKJOON1325 {
    static int N;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for(int i=0; i<list.length; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            list[next].add(cur);
        }

        int[] ans = new int[N+1];
        int max = 0;
        for(int i=1; i<list.length; i++){
            int temp = BFS(i);
            ans[i] = temp;
            max = Math.max(temp, max);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<ans.length; i++){
            if(ans[i]==max){
                sb.append(i+" ");
            }
        }
        System.out.println(sb);
    }

    static int BFS(int start){
        boolean[] visit = new boolean[N+1];

        int count = 0;

        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visit[start] = true;

        while(!que.isEmpty()){
            int cur = que.poll();

            for(int i=0; i<list[cur].size(); i++){
                int next = list[cur].get(i);

                if(!visit[next]){
                    count++;
                    que.add(next);
                    visit[next] = true;
                }
            }
        }
        return count;
    }
}
