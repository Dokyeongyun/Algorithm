package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15686
 */
public class BAEKJOON15686 {
    static int M;
    static int minDistance = Integer.MAX_VALUE;
    static List<Point> houses = new ArrayList<>();
    static List<Point> chickens = new ArrayList<>();
    static Stack<Point> selected = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][N+1];

        for(int i=1; i<arr.length; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<arr.length; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    houses.add(new Point(i, j));
                }
                if(arr[i][j] == 2){
                    chickens.add(new Point(i, j));
                }
            }
        }
        dfs(0, 0);
        System.out.println(minDistance);
    }
    static void dfs(int start, int count){
        if (count == M) {
            calcDist();
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected.push(chickens.get(i));
            dfs(i + 1, count + 1);
            selected.pop();
        }
    }

    static void calcDist() {
        int sum = 0;
        for (Point house : houses) {
            int min = Integer.MAX_VALUE;
            for (Point chicken : selected) {
                int dist = distance(house, chicken);
                min = Math.min(min, dist);
            }
            sum += min;
            if (sum > minDistance) {
                return;
            }
        }
        minDistance = Math.min(sum, minDistance);
    }

    static int distance(Point p1, Point p2){
        int diffX = Math.abs(p1.x - p2.x);
        int diffY = Math.abs(p1.y - p2.y);
        return diffX + diffY;
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
