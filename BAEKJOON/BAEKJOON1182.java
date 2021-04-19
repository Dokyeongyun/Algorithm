package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEKJOON1182 {
    static int N, S;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0, 0);

        if(S == 0){
            count--;
        }

        System.out.println(count);
    }
    static void dfs(int i, int sum) {
        if(i == N) {
            if(sum == S) {
                count++;
            }
            return;
        }

        dfs(i + 1, sum + arr[i]);
        dfs(i + 1, sum);
    }
}
