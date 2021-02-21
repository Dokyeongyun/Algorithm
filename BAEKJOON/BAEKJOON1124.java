package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 */
public class BAEKJOON1124 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[100002];
        Arrays.fill(check, true);

        check[1] = false;
        check[0] = false;
        int[] arr = new int[100002];
        int result=0;

        for(int i=2; i<=100000; i++){
            if(check[i]){
                for(int j=i*2; j<=B; j+=i){
                    check[j] = false;
                    int curNum = j;
                    while(curNum%i == 0){
                        curNum /= i;
                        arr[j]++;
                    }
                }
            }
        }
        for(int i=A;i<=B;i++){
            if(check[arr[i]]) result++;
        }

        System.out.println(result);
    }
}
