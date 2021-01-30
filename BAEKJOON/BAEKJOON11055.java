package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11055
 */
public class BAEKJOON11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for(int i=0; i<N; i++){
            dp[i] = arr[i];
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i] && dp[j] + arr[i] > dp[i]){
                    dp[i] = dp[j] + arr[i];
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);

    }
}
