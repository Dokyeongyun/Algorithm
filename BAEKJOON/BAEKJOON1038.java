package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.acmicpc.net/problem/1038
 */
public class BAEKJOON1038 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if(N > 1022){
            System.out.println(-1);
            return;
        }

        ArrayList<Long> list = new ArrayList<>();

        for(int i=0; i<10; i++) getDecreaseNum(i, 1, list);
        Collections.sort(list);
        System.out.println(list.get(N));
    }

    static ArrayList<Long> getDecreaseNum(long num, int temp, ArrayList<Long> list){
        if(temp > 10) return list;
        list.add(num);
        for(int i=0; i<10; i++) if(num%10 > i) getDecreaseNum((num*10)+i, temp+1, list);
        return list;
    }
    // 시간초과
/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        int i=0;
        while(count != N){
            if(isDecreaseNum(i)) count++;
            i++;
        }

        System.out.println(i);
    }

    static boolean isDecreaseNum(int n){
        String[] split = String.valueOf(n).split("");
        for(int i=split.length-1; i>0; i--){
            if(Integer.parseInt(split[i]) >= Integer.parseInt(split[i-1])) return false;
        }
        return true;
    }*/
}
