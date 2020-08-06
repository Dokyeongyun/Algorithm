package BAEKJOON;

import java.util.Scanner;

/*
문제
주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

입력
첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

출력
주어진 수들 중 소수의 개수를 출력한다.
 */
public class BAEKJOON1978 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int count = N;

        for (int i = 0; i < N; i++) {
            int num = scan.nextInt();
            if (num == 1) {
                count--;
            } else {
                for (int j = 2; j < num; j++) {
                    if (num % j == 0) {
                        count--;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}