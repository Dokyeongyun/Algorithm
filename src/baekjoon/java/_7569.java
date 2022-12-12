package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
문제
철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다.
토마토는 아래의 그림과 같이 격자모양 상자의 칸에 하나씩 넣은 다음, 상자들을 수직으로 쌓아 올려서 창고에 보관한다.



창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다.
보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
하나의 토마토에 인접한 곳은 위, 아래, 왼쪽, 오른쪽, 앞, 뒤 여섯 방향에 있는 토마토를 의미한다.
대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다.
철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지 그 최소 일수를 알고 싶어 한다.

토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,
며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.

입력
첫 줄에는 상자의 크기를 나타내는 두 정수 M,N과 쌓아올려지는 상자의 수를 나타내는 H가 주어진다.
M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M ≤ 100, 2 ≤ N ≤ 100, 1 ≤ H ≤ 100 이다.
둘째 줄부터는 가장 밑의 상자부터 가장 위의 상자까지에 저장된 토마토들의 정보가 주어진다.
즉, 둘째 줄부터 N개의 줄에는 하나의 상자에 담긴 토마토의 정보가 주어진다.
각 줄에는 상자 가로줄에 들어있는 토마토들의 상태가 M개의 정수로 주어진다.
정수 1은 익은 토마토, 정수 0 은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
이러한 N개의 줄이 H번 반복하여 주어진다.

출력
여러분은 토마토가 모두 익을 때까지 최소 며칠이 걸리는지를 계산해서 출력해야 한다.
만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
 */
public class _7569 {
    static int[][][] arr;
    static int n, m, h, count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        arr = new int[n][m][h];

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        bfs();
        System.out.println(countDay()-1);

    }

    public static int countDay() {
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j][k] == 0) {
                        return 0;
                    }
                    count = Math.max(count, arr[i][j][k]);
                }
            }
        }
        return count;
    }

    public static void bfs() {
        Queue<Node> que = new LinkedList<>();

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j][k] == 1) {
                        que.add(new Node(i, j, k));
                    }
                }
            }
        }

        while (!que.isEmpty()) {
            Node currentNode = que.poll();
            int x = currentNode.x;
            int y = currentNode.y;
            int z = currentNode.z;

            // 상
            if (x - 1 >= 0 && arr[x - 1][y][z] == 0) {
                arr[x - 1][y][z] = arr[x][y][z] + 1;
                que.add(new Node(x - 1, y, z));
            }
            // 하
            if (x + 1 < n && arr[x + 1][y][z] == 0) {
                arr[x + 1][y][z] = arr[x][y][z] + 1;
                que.add(new Node(x + 1, y, z));
            }
            // 좌
            if (y - 1 >= 0 && arr[x][y - 1][z] == 0) {
                arr[x][y - 1][z] = arr[x][y][z] + 1;
                que.add(new Node(x, y - 1, z));
            }
            // 우
            if (y + 1 < m && arr[x][y + 1][z] == 0) {
                arr[x][y + 1][z] = arr[x][y][z] + 1;
                que.add(new Node(x, y + 1, z));
            }
            // 위
            if (z - 1 >= 0 && arr[x][y][z - 1] == 0) {
                arr[x][y][z - 1] = arr[x][y][z] + 1;
                que.add(new Node(x, y, z - 1));
            }
            // 아래
            if (z + 1 < h && arr[x][y][z + 1] == 0) {
                arr[x][y][z + 1] = arr[x][y][z] + 1;
                que.add(new Node(x, y, z + 1));
            }
        }
    }

    static class Node {
        int x;
        int y;
        int z;

        Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}