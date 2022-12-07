package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/9184
 */
public class _9184 {
    static int[][][] dp = new int[21][21][21];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a==-1 && b==-1 && c==-1) break;


            if(a > 20 || b > 20 || c > 20) {
                print(a,b,c,w(20,20,20));
                continue;
            }

            if(a < 0 || b < 0 || c < 0){
                print(a,b,c,w(0,0,0));
                continue;
            }

            print(a,b,c, w(a,b,c));
        }
    }
    static void print(int a, int b, int c, int ans){
        System.out.println("w("+a+", "+b+", "+c+") = "+ans);
    }
    static int w(int a, int b, int c){
        if(dp[a][b][c] != 0){
            return dp[a][b][c];
        }
        if(a <=0 || b<=0 || c<=0){
            return 1;
        }
        if(a >20 || b>20 || c>20){
            return dp[20][20][20] = w(20,20,20);
        }
        if(a<b && b<c){
            return dp[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c);
        }
        return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }
}
