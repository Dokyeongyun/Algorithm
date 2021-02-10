package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1449
 */
public class BAEKJOON1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int tapeRange = (int)(arr[0] - 0.5 + L);
        int ans = 1;

        Arrays.sort(arr);

        for(int i=1; i<arr.length; i++) {
            if (tapeRange < (int)(arr[i] + 0.5)){
                tapeRange = (int)(arr[i] - 0.5 + L);
                ans++;
            }
        }

        System.out.println(ans);
    }
}
