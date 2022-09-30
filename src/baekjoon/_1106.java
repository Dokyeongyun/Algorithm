package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1106 {
    static final int INF = Integer.MAX_VALUE-10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] dp = new int[C+101]; // 달성고객 + 최대 도시고객
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());
            for(int j=temp2; j<dp.length; j++) {
                dp[j] = Math.min(dp[j], temp1 + dp[j - temp2]);
            }
        }

        int min = INF;
        for(int i=C; i<C+101; i++) {
            min = Math.min(min, dp[i]);
        }

        System.out.println(min);
    }

}
