package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1080
 */
public class BAEKJOON1080 {
    static int N, M, count;
    static int[][] matrixA, matrixB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrixA = new int[N][M];
        matrixB = new int[N][M];

        for(int i=0; i<N; i++){
            String[] split = br.readLine().split("");
            for(int j=0; j<M; j++){
                matrixA[i][j] = Integer.parseInt(split[j]);
            }
        }

        for(int i=0; i<N; i++){
            String[] split = br.readLine().split("");
            for(int j=0; j<M; j++){
                matrixB[i][j] = Integer.parseInt(split[j]);
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(matrixA[i][j] != matrixB[i][j]) {
                    if(!boundaryCheck(i, j)){
                        System.out.println(-1);
                        return;
                    }
                    matFlip(i,j);
                }
            }
        }
        System.out.println(count);
    }

    static boolean boundaryCheck(int i, int j){
        return i <= N - 3 && j <= M - 3;
    }

    static void matFlip(int x,int y) {
        for(int i=x; i<=x+2; i++) {
            for(int j=y; j<=y+2; j++) {
                matrixA[i][j] = matrixA[i][j]==1 ? 0 : 1;
            }
        }
        count++;
    }
}
