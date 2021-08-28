package BAEKJOON;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10815
 */
public class BAEKJOON10815 {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (binarySearch(num)) {
                bw.write("1 ");
            } else {
                bw.write("0 ");
            }
        }

        bw.close();
        br.close();
    }

    static boolean binarySearch(int num) {
        int leftIndex = 0;
        int rightIndex = N - 1;

        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            int mid = arr[midIndex];

            if (num < mid) {
                rightIndex = midIndex - 1;
            } else if (num > mid) {
                leftIndex = midIndex + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
