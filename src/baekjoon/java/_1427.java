package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/1427
 */
public class _1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nArr = br.readLine().split("");

        Arrays.sort(nArr);

        StringBuilder sb = new StringBuilder();
        for(int i=nArr.length-1; i>=0; i--){
            sb.append(nArr[i]);
        }
        System.out.println(sb);
    }
}
