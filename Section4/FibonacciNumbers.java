package Algorithm.Section4;

import java.util.Scanner;

/*
        [Section4 : 피보나치 수열]
            피보나치 수열 -> 0 1 2 3 5 8 13 21 34 와 같이 증가하는 수열
            f_n = f_n-1 + f_n-2
 */
public class FibonacciNumbers {
    public static void main(String[] args) {
        Scanner scan =  new Scanner(System.in);
        System.out.println("[피보나치 수 계산 프로그램]");
        System.out.println("몇 번째 피보나치 수까지 계산하시겠습니까?");
        int n = scan.nextInt();

        int[] Fibonacci = new int[n];
        Fibonacci[0] = 1;
        Fibonacci[1] = 2;
        for(int i=2; i<n; i++){
            Fibonacci[i] = Fibonacci[i-1] + Fibonacci[i-2];
        }

        for(int i=0; i<Fibonacci.length; i++){
            System.out.print(Fibonacci[i]+"     ");
            if((i+1)%12==0){
                System.out.println();
            }
        }
    }
}
