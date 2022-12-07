package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11403
 */
public class _11403 {
    static ArrayList<Integer>[] adjacentList;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        visit = new boolean[N][N];

        adjacentList = new ArrayList[N];
        for(int i=0; i<adjacentList.length; i++){
            adjacentList[i] = new ArrayList<>();
        }

        int[][] adjacentArr = new int[N][N];

        for(int i=0; i<adjacentArr.length; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<adjacentArr.length; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp==1){
                    adjacentList[i].add(j);
                }
            }
        }
        for(int i=0; i<N; i++){
            BFS(i);
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visit[i][j]){
                    System.out.print(1+" ");
                }else{
                    System.out.print(0+" ");
                }
            }
            System.out.println();
        }

    }

    static void BFS(int start){
        Queue<Integer> que = new LinkedList<>();
        que.add(start);

        while(!que.isEmpty()){
            int cur = que.poll();

            for(int i=0; i<adjacentList[cur].size(); i++){
                int temp = adjacentList[cur].get(i);
                if(!visit[start][temp]){
                    que.add(temp);
                    visit[start][temp] = true;
                }
            }
        }
    }
}
