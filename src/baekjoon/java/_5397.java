package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/5397
 */
public class _5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        while (N-- > 0) {
            String s = br.readLine();

            Stack<Character> prev = new Stack<>();
            Stack<Character> post = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '<') {
                    if (!prev.isEmpty()){
                        post.push(prev.pop());
                    }
                } else if (s.charAt(i) == '>') {
                    if (!post.isEmpty()){
                        prev.push(post.pop());
                    }
                } else if (s.charAt(i) == '-') {
                    if (!prev.isEmpty()){
                        prev.pop();
                    }
                } else {
                    prev.push(s.charAt(i));
                }
            }

            while (!post.isEmpty()){
                prev.push(post.pop());
            }

            StringBuilder sb = new StringBuilder();
            while (!prev.isEmpty()) {
                sb.append(prev.pop());
            }
            System.out.println(sb.reverse());
        }
    }
}
