package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제
        7
      3   8
    8   1   0
  2   7   4   4
4   5   2   6   5
위 그림은 크기가 5인 정수 삼각형의 한 모습이다.

맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때,
이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램을 작성하라.
아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.

삼각형의 크기는 1 이상 500 이하이다. 삼각형을 이루고 있는 각 수는 모두 정수이며, 범위는 0 이상 9999 이하이다.

입력
첫째 줄에 삼각형의 크기 n(1 ≤ n ≤ 500)이 주어지고, 둘째 줄부터 n+1번째 줄까지 정수 삼각형이 주어진다.

출력
첫째 줄에 합이 최대가 되는 경로에 있는 수의 합을 출력한다.
 */
public class BAEKJOON1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //Scanner scan = new Scanner(System.in);

        //int n = scan.nextInt();
        int n = Integer.parseInt(br.readLine());


        int[][] dp = new int[n + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
                //dp[i][j] = scan.nextInt(); // 배열에 입력값 저장

                // 바로 다음 행의 값 결정
                // 왼쪽 끝에서는 항상 오른쪽위의 값, 오른쪽 끝에서는 항상 왼쪽위의 값을 더하여 저장
                // 나머지는 왼쪽위의 값을 합친 값 vs 오른쪽위의 값을 합친 값 중 최댓값을 저장
                if (i == 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j];
                } else if (i == j) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j];
                } else {
                    dp[i][j] = Math.max((dp[i - 1][j] + dp[i][j]), (dp[i - 1][j - 1] + dp[i][j]));
                }

                // 최댓값 바로 결정하기
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max);
//--------------------------------------------------
    }
}
