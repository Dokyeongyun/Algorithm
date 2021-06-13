package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/1339
 */
public class BAEKJOON1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        int[] alphabets = new int[26];
        for (int i = 0; i < N; i++) {
            int temp = 1;

            String s = arr[i];
            for (int j = s.length() - 1; j >= 0; j--) {
                int idx = s.charAt(j) - 'A';
                alphabets[idx] += temp;
                temp *= 10;
            }
        }

        Arrays.sort(alphabets);

        int value = 9;
        int sum = 0;
        for (int i = alphabets.length - 1; i >= 0; i--) {
            if(alphabets[i]==0) continue;

            sum += alphabets[i] * value--;
        }

        System.out.println(sum);
    }
}
