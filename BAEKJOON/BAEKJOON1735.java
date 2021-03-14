package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1735
 */
public class BAEKJOON1735 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numer1 = Integer.parseInt(st.nextToken());
        int deno1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int numer2 = Integer.parseInt(st.nextToken());
        int deno2 = Integer.parseInt(st.nextToken());

        int deno = deno1 * deno2;
        int numer = numer1 * deno2 + numer2 * deno1;

        // 기약분수로 만들기 => 분자와 분모의 최대 공약수로 나누어 주면 됨
        int gcd = gcd(deno, numer);

        System.out.println(numer/gcd +" "+ deno/gcd);
    }

    // 유클리드 호제법을 이용한 최대공약수 구하기
    static int gcd(int a, int b){
        while(b!=0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
