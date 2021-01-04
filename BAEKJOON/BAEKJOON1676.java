package BAEKJOON;

import java.util.Scanner;

public class BAEKJOON1676 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        int cnt2 = 0, cnt5 = 0;
        for(int i = 2; i <= n; i *= 2) { cnt2 += n/i; }
        for(int i = 5; i <= n; i *= 5) cnt5 += n/i;

        System.out.print(Math.min(cnt2, cnt5));
    }
}
