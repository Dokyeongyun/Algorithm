package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.acmicpc.net/problem/4358
 */
public class _4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfTree = 0;
        Map<String, Integer> map = new HashMap<>();
        while (true) {
            String tree = br.readLine();
            if (tree == null || tree.isEmpty()) {
                break;
            }

            if (map.containsKey(tree)) {
                map.put(tree, map.get(tree) + 1);
            } else {
                map.put(tree, 1);
            }

            numberOfTree++;
        }

        int finalNumberOfTree = numberOfTree;
        map.keySet()
                .stream()
                .sorted()
                .forEach(t -> {
                    double per = (map.get(t) * 100.0) / finalNumberOfTree;
                    System.out.printf("%s %.4f\n", t, per);
                });
    }
}
