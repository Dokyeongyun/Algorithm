package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2589
 */
public class _2589 {

    static int xSize, ySize;
    static char[][] map;

    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        xSize = Integer.parseInt(st.nextToken());
        ySize = Integer.parseInt(st.nextToken());

        map = new char[xSize][ySize];

        for (int x = 0; x < xSize; x++) {
            String line = br.readLine();
            for (int y = 0; y < ySize; y++) {
                map[x][y] = line.charAt(y);
            }
        }

        int max = 0;
        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                if (map[x][y] == 'L') {
                    max = Math.max(max, bfs(new Node(x, y, 0)));
                }
            }
        }

        System.out.println(max);
    }

    static int bfs(Node startNode) {
        boolean[][] visit = new boolean[xSize][ySize];
        int[][] times = new int[xSize][ySize];
        Queue<Node> queue = new LinkedList<>();
        queue.add(startNode);
        visit[startNode.x][startNode.y] = true;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = curNode.x + dx[i];
                int nextY = curNode.y + dy[i];

                if (!isBoundary(nextX, nextY) || visit[nextX][nextY] || map[nextX][nextY] != 'L') {
                    continue;
                }

                queue.add(new Node(nextX, nextY, curNode.time + 1));
                visit[nextX][nextY] = true;
                times[nextX][nextY] = curNode.time + 1;
            }
        }

        int max = 0;
        for (int i = 0; i < times.length; i++) {
            for (int j = 0; j < times[0].length; j++) {
                if (map[i][j] == 'L') {
                    max = Math.max(max, times[i][j]);
                }
            }
        }

        return max;
    }

    static boolean isBoundary(int x, int y) {
        return x >= 0 && y >= 0 && x < xSize && y < ySize;
    }

    static class Node {
        int x;
        int y;
        int time;

        Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
