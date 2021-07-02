package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2670
 */
public class BAEKJOON2670 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];
        for(int i=0; i<N; i++){
            arr[i] = Double.parseDouble(br.readLine());
        }

        double max = arr[0];

        for(int i=1; i<N; i++){
            arr[i] = Math.max(arr[i], arr[i-1] * arr[i]);
            max = Math.max(max, arr[i]);
        }

        System.out.printf("%.3f", max);
    }
}
