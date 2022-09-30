package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/3987
 */
public class _3987 {
    static int N, M, PR, PC;
    static char[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        st = new StringTokenizer(br.readLine());
        PR = Integer.parseInt(st.nextToken()) - 1;
        PC = Integer.parseInt(st.nextToken()) - 1;

        int max = 0;
        int dir = 0;

        for (int i = 0; i < 4; i++) {
            int cr = PR;
            int cc = PC;
            int cd = i;
            int index = 1;
            while (true) {
                int nr = cr + dr[cd];
                int nc = cc + dc[cd];
                if (index > 250000)
                    break;
                if (nr < 0 || nr >= N || nc < 0 | nc >= M || map[nr][nc] == 'C') {
                    break;
                }
                if (map[nr][nc] == '/' || map[nr][nc] == '\\') {
                    cd = change(map[nr][nc], cd);
                }
                cr = nr;
                cc = nc;
                index++;
            }
            if (max < index) {
                max = index;
                dir = i;
            }
        }
        if (dir == 0) {
            System.out.println('U');
        } else if (dir == 2) {
            System.out.println('D');
        } else if (dir == 3) {
            System.out.println('L');
        } else if (dir == 1) {
            System.out.println('R');
        }
        
        if (max > 250000) {
            System.out.println("Voyager");
        } else {
            System.out.println(max);
        }
    }

    static int change(char c, int d) {
        int nd = 0;
        if (c == '/') {
            if (d == 0) {
                nd = 1;
            } else if (d == 1) {
                nd = 0;
            } else if (d == 2) {
                nd = 3;
            } else if (d == 3) {
                nd = 2;
            }
        } else {
            if (d == 0) {
                nd = 3;
            } else if (d == 1) {
                nd = 2;
            } else if (d == 2) {
                nd = 1;
            } else if (d == 3) {
                nd = 0;
            }
        }
        return nd;
    }
}
