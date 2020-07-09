package Algorithm.Section3;

/*
        [Section3 : 최대공약수 구하기]
            1. 약수 구하기
            2. 공약수 구하기
            3. 최대공약수 구하기
 */

import java.math.BigInteger;
import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println("[최대공약수 구하기 프로그램입니다]");
        System.out.println("약수를 구할 두 수를 입력하세요.");

        Scanner scan = new Scanner(System.in);
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();

        // 약수 구하기
        System.out.println("<"+num1+"의 약수>");
        for(int i=1; i<num1+1; i++){
            if(num1%i == 0 ){
                System.out.print(i+" ");
            }
        }
        System.out.println();
        System.out.println("<"+num2+"의 약수>");
        for(int i=1; i<num2+1; i++){
            if(num2%i == 0 ){
                System.out.print(i+" ");
            }
        }
        System.out.println();

        // 공약수 구하기
        int bigger = Math.max(num1, num2);
        System.out.println("<"+num1+", "+num2+"의 공약수>");
        for(int i=1; i<bigger+1; i++){
            if(num1%i ==0 && num2%i ==0){
                System.out.print(i+ " ");
            }
        }
        System.out.println();

        // 최대공약수 구하기
        int max = 1;
        System.out.println("<"+num1+", "+num2+"의 최대공약수>");
        for(int i=1; i<bigger+1; i++){
            if(num1%i ==0 && num2%i ==0){
                max = i;
            }
        }
        System.out.println(max);


        // 최대공약수 구하기  by 유클리드 호제법
        // 유클리드 호제법?
        // A = B * Q + R 일 때, gcd(A,B) = gcd(B,R) (단, A>B)
        // 예) A = 280, B = 30
        // gcd(280,30) = gcd(30,10) = gcd(10,0) = 10

        System.out.println("<"+num1+", "+num2+"의 최대공약수 -> by유클리드 호제법");
        int max2 = Math.max(num1, num2);
        int min2 = Math.min(num1, num2);
        int temp;

        while(max2!=0){
            if(max2<min2){
                temp = max2;
                max2 = min2;
                min2 = temp;
            }

            max2 -= min2;
        }
        System.out.println(min2);

        // 최대공약수 구하기 by BigInteger의 gcd()를 이용
        System.out.println("<"+num1+", "+num2+"의 최대공약수 -> BigInteger의 gcd()이용");
        BigInteger a = BigInteger.valueOf(num1);
        BigInteger b = BigInteger.valueOf(num2);
        BigInteger gcd = a.gcd(b);
        System.out.println(gcd);
    }
}
