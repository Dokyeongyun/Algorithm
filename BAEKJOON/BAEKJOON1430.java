package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1430
 */
/*
6 3 10 4 4
4 8
0 4
6 6
6 4
8 4
6 2

8 3 10 4 4
4 8
0 4
6 6
6 4
8 4
6 2
6 9
9 9
 */
public class BAEKJOON1430 {
//    static Point[] points;
    static int N, R, D, X, Y;
    static boolean[] visit;
    static double[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        Point[] points = new Point[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
        }

        count = new double[N];
        Arrays.fill(count, Integer.MAX_VALUE);

        Point enemy = new Point(X, Y, 0);
        for(int i=0; i<N; i++){
            if(getDistance(enemy, points[i]) <= R){
                BFS(i, points);
            }
        }

        double maxDamage = 0;
        for(int i=0; i<N; i++){
            System.out.println(count[i]+" ");
            if(count[i] == Integer.MAX_VALUE) continue;
            maxDamage = Math.max(maxDamage, count[i]);
        }

        System.out.println(Math.round(maxDamage*100)/100.0);
    }

    static double getDistance(Point p1, Point p2){
        return Math.sqrt(Math.pow(p1.x-p2.x, 2) + Math.pow(p1.y-p2.y, 2));
    }

    static void BFS(int index, Point[] points){
        // index 번째 탑이 적을 공격한다.
        visit = new boolean[N];
        for (Point point : points) {
            point.d = 0;
        }

        Point attackTower = points[index];
        Queue<Point> que = new LinkedList<>();
        que.add(attackTower);
        visit[index] = true;

        double damage = D;

        while (!que.isEmpty()){
            Point cur = que.poll();

            for(int i=0; i<points.length; i++){
                if(visit[i]) continue;
                if(getDistance(cur, points[i]) > R) continue;

                Point temp = points[i];
                temp.d = cur.d+1;
                que.add(temp);
                visit[i] = true;
                damage = (D/Math.pow(2,cur.d+1)) + damage;
//                System.out.println(index+" | "+ i+" "+damage);
//                System.out.println(que);
            }
        }

        count[index] = damage;
    }

    static class Point{
        int x;
        int y;
        int d;
        Point(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }

        @Override
        public String toString() {
            return x+" "+y+" "+d;
        }
    }
}
