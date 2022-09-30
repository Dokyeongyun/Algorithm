package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class _2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger nFac = new BigInteger(String.valueOf(factorial(n)));
        BigInteger mFac = new BigInteger(String.valueOf(factorial(m)));
        BigInteger n_mFac = new BigInteger(String.valueOf(factorial(n-m)));

        System.out.println(nFac.divide(mFac).divide(n_mFac));
    }

    static BigInteger factorial(int n){
        if(n==1){
            return BigInteger.valueOf(1);
        }
        return BigInteger.valueOf(n).multiply(factorial(n-1));
    }
}
