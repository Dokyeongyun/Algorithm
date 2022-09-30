package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1325 {
    static int N;
    static ArrayList<Integer>[] list;
    static boolean[] visit;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        cnt = new int[N+1];

        for(int i=0; i<list.length; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            list[next].add(cur);
//            list[cur].add(next);
        }

/*        for(int i=1; i<=N; i++) {
            dfs(i);
        }

        int max = 0;

        for(int i=1; i<=N; i++) {
            max = Math.max(max, cnt[i]);
        }
        StringBuffer sb = new StringBuffer();
        for(int i=1; i<=N; i++) {
            if(cnt[i] == max)
                sb.append(i+" ");
        }
        System.out.println(sb.toString());*/

        int[] ans = new int[N+1];
        int max = 0;
        for(int i=1; i<list.length; i++){
            visit = new boolean[N+1];
            ans[i] = BFS(i);
            max = Math.max(ans[i], max);
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
    public static void dfs(int start) {
        visit = new boolean[N+1];

        visit[start] = true;

        for(int i=0; i<list[start].size(); i++) {
            if(!visit[list[start].get(i)]) {
                cnt[list[start].get(i)]++;
                dfs(list[start].get(i));
            }
        }
    }
}
