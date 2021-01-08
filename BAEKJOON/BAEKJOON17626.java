package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[50001];

        int naturalNum = 1;
        for(int i=1; i<dp.length; i++){
            if(Math.sqrt(i)==naturalNum){
                naturalNum++;
                dp[i] = 1;
                continue;
            }

            dp[i] = 1 + dp[(int) (i-Math.pow((naturalNum-1),2))];
            for(int j=1; j<naturalNum; j++){
                dp[i] = Math.min(dp[i], 1 + dp[(int) (i-Math.pow(j,2))]);
            }

        }

        System.out.println(dp[n]);
    }
}
