package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 * https://www.acmicpc.net/problem/1013
 */
public class _1013 {

    private static final Pattern WAVE_PATTERN = Pattern.compile("(100+1+|01)+");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String string = br.readLine();
            System.out.println(WAVE_PATTERN.matcher(string).matches() ? "YES" : "NO");
        }
    }
}
