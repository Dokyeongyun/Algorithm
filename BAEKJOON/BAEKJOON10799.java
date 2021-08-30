package BAEKJOON;

import java.io.*;
import java.util.Stack;

public class BAEKJOON10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        Stack<Character> stack = new Stack<>();

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
                continue;
            }

            if (s.charAt(i) == ')') {
                stack.pop();

                if (s.charAt(i - 1) == '(') {
                    result += stack.size();
                } else {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
