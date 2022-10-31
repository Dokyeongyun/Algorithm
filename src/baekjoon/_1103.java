package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1103
 */
public class _1103 {

    static final int HOLE = -1;

    static int N, M;
    static int[][] board;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = line.charAt(j);
                board[i][j] = Integer.parseInt(String.valueOf(c == 'H' ? HOLE : Integer.parseInt(String.valueOf(c))));
            }
        }

        System.out.println(bfs(new Node(0, 0)));
    }

    static int bfs(Node startNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(startNode);
        int[][] movingCount = new int[N][M];
        movingCount[startNode.x][startNode.y] = 1;
        int max = 0;

        while (!queue.isEmpty()) {
            max++;
            if (max >= 2501) {
                return -1;
            }

            int loop = queue.size();
            while (loop-- > 0) {
                Node curNode = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nextX = curNode.x + board[curNode.x][curNode.y] * dx[i];
                    int nextY = curNode.y + board[curNode.x][curNode.y] * dy[i];

                    if (!isBoundary(nextX, nextY) || board[nextX][nextY] == HOLE || movingCount[nextX][nextY] >= max) {
                        continue;
                    }

                    queue.add(new Node(nextX, nextY));
                    movingCount[nextX][nextY] = max;
                }
            }
        }

        return max;
    }

    static boolean isBoundary(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", x, y);
        }
    }
}