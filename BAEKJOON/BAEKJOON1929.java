package BAEKJOON;
/*
문제
M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

출력
한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
 */
import java.util.Scanner;

public class BAEKJOON1929 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int M = scan.nextInt();
        int N = scan.nextInt();

        boolean[] primeNum = new boolean[N+1];

        primeNum[1] = true;

        for(int i=2;i<primeNum.length; i++){
            for(int j=2; i*j<primeNum.length; j++){
                primeNum[i*j] = true;
            }
        }

        for(int i=M; i<=N; i++){
            if(!primeNum[i]){
                System.out.println(i);
            }
        }
    }
}
