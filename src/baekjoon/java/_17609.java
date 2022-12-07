package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String string = br.readLine();
            System.out.println(palindrome(string));
        }
    }

    static int palindrome(String s) {
        int result = 0;

        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                int tempL = left;
                int tempR = right;

                tempL++;
                while (tempL <= tempR) {
                    if (s.charAt(tempL) == s.charAt(tempR)) {
                        tempL++;
                        tempR--;
                    } else {
                        result++;
                        break;
                    }
                }
                tempL = left;
                tempR = right;

                tempR--;
                while (tempL <= tempR) {
                    if (s.charAt(tempL) == s.charAt(tempR)) {
                        tempL++;
                        tempR--;
                    } else {
                        result++;
                        break;
                    }
                }
                return result;
            }
        }
        return result;
    }
}
