package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/9935
 */
public class BAEKJOON9935 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String origin = br.readLine();
        String remove = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < origin.length(); i++) {
            stack.push(origin.charAt(i));

            if (stack.size() >= remove.length()) {
                boolean flag = true;
                for (int j = 0; j < remove.length(); j++) {
                    if (stack.get(stack.size() - remove.length() + j) != remove.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j = 0; j < remove.length(); j++) stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : stack) sb.append(ch);
        System.out.println(sb.length() > 0 ? sb.toString() : "FRULA");
    }
}
