package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _4307 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            int min = 1000000;
            int max = 0;

            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(br.readLine());
                if (arr[j] >= length / 2) {
                    min = Math.min(min, arr[j]);
                } else {
                    max = Math.max(max, arr[j]);
                }
            }
            Arrays.sort(arr);

            System.out.println(Math.max(length - min, max) + " " + Math.max(length - arr[0], arr[N - 1]));
        }
    }
}
