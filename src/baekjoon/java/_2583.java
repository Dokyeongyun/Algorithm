package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _2583 {

    static int M, N, K;
    static int[][] map;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static List<Integer> list = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int p = y1; p < y2; p++) {
                for (int q = x1; q < x2; q++) {
                    map[p][q] = 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    count = 0;
                    DFS(i, j);
                    list.add(count);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+" ");
        }

    }

    static void DFS(int x, int y) {
        map[x][y] = 1;
        count++;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) continue;
            if (map[nextX][nextY] != 0) continue;

            DFS(nextX, nextY);
        }
    }
}
