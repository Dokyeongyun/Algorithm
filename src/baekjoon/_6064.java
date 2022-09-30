package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/6064
 */
public class _6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 최대횟수 M*N
            int maxSize = M*N;
            boolean c = false;

            for(int i=x; i<=maxSize; i=i+M){
                int yTemp = i % N;
                if(yTemp == 0){
                    yTemp = N;
                }
                if(yTemp == y){
                    c = true;
                    System.out.println(i);
                    break;
                }
            }
            if(!c){
                System.out.println(-1);
            }


//            System.out.println(xList);
//            System.out.println(yList);
//            System.out.println();
        }
    }
}
