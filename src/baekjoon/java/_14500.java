package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14500
 */
public class _14500 {

    static int N, M;
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, -1, 0, 1};
    static boolean[][] visit;
    static int[][] arr;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N][M];
        arr = new int[N][M];

        // 배열 입력받기
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // DFS
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                dfs(i, j, 0, 0);
                additional(i, j);
            }
        }
        System.out.println(max);
    }

    static void dfs(int x, int y, int depth, int sum){
        // 종료조건 -> 4개 블록체크
        if(depth == 4){
            max = Math.max(max, sum);
            return;
        }

        // 다음 칸 확인
        for(int i=0; i<4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            // 배열 범위 체크
            if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M){
                continue;
            }

            // 다음 칸 방문했는지 체크
            if(visit[nextX][nextY]){
                continue;
            }

            // 방문하지 않았다면 방문하는것으로 체크 후 DFS
            visit[nextX][nextY] = true;
            dfs(nextX, nextY, depth+1, sum + arr[nextX][nextY]);
            visit[nextX][nextY] = false;
        }
    }

    static void additional(int x, int y){
        int wing = 4;
        int min = Integer.MAX_VALUE;
        int sum = arr[x][y];
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (wing <= 2)
                return;
            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                wing--;
                continue;
            }
            min = Math.min(min, arr[nextX][nextY]);
            sum = sum + arr[nextX][nextY];
        }
        if (wing == 4) {
            sum = sum - min;
        }
        max = Math.max(max, sum);
    }
}
