package baekjoon;

import java.io.*;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/10989
 */
public class _10989 {
    static StringBuffer sb = new StringBuffer();
    static int[] count = new int[10001];
    static int N;
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        countingSort();

    }
    static void countingSort() throws IOException{
        for(int i=0; i<N; i++){
            count[Integer.parseInt(br.readLine())]++;
        }

        for(int i = 1; i < 10001; i++){
            while(count[i] > 0){
                sb.append(i).append('\n');
                count[i]--;
            }
        }
        System.out.println(sb);
    }

    /**
     * dual-pivot Quick sort
     * 평균 O(nlogn)
     * 최악 O(n^2)
     */
    static void arrSortFun() throws IOException {
        int[] arr = new int[N];
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for (int j : arr) {
            sb.append(j).append("\n");
        }
        System.out.println(sb);
    }
}
