package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1245
 */
public class BAEKJOON1245 {
    static int N, M;
    static boolean check;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visit[i][j]){
                    check = true;
                    BFS(i, j);
                    if(check){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

    static void BFS(int x, int y){
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y));
        visit[x][y] = true;

        while(!que.isEmpty()){
            Node curNode = que.poll();
            int curX = curNode.x;
            int curY = curNode.y;

            for(int i=0; i<8; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if(map[nextX][nextY] > map[curX][curY]) check = false;
                if(visit[nextX][nextY] || map[curX][curY] != map[nextX][nextY]) continue;

                que.add(new Node(nextX, nextY));
                visit[nextX][nextY] = true;
            }
        }
    }

    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
