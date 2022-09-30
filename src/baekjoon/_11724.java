package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _11724 {
    static boolean[] check;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i=1; i<list.length; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);
        }

        check = new boolean[list.length];
        int count = 0;
        for(int i=1; i < list.length; i++){
           if(!check[i]){
               bfs(i);
               count++;
           }
        }

        System.out.println(count);
    }
    static void bfs(int start){
        Queue<Integer> que = new LinkedList<>();

        que.add(start);

        while(!que.isEmpty()){
            int current = que.poll();
            if(!check[current]){
                check[current] = true;
            }

            for(int i=0; i<list[current].size(); i++){
                if(!check[list[current].get(i)] && !que.contains(list[current].get(i))){
                    que.add(list[current].get(i));
                }
            }
//            System.out.println(que);
        }
    }
}
