package BAEKJOON;

import java.util.Scanner;

/*
문제
세준이는 크기가 N×N인 배열 A를 만들었다. 배열에 들어있는 수 A[i][j] = i×j 이다.
이 수를 일차원 배열 B에 넣으면 B의 크기는 N×N이 된다. B를 오름차순 정렬했을 때, B[k]를 구해보자.

배열 A와 B의 인덱스는 1부터 시작한다.

입력
첫째 줄에 배열의 크기 N이 주어진다. N은 10^5보다 작거나 같은 자연수이다.
둘째 줄에 k가 주어진다. k는 min(10^9, N^2)보다 작거나 같은 자연수이다.

출력
B[k]를 출력한다.
 */
public class BAEKJOON1300 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();

        long min = 1;
        long max = k;
        long ans = 0;

        while (min <= max) {
            long mid = (min + max) / 2;
            long count = 0;

            for (int i = 1; i <= n; i++) {
                count += Math.min(mid / i, n);
            }

            if (count < k) {
                min = mid + 1;
            } else {
                ans = mid;
                max = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
