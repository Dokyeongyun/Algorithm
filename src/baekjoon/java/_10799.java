package baekjoon;

import java.io.*;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/10799
 */
public class _10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String brackets = br.readLine();

        boolean isPreviousBracketOpen = false;
        int numberOfPiece = 0;

        Stack<Character> stack = new Stack<>();
        for (Character c : brackets.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push(c);
                    isPreviousBracketOpen = true;
                    break;
                case ')':
                    stack.pop();
                    if (isPreviousBracketOpen) {
                        numberOfPiece += stack.size();
                    } else {
                        numberOfPiece++;
                    }
                    isPreviousBracketOpen = false;
                    break;
            }
        }

        System.out.println(numberOfPiece);
    }

}
