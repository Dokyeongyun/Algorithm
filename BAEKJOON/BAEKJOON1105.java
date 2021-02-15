package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1105
 */
public class BAEKJOON1105 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] L = st.nextToken().split("");
        String[] R = st.nextToken().split("");

        int count = 0;
        // 자리수가 다르면 최소 8의 개수는 무조건 0
        if(L.length == R.length){
            for(int i=0; i<L.length; i++){
                if(!L[i].equals(R[i])) break;
                if(L[i].equals("8") && R[i].equals("8")) count++;
            }
        }

        System.out.println(count);
    }
}
