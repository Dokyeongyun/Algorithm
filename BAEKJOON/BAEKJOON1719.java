package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1719
 */
public class BAEKJOON1719 {

    private static int[] path;
    private static int[] value;
    private static List<int[]>[] list;
    private static StringBuilder sb;
    private static boolean[] visited;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            list[from].add(new int[] {to, val});
            list[to].add(new int[] {from, val});
        }

        sb = new StringBuilder();
        for (int i = 1; i < n+1; i++) {
            path = new int[n+1];
            value = new int[n+1];
            visited = new boolean[n+1];
            Arrays.fill(value, Integer.MAX_VALUE);
            dijkstra(i);
        }

        System.out.println(sb.toString());
    }

    private static void dijkstra(int num) {
        int start = num;
        value[num] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        pq.offer(new int[] {start, 0});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll(); int cur_num = cur[0];
            if(!visited[cur_num]) {
                visited[cur_num] = true;
                for (int i = 0; i < list[cur_num].size(); i++) {
                    int[] next = list[cur_num].get(i);
                    int next_num = next[0];
                    int next_val = next[1];
                    if(value[next_num]>value[cur_num]+next_val) {
                        path[next_num] = cur_num; value[next_num] = value[cur_num]+next_val;
                        pq.offer(new int[] {next_num, value[next_num],next_num});
                    }
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            if(i==num) sb.append("- ");
            else {
                int ans = find(i, num);
                sb.append(ans+" ");
            }
        }
        sb.append("\n");
    }

    private static int find(int i, int start) {
        if(path[i] == start)
            return i;
        return find(path[i], start);
    }
}
