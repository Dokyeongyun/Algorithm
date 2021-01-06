package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/5525
 */
public class BAEKJOON5525 {

    static String[] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int length = Integer.parseInt(br.readLine());
        arr = br.readLine().split("");

        int answer = 0;
        int pattern = 0;
        for(int i=0; i<arr.length-2; i++){
            if(arr[i].equals("I") && arr[i+1].equals("O") && arr[i+2].equals("I")){
                pattern++;
                if(pattern==N){
                    pattern--;
                    answer++;
                }
                i++;
            }else{
                pattern = 0;
            }
        }
        System.out.println(answer);

    }

}
