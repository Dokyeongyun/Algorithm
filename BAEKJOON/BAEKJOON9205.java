package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEKJOON9205 {
    static Point[] pointArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            int n = Integer.parseInt(br.readLine());

            pointArr = new Point[n+2];
            for(int i=0; i<pointArr.length; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                pointArr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            bfs();
        }
    }

    static void bfs(){
        boolean[] visit = new boolean[pointArr.length];

        Point start = pointArr[0];
        Point end = pointArr[pointArr.length-1];

        Queue<Point> que = new LinkedList<>();
        que.add(start);

        boolean exit = false;
        while (!que.isEmpty()) {
            Point current = que.poll();
            if(current.equals(end)){
                exit = true;
                break;
            }
            for (int i = 1; i < pointArr.length; i++) {
                if (!visit[i] && distance(current, pointArr[i]) <= 1000) {
                    que.add(pointArr[i]);
                    visit[i] = true;
                }
            }
        }
        if(exit){
            System.out.println("happy");
        }
        else{
            System.out.println("sad");
        }
    }
    static int distance(Point p1, Point p2){
        int xDiff = Math.abs(p1.x - p2.x);
        int yDiff = Math.abs(p1.y - p2.y);
        return xDiff + yDiff;
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
            return "{"+x + " " + y +"}";
        }
    }
}
