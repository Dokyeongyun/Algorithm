package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1010
 */
public class BAEKJOON1010 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if(N==M){
                System.out.println(1);
                continue;
            }
            BigInteger nFac = factorial(N);
            BigInteger MFac = factorial(M);
            BigInteger n_mFac = factorial(M-N);

            System.out.println(MFac.divide(nFac.multiply(n_mFac)));
        }
    }

    static BigInteger factorial(long n){
        if(n==1){
            return BigInteger.valueOf(1);
        }
        return BigInteger.valueOf(n).multiply(factorial(n-1));
    }
}
