package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/1421
 */
public class _1421 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] woods = new int[N];

        int longestWood = 0;
        for (int i = 0; i < N; ++i) {
            woods[i] = Integer.parseInt(br.readLine());
            longestWood = Math.max(woods[i], longestWood);
        }

        int res = 0;
        for (int i = 1; i <= longestWood; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if (woods[j] >= i) {
                    int piece;
                    int cuttingCost;

                    piece = woods[j] / i;
                    cuttingCost = woods[j] % i == 0 ? (piece - 1) * C : piece * C;

                    int woodPrice = piece * W * i;

                    if (woodPrice - cuttingCost > 0) {
                        sum += woodPrice - cuttingCost;
                    }
                }
            }
            res = Math.max(sum, res);
        }
        System.out.println(res);
    }
}
