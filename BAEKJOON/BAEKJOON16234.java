package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BAEKJOON16234 {

    static int N, L, R;
    static int[][] arr;
    static int[][] visit;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int count = 0;
        while (true) {
            visit = new int[N][N];
            int result = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visit[i][j] >= 1) {
                        continue;
                    }
                    result += BFS(i, j);
                }
            }

            if (result == 0) {
                break;
            }

            count++;

        }

        System.out.println(count);
    }

    static int BFS(int sX, int sY) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(sX, sY));

        List<Node> visitList = new ArrayList<>();
        visitList.add(new Node(sX, sY));
        visit[sX][sY] = 1;

        while (!que.isEmpty()) {
            Node curNode = que.poll();
            int curX = curNode.x;
            int curY = curNode.y;

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                    continue;
                }

                if (visit[nextX][nextY] >= 1) {
                    continue;
                }

                int diff = Math.abs(arr[curX][curY] - arr[nextX][nextY]);
                if (L > diff || diff > R) {
                    continue;
                }
                que.add(new Node(nextX, nextY));
                visit[nextX][nextY] = visit[curX][curY] + 1;
                visitList.add(new Node(nextX, nextY));
            }
        }

//        System.out.println(visitList);
        int sum = 0;
        for (Node node : visitList) {
            sum += arr[node.x][node.y];
        }

        for (Node node : visitList) {
            arr[node.x][node.y] = sum / visitList.size();
        }

        for (int i = 0; i < arr.length; i++) {
//            System.out.println(Arrays.toString(arr[i]));
        }

        return visitList.size() - 1;
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
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
