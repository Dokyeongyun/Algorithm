package BAEKJOON;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  https://www.acmicpc.net/problem/1041
 */
public class BAEKJOON1041 {
    private static long N;
    private static long one, two, three;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int[] dice = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) dice[i] = Integer.parseInt(st.nextToken());

        long af = Math.min(dice[0], dice[5]);
        long be = Math.min(dice[1], dice[4]);
        long cd = Math.min(dice[2], dice[3]);

        // 1,2,3면 구성
        one = Math.min(af, Math.min(be, cd));
        two = Math.min(af + be, Math.min(af + cd, be + cd));
        three = af + be + cd;

        long sum = minSum(dice);

        bw.write(String.valueOf(sum));
        br.close();
        bw.close();
    }

    private static long minSum(int[] dice) {
        long sum = 0;
        if (N == 1) {
            long max = Integer.MIN_VALUE;
            for (int i = 0; i < 6; i++) {
                max = Math.max(max,dice[i]);
                sum += dice[i];
            }
            return sum-max;
        }
        long oneSide = 4 * (N - 1) * (N - 2) + (N - 2) * (N - 2);
        long secondSide = 4 * (N - 1) + 4 * (N - 2);
        long thirdSide = 4;

        sum += one * oneSide + two * secondSide + three * thirdSide;
        return sum;
    }
}
