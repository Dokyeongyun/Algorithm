package baekjoon;

import java.util.Scanner;

public class _2577 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int A = scan.nextInt();
        int B = scan.nextInt();
        int C = scan.nextInt();
        int mul = A * B * C;

        String[] mul_string = String.valueOf(mul).split("");

        int[] number = new int[10];
        for (int i = 0; i < number.length; i++) {
            number[i] = i;
        }

        int[] count = new int[10];
        for (int i = 0; i < mul_string.length; i++) {
            for (int j = 0; j < number.length; j++) {
                if (Integer.parseInt(mul_string[i]) == number[j]) {
                    count[number[j]]++;
                }
            }
        }


        System.out.println(mul);

        System.out.println("number");
        for(int i=0; i<number.length; i++){
            System.out.print(number[i]+" ");
        }

        System.out.println();
        System.out.println("count");
        for(int i=0; i<count.length; i++){
            System.out.print(count[i]+" ");
        }
    }
}
