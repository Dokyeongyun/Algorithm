package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON14501 {
    static int N, max = 0;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0);

        System.out.println(max);
    }

    static void DFS(int d, int profit) {
        if (d >= N) {
            max = Math.max(max, profit);
            return;
        }

        if (d + arr[d][0] <= N) {
            DFS(d + arr[d][0], profit + arr[d][1]);
        } else {
            DFS(d + arr[d][0], profit);
        }

        DFS(d + 1, profit);
    }
}

