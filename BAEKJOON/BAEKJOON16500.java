package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BAEKJOON16500 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int N = Integer.parseInt(br.readLine());

        List<String> arr = new ArrayList<>();
        int[] dp = new int[101];

        for (int i = 0; i < N; i++) {
            arr.add(br.readLine());
        }

        dp[s.length()] = 1;

        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = i + 1; j < s.length(); j++) {
                if(dp[j] == 1) {
                    if(arr.contains(s.substring(i, j))) dp[i] = 1;
                }
            }
            if(arr.contains(s.substring(i))) dp[i] = 1;
        }
        System.out.println(dp[0]);
    }
}
