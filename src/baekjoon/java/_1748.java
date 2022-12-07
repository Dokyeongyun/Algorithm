package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int length = 0;

/*
        // 메모리초과
        for(int i=1; i<=N; i++){
            length += String.valueOf(i).length();
        }
*/

        int div = 10;
        int add = 1;
        for(int i=1; i<=N; i++){
            if(i % div == 0){
                add++;
                div *= 10;
            }
            length += add;
        }

        System.out.println(length);
    }
}
