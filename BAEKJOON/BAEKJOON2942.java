package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON2942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());


        int gcd = getGCD(R, G);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <=gcd; i++){
            if(gcd % i == 0){
                sb.append(i).append(" ").append(R / i).append(" ").append(G / i).append("\n");
            }
        }
        System.out.println(sb);
    }

    static int getGCD(int a, int b) {
        int temp = 0;
        while (a != 0) {
            if (a < b) {
                temp = a;
                a = b;
                b = temp;
            }
            a = a - b;
        }

        return b;
    }
}
