package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1004
 */
public class _1004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            Point start = new Point(x1, y1, 0);
            Point end = new Point(x2, y2, 0);

            int n = Integer.parseInt(br.readLine());

            Point[] planets = new Point[n];
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                planets[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            int[] arr = new int[n];

            // 시작점을 포함하는 행성계의 개수
            for(int i=0; i<n; i++) if(isIncluded(start, planets[i])) arr[i]++;

            // 도착점을 포함하는 행성계의 개수
            for(int i=0; i<n; i++){
                if(isIncluded(end, planets[i])){
                    if(arr[i] == 1) {
                        arr[i] = 0;
                        continue;
                    }
                    arr[i]++;
                }
            }

            int count = 0;
            for (int j : arr) count += j;

            System.out.println(count);
        }
    }

    static boolean isIncluded(Point p1, Point planet){
        return Math.pow((p1.x - planet.x), 2) + Math.pow((p1.y - planet.y), 2) <= Math.pow(planet.r, 2);
    }

    static class Point{
        int x;
        int y;
        int r;
        Point(int x, int y, int r){
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }
}
