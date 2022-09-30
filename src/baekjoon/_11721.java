package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/11721
 */
public class _11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        StringBuffer sb = new StringBuffer();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (count == 10) {
                count = 0;
                sb.append("\n");
            }
            count++;
            sb.append(input.charAt(i));
        }

        System.out.println(sb);
    }
}
