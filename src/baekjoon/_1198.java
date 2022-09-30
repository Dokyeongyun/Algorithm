package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1198 {

    static int[] xArr;
    static int[] yArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        xArr = new int[N];
        yArr = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xArr[i] = Integer.parseInt(st.nextToken());
            yArr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    max = Math.max(max, getTriangleArea(i, j, k));
                }
            }
        }
        System.out.printf("%.1f\n", (double) max / 2);
    }

    static int getTriangleArea(int a, int b, int c) {
        return Math.abs((yArr[a] - yArr[b]) * (xArr[c] - xArr[b]) - (xArr[a] - xArr[b]) * (yArr[c] - yArr[b]));
    }
}
