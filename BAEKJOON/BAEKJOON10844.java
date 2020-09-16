package BAEKJOON;

import java.util.Scanner;

/*
문제
45656이란 수를 보자.

이 수는 인접한 모든 자리수의 차이가 1이 난다. 이런 수를 계단 수라고 한다.

세준이는 수의 길이가 N인 계단 수가 몇 개 있는지 궁금해졌다.

N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구하는 프로그램을 작성하시오. (0으로 시작하는 수는 없다.)

입력
첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.

출력
첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.
 */
public class BAEKJOON10844 {
    public static void main(String[] args) {

        final int mod = 1000000000;

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        long [][] dp = new long[n+1][10];

        for(int i=1; i<10; i++)
            dp[1][i] = 1;

        for(int i=2; i<=n; i++) {
            for(int j=0; j<10; j++) {
                if(j == 0)
                    dp[i][j] = dp[i-1][j+1];
                else if(j == 9)
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
                dp[i][j] %= mod;
            }
        }
        long answer = 0;
        for(int i=0; i<10; i++)
            answer += dp[n][i];

        System.out.println(answer%mod);
    }
}
