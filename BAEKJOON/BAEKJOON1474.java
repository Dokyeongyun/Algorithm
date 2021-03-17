package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1474
 */
public class BAEKJOON1474 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int totalLength = 0;

        String[] arr = new String[N];
        boolean[] isCapital = new boolean[N];
        int[] underBarCount = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = br.readLine();
            totalLength += arr[i].length();
            if(arr[i].charAt(0) < (int) 'a') isCapital[i] = true;
        }

//        System.out.println(Arrays.toString(isCapital));

        int diff = M - totalLength;

        int mok = diff/(arr.length-1);
        int mod = diff%(arr.length-1);

        Arrays.fill(underBarCount, mok);

        // 소문자 앞 밑줄 개수추가
        if(mod != 0){
            for(int i=1; i<isCapital.length; i++){
                if(!isCapital[i]){
                    underBarCount[i]++;
                    mod--;
                    if(mod == 0) break;
                }
            }
        }

        // 대문자 앞 밑줄 개수추가
        if(mod != 0){
            for(int i=isCapital.length-1; i>0; i--){
                if(isCapital[i]){
                    underBarCount[i]++;
                    mod--;
                    if(mod == 0) break;
                }
            }
        }

//        System.out.println(Arrays.toString(underBarCount));

        // 문자열 + 밑줄 이어서 답 만들기
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<underBarCount.length; i++){
            sb.append(arr[i-1]);
            for(int j=0; j<underBarCount[i]; j++){
                sb.append("_");
            }
        }
        sb.append(arr[N-1]);

        System.out.println(sb);
    }
}
/*
9 50
quick
Brown
fox
Jumps
over
the
lazy
dog
A
 */
