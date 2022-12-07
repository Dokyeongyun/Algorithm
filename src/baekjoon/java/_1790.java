package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1790
 */
public class _1790 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long temp = K;
        long now = 0;
        long length = 1;
        long size = 9;

        while (true) {
            if (temp <= length * size) {
                break;
            }

            temp -= (length * size);
            now += size;

            length++;
            size *= 10;
        }

        now = (now + 1) + (temp - 1) / length;
        if (now > N) {
            System.out.println(-1);
            return;
        }
        int mod = (int) ((temp - 1) % length);
        System.out.println(String.valueOf(now).charAt(mod));
    }
}
