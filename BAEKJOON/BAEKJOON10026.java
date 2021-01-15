package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BAEKJOON10026 {
    static int n;
    static char[][] arr1;
    static boolean[][] visit;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static Queue<Point> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr1 = new char[n][n];
        visit = new boolean[n][n];

        for(int i=0; i<n; i++){
            String[] split = br.readLine().split("");
            for(int j=0; j<split.length; j++){
                arr1[i][j] = split[j].charAt(0);
            }
        }

        int count1=0, count2=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visit[i][j]){
                    BFS(i, j, arr1[i][j]);
                    count1++;
                }
            }
        }
        visit = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr1[i][j] == 'R'){
                    arr1[i][j] = 'G';
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visit[i][j]){
                    BFS(i, j, arr1[i][j]);
                    count2++;
                }
            }
        }
        System.out.println(count1 +" "+count2);
    }

    static void BFS(int x, int y, char color){

        que.add(new Point(x, y));
        visit[x][y] = true;

        while(!que.isEmpty()){
            Point cur = que.poll();
            int curX = cur.x;
            int curY = cur.y;
            visit[curX][curY] = true;

            for(int i=0; i<4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n){
                    continue;
                }
                if(visit[nextX][nextY]){
                    continue;
                }
                if(arr1[nextX][nextY] == color){
                    que.add(new Point(nextX, nextY));
                }
            }
        }
    }

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
