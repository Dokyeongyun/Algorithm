package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/2776
 */
public class _2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] note1 = new int[N];
            for (int i = 0; i < N; i++) {
                note1[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            Arrays.sort(note1);

            int[] answer = new int[M];
            for (int i = 0; i < M; i++) {
                int left = 0;
                int right = N - 1;
                int val = Integer.parseInt(st.nextToken());

                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (val == note1[mid]) {
                        answer[i] = 1;
                        break;
                    }
                    if (val < note1[mid]) {
                        right = mid - 1;
                    } else if (val > note1[mid]) {
                        left = mid + 1;
                    }
                }
            }

            for (int i = 0; i < M; i++) {
                sb.append(answer[i]+"\n");
            }
        }
        System.out.println(sb);
    }
}
