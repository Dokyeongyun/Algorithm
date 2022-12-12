package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();

        int max = 0;
        int sixAndNineCount = 0;

        int[] countArr = new int[10];
        for (char c : n.toCharArray()) {
            int num = Integer.parseInt(String.valueOf(c));

            countArr[num] += 1;
            if (num == 6 || num == 9) {
                sixAndNineCount += 1;
                max = Math.max(max, sixAndNineCount / 2 + sixAndNineCount % 2);
            } else {
                max = Math.max(max, countArr[num]);
            }
        }

        System.out.println(max);
    }
}
