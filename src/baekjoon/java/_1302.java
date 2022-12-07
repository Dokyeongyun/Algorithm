package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1302
 */
public class _1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String book = br.readLine();

            if (!map.containsKey(book)) {
                map.put(book, 1);
            } else {
                map.put(book, map.get(book) + 1);
            }
        }

        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            max = Math.max(max, entry.getValue());
        }

        List<String> maxKeys = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() == max) maxKeys.add(entry.getKey());
        }

        Collections.sort(maxKeys);

        System.out.println(maxKeys.get(0));
    }
}
