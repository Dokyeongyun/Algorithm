package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1005
 */
public class _1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] inDegrees = new int[N + 1];
            int[] times = new int[N + 1];
            List<Integer>[] adjacentList = new ArrayList[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++) {
                adjacentList[i] = new ArrayList<>();
                times[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                adjacentList[x].add(y);
                inDegrees[y]++;
            }

            int W = Integer.parseInt(br.readLine());

            int[] maxTimes = new int[N + 1];
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i < inDegrees.length; i++) {
                if (inDegrees[i] == 0) {
                    maxTimes[i] = times[i];
                    queue.add(i);
                }
            }

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int next : adjacentList[cur]) {
                    maxTimes[next] = Math.max(maxTimes[next], maxTimes[cur] + times[next]);

                    inDegrees[next]--;
                    if (inDegrees[next] == 0) {
                        queue.add(next);
                    }
                }
            }

            System.out.println(maxTimes[W]);
        }

    }

    static class Node {
        int id;
        int time;

        Node(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }
}
