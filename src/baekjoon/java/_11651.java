package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11651
 */
public class _11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Point[] arr = new Point[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);

        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    static class Point implements Comparable<Point>{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if(o.y > this.y){
                return -1;
            }else if(o.y == this.y){
                return Integer.compare(this.x, o.x);
            }else{
                return 1;
            }
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
