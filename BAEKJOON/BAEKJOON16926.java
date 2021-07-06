package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON16926 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for(int i=0; i<N; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        int value = Math.min(N, M) / 2;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < value; j++) {
                int x = j;
                int y = j;

                int v = arr[x][y];

                for (int k = 0; k < 4; k++) {
                    int nextX = x + dx[k];
                    int nextY = y + dy[k];

                    if (nextX >= j && nextY >= j && nextX < N - j && nextY < M - j) {
                        arr[x][y] = arr[nextX][nextY];
                        x = nextX;
                        y = nextY;
                    }
                }
                arr[j + 1][j] = v;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
