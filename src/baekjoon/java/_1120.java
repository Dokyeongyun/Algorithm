package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1120
 */
public class _1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        int count = 0;
        for (int i = 0; i < B.length() - A.length() + 1; i++) {
            String temp = B.substring(i, i + A.length());
            int tempCount = 0;
            for (int j = 0; j < temp.length(); j++) {
                if (A.charAt(j) == temp.charAt(j)){
                    tempCount++;
                }
            }
            count = Math.max(count, tempCount);
        }

        System.out.println(A.length() - count);
    }
}
