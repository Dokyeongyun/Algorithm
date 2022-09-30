package baekjoon;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/15829
 */
public class _15829 {
    static final int r=31;
    static final int M=1234567891;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int length = scan.nextInt();
        String string = scan.next();

        long answer=0;
        for(int i=0;i<length;i++){
            answer+=(string.charAt(i)-'a'+1)*pow(r,i);
        }
        System.out.println(answer%M);
    }
    static long pow(int a,int b){
        return b==0?1:a*pow(a,b-1)%M;
    }
}
