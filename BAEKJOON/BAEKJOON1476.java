package BAEKJOON;

/*
https://www.acmicpc.net/problem/1476
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int initE = 1;
        int initS = 1;
        int initM = 1;

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int year = 1; ; year++) {
            if (initE == E && initS == S && initM == M) {
                System.out.println(year);
                break;
            }
            initE += 1;
            initS += 1;
            initM += 1;
            if (initE == 16) {
                initE = 1;
            }
            if (initS == 29) {
                initS = 1;
            }
            if (initM == 20) {
                initM = 1;
            }
        }

    }
}
