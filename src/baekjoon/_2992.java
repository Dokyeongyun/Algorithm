package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2992
 */
public class _2992 {
    static int n, min = Integer.MAX_VALUE;
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        n = Integer.parseInt(s);
        char[] arr = s.toCharArray();

        permutation(arr, 0, arr.length);
        if (check) {
            System.out.println(min);
        } else {
            System.out.println(0);
        }
    }

    static void permutation(char[] arr, int start, int depth) {
        if (start == depth - 1) {
            int sum = 0;
            for (int i = 0; i < depth; i++) {
                sum += Math.pow(10, (depth - i - 1)) * (arr[i] - '0');
            }
            if (n < sum) {
                if (min > sum) {
                    min = sum;
                    check = true;
                }
            }
            return;
        }
        for (int i = start; i < depth; i++) {
            swap(arr, i, start);
            permutation(arr, start + 1, depth);
            swap(arr, i, start);
        }
    }

    static void swap(char[] arr, int x, int y) {
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
