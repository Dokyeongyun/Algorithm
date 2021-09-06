package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://www.acmicpc.net/problem/2257
 */
public class BAEKJOON2257 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        Deque<Integer> deque = new ArrayDeque<>();
        int before = 0;
        deque.push(0);

        for (char c : arr) {
            if (c == '(') {
                deque.push(0);
            } else if (c == ')') {
                before = deque.pop();
                deque.push(deque.pop() + before);
            } else if (c >= '2' && c <= '9') {
                deque.push(deque.pop() + before * (c - '0' - 1));
            } else {
                if (c == 'H') {
                    before = 1;
                } else if (c == 'C') {
                    before = 12;
                } else {
                    before = 16;
                }
                deque.push(deque.pop() + before);
            }
        }

        System.out.println(deque.pop());
    }
}
