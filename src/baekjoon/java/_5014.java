package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/5014
 */
public class _5014 {

    static final int MIN_STAIR = 1;
    static int MAX_STAIR;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        if (S == G) {
            System.out.println(0);
            return;
        }

        MAX_STAIR = F;
        int result = bfs(S, G, U, D);
        if (result == 0) {
            System.out.println("use the stairs");
        } else {
            System.out.println(result);
        }
    }

    private static int bfs(int startStair, int destinationStair, int upStairUnit, int downStairUnit) {
        boolean[] visited = new boolean[MAX_STAIR + 1];
        int[] buttonClickCounts = new int[MAX_STAIR + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startStair);
        visited[startStair] = true;

        boolean canGo = false;
        while (!queue.isEmpty()) {
            int curStair = queue.poll();

            int nextUpStair = curStair + upStairUnit;
            if (nextUpStair <= MAX_STAIR && !visited[nextUpStair]) {
                queue.add(nextUpStair);
                visited[nextUpStair] = true;
                buttonClickCounts[nextUpStair] = buttonClickCounts[curStair] + 1;

                if (nextUpStair == destinationStair) {
                    canGo = true;
                    break;
                }
            }

            int nextDownStair = curStair - downStairUnit;
            if (nextDownStair >= MIN_STAIR && !visited[nextDownStair]) {
                queue.add(nextDownStair);
                visited[nextDownStair] = true;
                buttonClickCounts[nextDownStair] = buttonClickCounts[curStair] + 1;

                if (nextDownStair == destinationStair) {
                    canGo = true;
                    break;
                }
            }
        }

        if (!canGo) {
            return 0;
        }

        return buttonClickCounts[destinationStair];
    }

}
