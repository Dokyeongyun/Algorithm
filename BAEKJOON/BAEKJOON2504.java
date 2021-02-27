package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/2504
 */
public class BAEKJOON2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split("");
        Stack<String> stack = new Stack<>();

        for (int i=0; i<input.length; i++) {
            switch (input[i]) {
                case "(":
                    stack.push("(");
                    break;
                case "[":
                    stack.push("[");
                    break;
                case ")":
                    if (stack.peek().equals("(")) { // 괄호 안에 내용 없이 짝이 맞으면 괄호 꺼내고 값 push
                        stack.pop();
                        stack.push("2");
                    } else {
                        int temp = 0;
                        while (!stack.isEmpty()) {
                            String pop = stack.pop();
                            if (pop.equals("[") || pop.equals("]") || pop.equals(")")) { // 입력이 잘못된 경우
                                System.out.println("0");
                                return;
                            }
                            if (pop.equals("(")) {
                                // 괄호 안에 내용이 있고 짝이 맞는 경우, => 괄호 꺼내고 괄호 안의 내용 값 계산, 계산된 값 push
                                stack.push(String.valueOf(temp * 2));
                                break;
                            }
                            temp += Integer.parseInt(pop);
                        }
                        if(stack.isEmpty()){
                            System.out.println(0);
                            return;
                        }
                    }
                    break;
                case "]":
                    if (stack.peek().equals("[")) {
                        stack.pop();
                        stack.push("3");
                    } else {
                        int temp = 0;
                        while (!stack.isEmpty()) {
                            String pop = stack.pop();
                            if (pop.equals("(") || pop.equals(")") || pop.equals("]")) {
                                System.out.println(0);
                                return;
                            }
                            if (pop.equals("[")) {
                                stack.push(String.valueOf(temp * 3));
                                break;
                            }
                            temp += Integer.parseInt(pop);
                        }
                        if (stack.isEmpty()) {
                            System.out.println(0);
                            return;
                        }
                        break;
                    }
            }
        }

        int answer = 0;
        while (!stack.isEmpty()) {
            String temp = stack.pop();
            if (temp.equals("(") || temp.equals(")") || temp.equals("[") || temp.equals("]")) {
                System.out.println(0);
                return;
            }
            answer += Integer.parseInt(temp);
        }
        System.out.println(answer);
    }
}
