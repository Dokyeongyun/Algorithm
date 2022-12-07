package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/7562
 */
public class _7562 {
    static int l;
    static int[][] count;
    static int[] dx = new int[]{-2, -2, -1, 1, 2, 2, -1, 1};
    static int[] dy = new int[]{-1, 1, 2, 2, -1, 1, -2, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            l = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Point current = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            Point target = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            System.out.println(BFS(current, target));
        }
    }
    static int BFS(Point start, Point tar){
        if(start.x == tar.x && start.y == tar.y) return 0;
        count = new int[l][l];

        count[start.x][start.y] = 0;
        Queue<Point> que = new LinkedList<>();
        que.add(start);

        while(!que.isEmpty()){
//            System.out.println(que);
            Point cur = que.poll();
            int curX = cur.x;
            int curY = cur.y;

            for(int i=0; i<8; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                int nextV = count[curX][curY] + 1;

                if(nextX < 0 || nextX >= l || nextY < 0 || nextY >= l) continue;

                if(count[nextX][nextY] == 0){
                    que.add(new Point(nextX, nextY));
                    count[nextX][nextY] = nextV;
                }

                if(nextX == tar.x && nextY == tar.y){
                    break;
                }
            }
        }
        return count[tar.x][tar.y];
    }

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "["+x+" "+y+"]";
        }
    }
}
