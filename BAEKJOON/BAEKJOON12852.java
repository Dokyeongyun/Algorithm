package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BAEKJOON12852 {
    static int N;
    private static int dp[][] = new int[(int)(1e+6)+1][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(br.readLine());
        for(int i = 0; i<dp.length; i++){
            dp[i][0] = Integer.MAX_VALUE; } dp[N][0] = 0; calc(N);
        sb.append(dp[1][0] + "\n");
        Stack<Integer> list = new Stack<>();
        int i = 1; if(N == 2){
            sb.append("2 ");
        }else{
            while(list.size() != dp[1][0]) {
                list.push(i = dp[i][1]);
            }
            while(!list.isEmpty()){
                sb.append(list.pop() + " ");
            }
        }
        sb.append("1");
        System.out.println(sb);
    }
    private static void calc(int N) throws IOException {
        if(N == 1){
            return;
        }
        if(N % 3 == 0){
            if(dp[N / 3][0] >= dp[N][0] + 1){
                dp[N / 3][0] = dp[N][0] + 1; dp[N / 3][1] = N;
                calc(N / 3);
            }
        }
        if(N % 2 == 0){
            if(dp[N / 2][0] >= dp[N][0] + 1){
                dp[N / 2][0] = dp[N][0] + 1; dp[N / 2][1] = N;
                calc(N / 2);
            }
        }
        if(dp[N - 1][0] >= dp[N][0] + 1){
            dp[N - 1][0] = dp[N][0] + 1; dp[N - 1][1] = N;
            calc(N - 1);
        }
    }

}
