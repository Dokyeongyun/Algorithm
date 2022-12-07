package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2823
 */
public class _2823 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] map = new char[r][c];

        for (int i = 0; i < r; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                map[i][j] = temp[j].charAt(0);
            }
        }

        int ans = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int cnt = 0;
                if (map[i][j] == '.') {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if ((0 <= x && x < r && 0 <= y && y < c)) {
                            if (map[x][y] == 'X'){
                                cnt++;
                            }
                        } else {
                            cnt++;
                        }

                        if (cnt >= 3) {
                            ans = 1;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
