package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/3665
 */
public class _3665 {

    static int[] inDegree;
    static int[] result;
    static List<Integer>[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            inDegree = new int[n + 1];
            result = new int[n + 1];
            nodes = new ArrayList[n + 1];
            for (int i = 0; i < nodes.length; i++) {
                nodes[i] = new ArrayList<>();
            }

            String[] ti = br.readLine().split(" ");
            int[] lastYearRanking = new int[n + 1];
            for (int i = 0; i < ti.length; i++) {
                int teamNo = Integer.parseInt(ti[i]);
                lastYearRanking[teamNo] = i + 1;
            }

            for (int i = 1; i < lastYearRanking.length; i++) {
                int curTeamRanking = lastYearRanking[i];
                for (int j = 1; j < lastYearRanking.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    int nextTeamRanking = lastYearRanking[j];
                    if (curTeamRanking < nextTeamRanking) {
                        nodes[i].add(j);
                        inDegree[j]++;
                    }
                }
            }


            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                // 작년에는 a < b면, 올해에는 a > b
                // 작년에는 a > b면, 올해에는 a < b
                if (lastYearRanking[a] > lastYearRanking[b]) {
                    nodes[a].add(b);
                    nodes[b].remove((Object) a);
                    inDegree[b]++;
                    inDegree[a]--;
                } else {
                    nodes[b].add(a);
                    nodes[a].remove((Object) b);
                    inDegree[a]++;
                    inDegree[b]--;
                }
            }


            for (int i = 1; i < nodes.length; i++) {
                System.out.println(i + ": " + nodes[i]);
            }

            System.out.println(Arrays.toString(inDegree));

            topologySort();
        }
    }

    private static void topologySort() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        if (queue.size() >= 2) {
            System.out.println("?");
            return;
        }

        for (int j = 1; j < inDegree.length; j++) {
            if (queue.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                return;
            }

            int cur = queue.poll();
            result[j] = cur;

            for (int i : nodes[cur]) {
                inDegree[i] -= 1;
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }
        }

        for (Integer integer : result) {
            if (integer == 0) {
                continue;
            }
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}
