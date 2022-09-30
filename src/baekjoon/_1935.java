package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String equation = br.readLine();

        double[] number = new double[27];
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < equation.length(); i++) {
            int temp = equation.charAt(i);

            if (temp >= 'A' && temp <= 'Z') {
                stack.push(number[temp - 'A']);
            } else {
                double num1 = stack.pop();
                double num2 = stack.pop();
                double result = 0;

                switch (temp) {
                    case 42:
                        result = num2 * num1;
                        break;
                    case 47:
                        result = num2 / num1;
                        break;
                    case 45:
                        result = num2 - num1;
                        break;
                }

                stack.push(result);
            }
        }

        System.out.printf("%.2f", stack.pop());
    }
}
