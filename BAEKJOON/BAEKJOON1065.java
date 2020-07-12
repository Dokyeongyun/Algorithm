package BAEKJOON;

import java.util.Scanner;

/*
어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다.
등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. N이 주어졌을 때,
1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.
 */
public class BAEKJOON1065 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int count = 0;
        int gap;
        for (int i = 1; i <= N; i++) {
            if (i < 100) {
                count++;
            } else {

                String[] s = String.valueOf(i).split("");
                int[] digit = new int[s.length];
                for (int k = 0; k < s.length; k++) {
                    digit[k] = Integer.parseInt(s[k]);
                }


                if (digit[0] > digit[1]) {
                    gap = digit[0] - digit[1];
                    if (digit[1] - digit[2] == gap) {
                        count++;
                    }
                } else if (digit[0] < digit[1]) {
                    gap = digit[1] - digit[0];
                    if (digit[2] - digit[1] == gap) {
                        count++;
                    }
                } else {
                    if (digit[1] == digit[2]) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
