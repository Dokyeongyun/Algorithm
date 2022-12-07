package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1863
 */
public class _1863 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];

        int min = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i] = y;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= N; i++) {
            while (true) {
                if (stack.empty()) break;
                if (stack.peek() <= arr[i]) break;
                stack.pop();
                min++;
            }

            if (!stack.empty() && stack.peek() == arr[i]) continue;

            stack.push(arr[i]);
        }

        System.out.println(min);
    }
}
