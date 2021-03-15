package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1158
 */
public class BAEKJOON1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> que = new LinkedList<>();

        for(int i=0; i<N; i++) que.add(i+1);

        System.out.print("<");
        while(que.size() != 1){
            for(int i=0; i<K-1; i++) que.add(que.poll());
            System.out.print(que.poll()+", ");
        }

        System.out.print(que.poll());
        System.out.print(">");
    }
}
