package Algorithm.Section7;

import java.util.Scanner;

/*
        [Section7 : 지그재그 숫자 출력하기]
        홀수행은 순서대로 1 2 3 4 5
        짝수행은 역순으로 10 9 8 7 6
 */
public class ZigzagNumber {
    public static void main(String[] args) {
        System.out.println("[지그재그 숫자 출력하기 프로그램입니다.]");
        System.out.println("한 행에 출력할 숫자를 입력하세요.");

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println("출력범위를 입력하세요.");
        System.out.print("최솟값: ");
        int min = scan.nextInt();
        System.out.print("최댓값: ");
        int max = scan.nextInt();
        int loop = ((max - min + 1) / n) + 1;

        int i, j;
        for (int k = 1; k <= loop; k++) {
            if (k % 2 == 1) {
                for (i = n * (k - 1) + 1; i <= n * k; i++) {
                    System.out.print(i + " ");
                }
            } else {
                for (j = n * k; j >= n * (k - 1) + 1; j--) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }
}
