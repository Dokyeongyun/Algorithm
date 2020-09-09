package BAEKJOON;

import java.util.Scanner;

/*
문제
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.

입력
첫째 줄에 1보다 크거나 같고, 10^6보다 작거나 같은 정수 N이 주어진다.

출력
첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
 */
public class BAEKJOON1463 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        // 해당 인덱스의 수를 연산하기 위한 최솟값 저장 배열
        int[] dp = new int[n + 1];

        dp[1] = 0;

        for (int i = 2; i < dp.length; i++) {

            dp[i] = dp[i - 1] + 1;

            if (i % 3 == 0) {
                if (dp[i / 3] + 1 < dp[i]) {
                    dp[i] = dp[i / 3] + 1;
                }
            }
            if (i % 2 == 0) {
                if (dp[i / 2] + 1 < dp[i]) {
                    dp[i] = dp[i / 2] + 1;
                }
            }
        }

        System.out.println(dp[n]);
/*
        for(int i=1; i<dp.length; i++){
            System.out.print(dp[i]+" ");
        }
*/

    }
}
