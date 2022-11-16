package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.acmicpc.net/problem/2671
 */
public class _2671 {

    private static final Pattern pattern = Pattern.compile("^(100+1+|01)+$");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String string = br.readLine();
        Matcher matcher = pattern.matcher(string);
        System.out.println(matcher.matches() ? "SUBMARINE" : "NOISE");
    }
}
