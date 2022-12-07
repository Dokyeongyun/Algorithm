package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2600
 */
public class _2600 {

    static int b1, b2, b3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        b1 = Integer.parseInt(st.nextToken());
        b2 = Integer.parseInt(st.nextToken());
        b3 = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            int k1 = Integer.parseInt(st.nextToken());
            int k2 = Integer.parseInt(st.nextToken());

            System.out.println(playMarbleGame(k1, k2));
        }
    }

    public static String playMarbleGame(int k1, int k2) {
        return "";
    }
}
