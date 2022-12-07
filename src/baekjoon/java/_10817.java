package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class _10817 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int[] arr = new int[]{a,b,c};
        Arrays.sort(arr);
        System.out.println(arr[1]);
    }
}
