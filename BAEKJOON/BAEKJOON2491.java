package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON2491 {
    static int N;
    static int max = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int temp = 1;
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                temp++;
            } else {
                temp = 1;
            }
            max = Math.max(temp, max);
        }

        int temp2 = 1;
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] >= arr[i + 1]) {
                temp2++;
            } else {
                temp2 = 1;
            }
            max = Math.max(temp2, max);
        }

        System.out.println(max);
    }
}
