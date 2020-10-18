package BAEKJOON;

import java.util.Scanner;

/*
문제
배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.

입력
첫째 줄에 정렬하고자하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
 */
public class BAEKJOON1427 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[10];
        int n = scan.nextInt();
        while (n != 0) {
            arr[n % 10]++;
            n /= 10;
        }
        for (int i = 9; i >= 0; i--) {
            while (arr[i]-- > 0) {
                System.out.print(i);
            }
        }
    }
}
