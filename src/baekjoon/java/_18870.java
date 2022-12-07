package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/18870
 */
public class _18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr2 = arr.clone();
        Arrays.sort(arr2);

        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for(int n : arr2){
            if(!map.containsKey(n)){
                map.put(n, index++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n : arr){
            sb.append(map.get(n)).append(" ");
        }
        System.out.println(sb.toString());
    }
}
