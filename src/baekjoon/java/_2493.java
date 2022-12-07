package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2493
 */
public class _2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Tower> stack = new Stack<>();
        for (int i = 1; i <= N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                if (stack.peek().height >= temp) {
                    System.out.print(stack.peek().index + " ");
                    break;
                }
                stack.pop();
            }
            if (stack.isEmpty()) {
                System.out.print("0 ");
            }
            stack.push(new Tower(i, temp));
        }
    }

    static class Tower{
        int index;
        int height;
        Tower(int i, int h){
            this.index = i;
            this.height = h;
        }
    }
}
