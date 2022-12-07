package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1051
 */
public class _1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for(int i=0; i<N; i++){
            String[] split = br.readLine().split("");
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(split[j]);
            }
        }

        int maxSideLength = Math.max(N, M);

        int max = 0;
        // Brute force
        // 한 점에서 만들 수 있는 모든 정사각형을 체크한다.
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                for(int k=1; k<maxSideLength; k++){
                    if(i+k >= N || j+k >=M) continue;
                    int LU = arr[i][j];
                    int RU = arr[i][j+k];
                    int LD = arr[i+k][j];
                    int RD = arr[i+k][j+k];
//                    System.out.println("Size:"+((k+1)*(k+1))+ " | "+LU+" "+RU+" "+LD+" "+RD +"\n");

                    if(LU==RU && LU==LD && LU==RD) max = (int) Math.max(max, (k+1)*(k+1));
                }
            }
        }

        System.out.println(max);
    }
}
