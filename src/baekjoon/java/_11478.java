package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.acmicpc.net/problem/11478
 */
public class _11478 {
    public static void main(String[] args) throws IndexOutOfBoundsException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            for (int j = i; j < S.length(); j++) {
                map.put(S.substring(i, j + 1), "");
            }
        }

        System.out.println(map.size());
    }
}
