package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2178 {

    static int n, m;
    static int[][] arr;
    static boolean[][] check;

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        m = scan.nextInt();

        arr = new int[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = scan.next();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        System.out.println(arr[n-1][m-1]);
    }

    public static void bfs(int x, int y) {

        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y));
        check[x][y] = true;

        while (!que.isEmpty()) {
            Node node = que.poll();

            for (int i = 0; i < 4; i++) {

                int nextX = node.x + dx[i];
                int nextY = node.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
                    continue;
                }

                if (check[nextX][nextY] || arr[nextX][nextY] == 0) {
                    continue;
                }

                que.add(new Node(nextX, nextY));
                check[nextX][nextY] = true;

                arr[nextX][nextY] = arr[node.x][node.y] + 1;
            }
        }
    }

    public static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
