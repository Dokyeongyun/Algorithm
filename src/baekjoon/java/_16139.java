package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/16139
 */
public class _16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        int q = Integer.parseInt(br.readLine());

        int[][] arr = new int[S.length()][123];
        for (int i = 0; i < S.length(); i++) {
            for (int j = 'a'; j <= 'z'; j++) {
                if (i != 0) {
                    arr[i][j] = arr[i - 1][j];
                }
            }

            if (i == 0) {
                arr[i][S.charAt(i)]++;
            } else {
                arr[i][S.charAt(i)] = arr[i - 1][S.charAt(i)] + 1;
            }
        }

        StringTokenizer st;
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            char a = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            bw.append(String.valueOf(arr[r][a] - (l == 0 ? 0 : arr[l - 1][a]))).append("\n");
        }

        bw.flush();
    }
}
