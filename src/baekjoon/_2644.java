package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2644
 */
public class _2644 {
    static int[][] adjacent;
    static boolean[] check;
    static int[] total;
    static int n, p1, p2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        adjacent = new int[n+1][2];
        for(int i=1; i<adjacent.length; i++){
            adjacent[i][0] = i;
        }
        check = new boolean[n+1];
        total = new int[n+1];

        int m = Integer.parseInt(br.readLine());
        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            adjacent[i][0] = Integer.parseInt(st.nextToken());
            adjacent[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(BFS(p1));
    }
/*
9
1 5
7
1 2
1 3
2 7
2 8
2 9
4 5
4 6
 */

    static int BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int nextX = q.poll();
            check[nextX] = true;
            for (int i = 0; i < n; i++) {
                if (adjacent[i][0] == nextX && !check[adjacent[i][1]]) {
                    q.add(adjacent[i][1]);
                    total[adjacent[i][1]] = total[adjacent[i][0]] + 1;
                } else if (adjacent[i][1] == nextX && !check[adjacent[i][0]]) {
                    q.add(adjacent[i][0]);
                    total[adjacent[i][0]] = total[adjacent[i][1]] + 1;
                }
            }
            if (!q.isEmpty() && q.peek() == p2) {
                return total[p2];
            }
        }
        return -1;
    }
}
