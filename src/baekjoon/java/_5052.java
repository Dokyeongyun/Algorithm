package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            String[] phoneNumbers = new String[n];
            for (int i = 0; i < n; i++) {
                phoneNumbers[i] = br.readLine();
            }
            Arrays.sort(phoneNumbers);

            boolean isConsistent = true;
            for (int i = 1; i < phoneNumbers.length; i++) {
                if (phoneNumbers[i].startsWith(phoneNumbers[i - 1])) {
                    isConsistent = false;
                    break;
                }
            }

            System.out.println(isConsistent ? "YES" : "NO");
        }
    }
}