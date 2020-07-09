package Algorithm.Section6;

import java.util.Scanner;

/*
        [Section6 : 소수 구하기]
            특정 범위내의 모든 소수를 구하는 문제
 */
public class FindPrimeNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("[소수 찾기 프로그램]");
        System.out.println("범위를 입력하세요.");
        System.out.print("최솟값: ");
        int min = scan.nextInt();
        System.out.print("최댓값: ");
        int max = scan.nextInt();

        int i, j;
        int index = 0;
        for (i = min; i <= max; i++) {
            for (j = 2; j < i; j++) {
                if (i % j == 0) {
                    break;
                }
            }
            if (i == j) {
                System.out.print(i + "\t");
                index++;
                if (index % 8 == 0) {
                    System.out.println();
                }
            }
        }
    }
}
