package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/17413
 */
public class _17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringBuffer sb = new StringBuffer();
        StringBuffer wordTemp = new StringBuffer();
        boolean isTagRegion = false;
        for (int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);

            if (temp == '<') {
                sb.append(wordTemp.reverse());
                wordTemp = new StringBuffer();
                isTagRegion = true;
            }

            if (isTagRegion) {
                sb.append(temp);
            } else {
                if (temp != ' ') {
                    wordTemp.append(temp);
                } else {
                    sb.append(wordTemp.reverse());
                    sb.append(' ');
                    wordTemp = new StringBuffer();
                }
            }
            if (temp == '>') {
                isTagRegion = false;
            }
        }
        sb.append(wordTemp.reverse());

        System.out.println(sb);
    }
}
