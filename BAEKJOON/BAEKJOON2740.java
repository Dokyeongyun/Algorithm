package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
문제
N*M크기의 행렬 A와 M*K크기의 행렬 B가 주어졌을 때, 두 행렬을 곱하는 프로그램을 작성하시오.

입력
첫째 줄에 행렬 A의 크기 N 과 M이 주어진다. 둘째 줄부터 N개의 줄에 행렬 A의 원소 M개가 순서대로 주어진다.
그 다음 줄에는 행렬 B의 크기 M과 K가 주어진다. 이어서 M개의 줄에 행렬 B의 원소 K개가 차례대로 주어진다.
N과 M, 그리고 K는 100보다 작거나 같고, 행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다.

출력
첫째 줄부터 N개의 줄에 행렬 A와 B를 곱한 행렬을 출력한다. 행렬의 각 원소는 공백으로 구분한다.
 */
public class BAEKJOON2740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        int[][] matrix1 = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                matrix1[i][j] = Integer.parseInt(temp[j]);
            }
        }

        split = br.readLine().split(" ");
        int m2 = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);

        int[][] matrix2 = new int[m2][k];
        for (int i = 0; i < m2; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < k; j++) {
                matrix2[i][j] = Integer.parseInt(temp[j]);
            }
        }

        int[][] mulMatrix = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for(int l = 0; l<m; l++){
                    mulMatrix[i][j] += matrix1[i][l]*matrix2[l][j];
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(mulMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
