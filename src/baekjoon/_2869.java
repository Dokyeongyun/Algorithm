package baekjoon;

import java.util.Scanner;

public class _2869 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();
        int B = scan.nextInt();
        int V = scan.nextInt();

        int day = (V - B) / (A - B);

        if ((V - B) % (A - B) != 0) {
            day++;
        }
        System.out.println(day);
    }
}
