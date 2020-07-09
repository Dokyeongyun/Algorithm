package Algorithm.Section5;
/*
        [Section5 : 임의의 숫자 배수의 개수와 합 구하기]
            특정 범위내에 입력받은 수의 배수의 개수와 배수들의 총 합을 구하는 문제
 */

import java.util.Scanner;

public class NumberOfMultipleAndSum {
    public static void main(String[] args) {
        System.out.println("[임의의 숫자의 배수의 갯수와 총 합 구하기 프로그램]");
        System.out.println("숫자를 입력하세요.");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println("범위를 입력하세요.");
        System.out.print("최솟값: ");
        int min = scan.nextInt();
        System.out.print("최댓값: ");
        int max = scan.nextInt();

        int count = 0;
        int sum = 0;
        for (int i = min; i < max + 1; i++) {
            if (i%n==0) {
                count++;
                sum += i;
            }
        }
        System.out.println("배수의 갯수: " + count);
        System.out.println("배수들의 합: " + sum);
    }
}
