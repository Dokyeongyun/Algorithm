package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1024
 */
public class _1024 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());


        for (int i = L; i <= 100; i++) {
            int temp = N - i * (i + 1) / 2;
            if (temp % i == 0) {
                int j=temp/i+1;
                if(j>=0){
                    for(int k=0; k<i; k++){
                        System.out.print((k+j)+" ");
                    }
                    System.out.println();
                    return;
                }
            }
        }

        System.out.println(-1);
    }
}
