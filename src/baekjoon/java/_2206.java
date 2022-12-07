package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
문제
N×M의 행렬로 표현되는 맵이 있다. 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다.
당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 이때 최단 경로로 이동하려 한다.
최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함해서 센다.

만약에 이동하는 도중에 한 개의 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 한 개 까지 부수고 이동하여도 된다.

맵이 주어졌을 때, 최단 경로를 구해 내는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000)이 주어진다. 다음 N개의 줄에 M개의 숫자로 맵이 주어진다. (1, 1)과 (N, M)은 항상 0이라고 가정하자.

출력
첫째 줄에 최단 거리를 출력한다. 불가능할 때는 -1을 출력한다.
 */
public class _2206 {
    static int n, m;
    static int[][] arr;
    static int[][] count;
    static boolean[][][] check;
    static int min = 0;
    static boolean b;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");

        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        arr = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 1; j < m + 1; j++) {
                arr[i][j] = Integer.parseInt(temp[j - 1]);
            }
        }

        bfs();

    }

    public static void bfs() {
        check = new boolean[n + 1][m + 1][2];

        Queue<Node> que = new LinkedList<>();

        check[1][1][1] = true;
        que.add(new Node(1, 1, 1));

        loop:
        while (!que.isEmpty()) {
            int size = que.size();

            for (int x = 0; x < size; x++) {
                Node cur = que.poll();

                if(cur.x == n && cur.y == m) {
                    min++;
                    b = true;
                    break loop;
                }

                for (int y = 0; y < 4; y++) {
                    int nextX = cur.x + dx[y];
                    int nextY = cur.y + dy[y];

                    if (nextX < 1 || nextX > n || nextY < 1 || nextY > m) {
                        continue;
                    }

                    if (arr[nextX][nextY] == 1) {
                        if (cur.d > 0 && !check[nextX][nextY][0]) {
                            check[nextX][nextY][0] = true;
                            que.add(new Node(nextX, nextY, 0));
                        }
                    } else {
                        if (check[nextX][nextY][cur.d]) {
                            continue;
                        }
                        check[nextX][nextY][cur.d] = true;
                        que.add(new Node(nextX, nextY, cur.d));
                    }
                }
            }
            min++;
        }

        System.out.println(b ? min : -1);
    }

    public static class Node {
        int x;
        int y;
        int d;

        Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

/*
    public static int bfs(int i, int j) {

        int[][] tempArr = new int[n + 1][m + 1];
        for (int x = 1; x < n + 1; x++) {
            for (int y = 1; y < m + 1; y++) {
                if (x == i && y == j) {
                    tempArr[x][y] = 0;
                } else {
                    tempArr[x][y] = arr[x][y];
                }
            }
        }

        count = new int[n + 1][m + 1];
        check = new boolean[n + 1][m + 1];

        Queue<Node> que = new LinkedList<>();

        que.add(new Node(1, 1));
        count[1][1] = 1;
        check[1][1] = true;

        while (!que.isEmpty()) {

            Node currentNode = que.poll();
            int currentX = currentNode.x;
            int currentY = currentNode.y;
            check[currentX][currentY] = true;

            if (currentX - 1 >= 1 && tempArr[currentX - 1][currentY] == 0 && !check[currentX - 1][currentY]) {
                que.add(new Node(currentX - 1, currentY));
                count[currentX - 1][currentY] = count[currentX][currentY] + 1;
            }
            if (currentX + 1 <= n && tempArr[currentX + 1][currentY] == 0 && !check[currentX + 1][currentY]) {
                que.add(new Node(currentX + 1, currentY));
                count[currentX + 1][currentY] = count[currentX][currentY] + 1;
            }
            if (currentY - 1 >= 1 && tempArr[currentX][currentY - 1] == 0 && !check[currentX][currentY - 1]) {
                count[currentX][currentY - 1] = count[currentX][currentY] + 1;
                que.add(new Node(currentX, currentY - 1));
            }
            if (currentY + 1 <= m && tempArr[currentX][currentY + 1] == 0 && !check[currentX][currentY + 1]) {
                que.add(new Node(currentX, currentY + 1));
                count[currentX][currentY + 1] = count[currentX][currentY] + 1;
            }
        }

        return count[n][m];
*/
/*
        for (int x = 1; x < n + 1; x++) {
            for (int y = 1; y < m + 1; y++) {
                System.out.print(count[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println();
*//*

    }

    public static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
*/
}
