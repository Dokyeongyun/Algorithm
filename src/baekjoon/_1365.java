package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1365
 */
public class _1365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        int[] lis = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int lisLength = 1;
        lis[0] = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (lis[lisLength - 1] < numbers[i]) {
                lis[lisLength] = numbers[i];
                lisLength++;
            } else {
                int index = getLisIndex(0, lisLength - 1, numbers[i], lis);
                lis[index] = numbers[i];
            }
        }

        System.out.println(N - lisLength);
    }

    static int getLisIndex(int left, int right, int value, int[] lis) {
        int mid;

        while (left < right) {
            mid = (left + right) / 2;

            if (lis[mid] < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}
