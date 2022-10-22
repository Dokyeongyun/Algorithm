package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1039
 */
public class _1039 {

    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bfs(N, K);
        System.out.println(max);
    }

    static void bfs(int N, int K) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[1000001][K + 1];

        queue.add(new Node(N, 0));
        visited[N][0] = true;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            if (curNode.swapCount == K) {
                max = Math.max(max, curNode.number);
                continue;
            }

            int length = String.valueOf(curNode.number).length();
            for (int i = 0; i < length - 1; i++) {
                for (int j = i + 1; j < length; j++) {
                    int next = swap(curNode.number, i, j);
                    if (next != -1 && !visited[next][curNode.swapCount + 1]) {
                        queue.add(new Node(next, curNode.swapCount + 1));
                        visited[next][curNode.swapCount + 1] = true;
                    }
                }
            }
        }

    }

    static int swap(int number, int i, int j) {
        char[] numArr = String.valueOf(number).toCharArray();
        if (i == 0 && numArr[j] == '0') {
            return -1;
        }

        char temp;
        temp = numArr[i];
        numArr[i] = numArr[j];
        numArr[j] = temp;

        return Integer.parseInt(new String(numArr));
    }

    static class Node {
        int number;
        int swapCount;

        Node(int number, int swapCount) {
            this.number = number;
            this.swapCount = swapCount;
        }
    }
}
