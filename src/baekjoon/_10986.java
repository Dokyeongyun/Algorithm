package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10986
 */
public class _10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        int[] arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = (arr[i - 1] + Integer.parseInt(st.nextToken())) % M;
            arr2[arr[i]]++;
        }

        long count = arr2[0];
        for (int i = 0; i < M; i++) {
            count += (long) arr2[i] * (arr2[i] - 1) / 2;
        }

        bw.append(String.valueOf(count)).append("\n");
        bw.flush();

        br.close();
        bw.close();
    }

}
