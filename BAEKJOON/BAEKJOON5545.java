package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BAEKJOON5545 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = c / a;

        Arrays.sort(arr, Collections.reverseOrder());

        int tempP = a;
        int tempC = c;
        for (int i = 0; i < n; i++) {
            tempP += b;
            tempC += arr[i];
            int temp = tempC / tempP;

            if (ans > temp) {
                break;
            }

            ans = temp;
        }
        System.out.println(ans);
    }
}
