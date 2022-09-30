package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2210
 */
public class _2210 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static List<String> list = new LinkedList<>();
    static int[][] board = new int[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자판 입력 받기
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        String temp = "";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                DFS(i, j, 0, temp);
            }
        }

        System.out.println(list.size());
    }

    static void DFS(int x, int y, int d, String temp) {
        // 6자리가 되면 list에 있는지 체크 후 없다면 추가하기
        if (d == 6) {
            if (!list.contains(temp)) {
                list.add(temp);
            }
            return;
        }

        // 상하좌우 4방향으로 이동하면서 문자열 늘리기
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            // 숫자판 범위 밖이면 continue;
            if (nextX < 0 || nextX >= 5 || nextY < 0 || nextY >= 5) continue;

            DFS(nextX, nextY, d + 1, temp + board[x][y]);
        }
    }
}
