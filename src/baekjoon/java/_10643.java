package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/10643
 */
public class _10643 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] mushroomNum = new int[8];

        for(int i=0; i<mushroomNum.length; i++){
            mushroomNum[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;
        for(int i=0; i<mushroomNum.length; i++) {
            int temp = mushroomNum[i] + mushroomNum[(i+1) % 8] + mushroomNum[(i+2) % 8] +mushroomNum[(i+3) % 8];
            max = Math.max(max, temp);
        }
        System.out.println(max);

    }
}
