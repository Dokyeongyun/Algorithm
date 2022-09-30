package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/16637
 */
public class _16637 {

    static int[] numbers;
    static char[] operators;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String line = br.readLine();
        numbers = new int[N / 2 + 1];
        operators = new char[N / 2];

        int index = 0;
        int index2 = 0;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 1) {
                operators[index2++] = line.charAt(i);
            } else {
                numbers[index++] = Integer.parseInt(String.valueOf(line.charAt(i)));
            }
        }

        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(operators));
        dfs(0, numbers[0]);
        System.out.println(max);
    }

    public static void dfs(int idx, int sum) {
        if (idx == operators.length) {
            max = Math.max(max, sum);
            return;
        }

        dfs(idx + 1, operate(operators[idx], sum, numbers[idx + 1]));
        if (idx + 2 <= operators.length) {
            dfs(idx + 2, operate(operators[idx], sum, operate(operators[idx + 1], numbers[idx + 1], numbers[idx + 2])));
        }
    }

    static int operate(char operator, int num1, int num2) {
        if (operator == '+') {
            return num1 + num2;
        } else if (operator == '-') {
            return num1 - num2;
        } else {
            return num1 * num2;
        }
    }
}
