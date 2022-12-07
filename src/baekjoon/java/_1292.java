package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] arr = new int[1001];

        int num = 1;
        int loopCount = 1;
        int index = 1;
        boolean check = false;
        while (true) {
            for (int i = 0; i < loopCount; i++) {
                arr[index++] = num;

                if (index == 1001) {
                    check = true;
                    break;
                }
            }
            loopCount++;
            num++;
            if (check) break;
        }

        for(int i=1; i<=1000; i++){
            arr[i] = arr[i-1] + arr[i];
        }

        System.out.println(arr[end] - arr[start-1]);

    }
}
