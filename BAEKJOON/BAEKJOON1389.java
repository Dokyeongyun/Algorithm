package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
케빈 베이컨의 6단계 법칙
https://www.acmicpc.net/problem/1389
 */
public class BAEKJOON1389 {

    static int[] bacon;
    static int n;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];

        for(int i=1; i< list.length; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            list[cur].add(next);
            list[next].add(cur);
        }

        bacon = new int[n+1];

        for(int i=1; i<list.length; i++){
            bfs(i);
        }

        int min = Integer.MAX_VALUE;
        int index = 0;
        for(int i=1; i<bacon.length; i++){
            if(min > bacon[i]){
                min = bacon[i];
                index = i;
            }
        }
        System.out.println(index);
    }

    static void bfs(int start){
        boolean[] visit = new boolean[n+1];
        int[] count = new int[n+1];

        Queue<Integer> que = new LinkedList<>();
        que.add(start);

        while(!que.isEmpty()){
            int cur = que.poll();
            if(!visit[cur]){
                visit[cur] = true;
            }
            for(int i=0; i<list[cur].size(); i++){
                int next = list[cur].get(i);

                if(!visit[next]){
                    que.add(next);
                    visit[next] = true;
                    count[next] = count[cur] + 1;
                }
            }
        }

        int sum = 0;
        for(int i=1; i<count.length; i++){
            sum+=count[i];
        }
        bacon[start] = sum;
    }
}
