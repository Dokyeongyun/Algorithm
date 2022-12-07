package baekjoon;

import java.util.Scanner;

/*
문제
0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 N(0 ≤ N ≤ 12)가 주어진다.

출력
첫째 줄에 N!을 출력한다.
 */
public class _10872 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int answer = factorial(N);

        System.out.println(answer);
    }

    public static int factorial(int n){
        if(n<=1) return 1;
        return n * factorial(n-1);
    }
}

