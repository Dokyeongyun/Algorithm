package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2789
 */
public class _2789 {
    static final String CAMBRIDGE = "CAMBRIDGE";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        StringBuffer answer = new StringBuffer();
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i);

            if (c != 65 && c != 66 && c != 67 && c != 68 && c != 69 && c != 71 && c != 73 && c != 77 && c != 82) {
                answer.append((char)c);
            }
        }
        System.out.println(answer);
    }
}
