package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/16946
 */
public class _16946 {

    static int N, M;
    static boolean[][] visit;
    static int[][] map;
    static MovableNodePath[][] movableNodeCount;

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        movableNodeCount = new MovableNodePath[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        int id = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !visit[i][j]) {
                    init(i, j, id++);
                }
            }
        }

        int[][] result = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    List<Integer> ids = new ArrayList<>();
                    int value = 0;
                    for (int k = 0; k < 4; k++) {
                        int nextX = i + dx[k];
                        int nextY = j + dy[k];
                        if (isBoundary(nextX, nextY)) {
                            MovableNodePath path = movableNodeCount[nextX][nextY];
                            if (path == null || ids.contains(path.id)) {
                                continue;
                            }
                            ids.add(path.id);
                            value += path.numberOfNodes;
                        }
                    }
                    result[i][j] = (value + 1) % 10;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(result[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void init(int x, int y, int id) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visit[x][y] = true;

        int numberOfNodes = 1;
        List<Node> visitNodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            visitNodes.add(curNode);

            for (int i = 0; i < 4; i++) {
                int nextX = curNode.x + dx[i];
                int nextY = curNode.y + dy[i];

                if (!isBoundary(nextX, nextY)
                        || visit[nextX][nextY]
                        || map[nextX][nextY] == 1) {
                    continue;
                }

                queue.add(new Node(nextX, nextY));
                visit[nextX][nextY] = true;
                numberOfNodes++;
            }
        }

        for (Node node : visitNodes) {
            movableNodeCount[node.x][node.y] = new MovableNodePath(id, numberOfNodes);
        }
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
    }

    static class MovableNodePath {
        int id;
        int numberOfNodes;

        MovableNodePath(int id, int numberOfNodes) {
            this.id = id;
            this.numberOfNodes = numberOfNodes;
        }
    }
}
