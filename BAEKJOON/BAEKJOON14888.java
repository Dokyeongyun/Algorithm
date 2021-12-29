package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14888
 */
public class BAEKJOON14888 {

    static int N;
    static int[] numbers;
    static int[] operators;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        operators = new int[4];
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(numbers[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int num, int depth) {
        if (depth == numbers.length) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < operators.length; i++) {
            if (operators[i] != 0) {
                operators[i]--;

                switch (i) {
                    case 0:
                        dfs(num + numbers[depth], depth + 1);
                        break;
                    case 1:
                        dfs(num - numbers[depth], depth + 1);
                        break;
                    case 2:
                        dfs(num * numbers[depth], depth + 1);
                        break;
                    case 3:
                        dfs(num / numbers[depth], depth + 1);
                        break;
                }
                operators[i]++;
            }
        }
    }
}