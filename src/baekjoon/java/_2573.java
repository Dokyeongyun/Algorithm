package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2573
 */
public class _2573 {

    static int N, M;
    static int numberOfIceBergTile = 0;
    static int[][] map;

    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    numberOfIceBergTile++;
                }
            }
        }

        int passedYear = 0;
        while (true) {
            afterOneYear();
            passedYear++;

            int checkIceBergChunkCount = checkIceBergChunkCount();
            if (checkIceBergChunkCount == 0) {
                System.out.println(0);
                return;
            }

            if (checkIceBergChunkCount != numberOfIceBergTile) {
                System.out.println(passedYear);
                return;
            }
        }

    }

    private static void afterOneYear() {
        Queue<Node> queue = new LinkedList<>();
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (map[x][y] == 0) {
                    continue;
                }

                int seaTileCount = 0;
                for (int i = 0; i < 4; i++) {
                    int nextX = x + dx[i];
                    int nextY = y + dy[i];

                    if (isBoundary(nextX, nextY) && map[nextX][nextY] == 0) {
                        seaTileCount++;
                    }
                }
                queue.add(new Node(x, y, seaTileCount));
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int value = map[node.x][node.y] - node.seaTileCount;
            if (value <= 0) {
                map[node.x][node.y] = 0;
                numberOfIceBergTile--;
            } else {
                map[node.x][node.y] = value;
            }
        }
    }

    private static int checkIceBergChunkCount() {
        boolean[][] visited = new boolean[N][M];
        Queue<Node> queue = new LinkedList<>();

        int count = 0;
        boolean isBreak = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    queue.add(new Node(i, j));
                    visited[i][j] = true;
                    isBreak = true;
                    count++;
                    break;
                }
            }
            if (isBreak) {
                break;
            }
        }

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if (!isBoundary(nextX, nextY) || visited[nextX][nextY] || map[nextX][nextY] == 0) {
                    continue;
                }

                queue.add(new Node(nextX, nextY));
                visited[nextX][nextY] = true;
                count++;
            }
        }

        return count;
    }

    private static boolean isBoundary(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    static class Node {
        int x;
        int y;
        int seaTileCount;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Node(int x, int y, int seaTileCount) {
            this.x = x;
            this.y = y;
            this.seaTileCount = seaTileCount;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d): %d", x, y, seaTileCount);
        }
    }
}
