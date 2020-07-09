package Algorithm.Section1;

import java.util.Scanner;

public class DecimalToHexadecimal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("[ 10진수 <-> 16진수 변환 프로그램입니다 ]");
        System.out.println("  10진수를 16진수로 변환하려면 [A]키를 누르고,");
        System.out.println("  16진수를 10진수로 변환하려면 [B]키를 눌러주세요.");
        System.out.println("  (9번을 입력하면 종료됩니다.)");
        String option = " ";

        while (!option.equals("9")) {
            System.out.print("Option: ");
            option = scan.next();

            if (option.equals("A") || option.equals("a")) {
                System.out.println("변환할 숫자를 입력하세요");
                System.out.print(" 입력: ");
                int input_i = scan.nextInt();
                System.out.println("16진수 값: " + Integer.toHexString(input_i) + "\n");
            } else if (option.equals("B") || option.equals("b")) {
                System.out.println("변환할 숫자를 입력하세요");
                System.out.print(" 입력: ");
                String input_s = scan.next();
                System.out.println("10진수 값: " + Integer.parseInt(input_s, 16) + "\n");
            } else if (option.equals("9")) {
                System.out.println("BYE");
            } else {
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            }
        }


        /*
       << 10진수 <-> 2, 8, 16진수 간 변환은 Integer 클래스 API 이용 >>
         [10진수 -> 2, 8, 16진수로 변환]
             10진수 -> 2진수  : Integer.toBinaryString(n);
             10진수 -> 8진수  : Integer.toOctalString(n);
             10진수 -> 16진수 : Integer.toHaxString(n);

         [2, 8, 16진수 -> 10진수로 변환]
             2진수 -> 10진수  : Integer.parseInt(s, 2);
             8진수 -> 10진수  : Integer.parseInt(s, 8);
             16진수 -> 10진수 : Integer.parseInt(s, 16);
        */
    }
}
