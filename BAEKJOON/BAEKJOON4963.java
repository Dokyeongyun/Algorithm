package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/4963
 */
public class BAEKJOON4963 {
    static int w, h;
    static boolean[][] visit;
    static int[][] map;
    static int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w==0 && h==0) break;

            map = new int[h][w];

            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 현재 지도에서 섬의 개수 출력
            visit = new boolean[h][w];

            int count = 0;

            for(int i=0; i<map.length; i++){
                for(int j=0; j<map[0].length; j++){
                    if(!visit[i][j] && map[i][j] == 1){
                        BFS(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);

            // input print
//            for (int[] ints : map) {
//                System.out.println(Arrays.toString(ints));
//            }
//            System.out.println();
        }
    }
    static void BFS(int x, int y){
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(x, y));
        visit[x][y] = true;

        while(!que.isEmpty()){
            Point cur = que.poll();
            int curX = cur.x;
            int curY = cur.y;

            for(int i=0; i<8; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX >=h || nextX < 0 || nextY >= w || nextY < 0) continue;
                if(visit[nextX][nextY]) continue;
                if(map[nextX][nextY] != 1) continue;

                que.add(new Point(nextX, nextY));
                visit[nextX][nextY] = true;
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
