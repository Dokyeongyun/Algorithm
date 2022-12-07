package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/4195
 */
public class _4195 {

    static int[] count;
    static int[] parent;
    static Map<String, Integer> idMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int idCount = 0;

            int F = Integer.parseInt(br.readLine());

            idMap = new LinkedHashMap<>();
            parent = new int[F * 2];
            count = new int[F * 2];

            StringTokenizer st;
            for (int i = 0; i < F; i++) {
                st = new StringTokenizer(br.readLine());

                String p1 = st.nextToken();
                String p2 = st.nextToken();

                if (!idMap.containsKey(p1)) {
                    count[idCount] = 1;
                    parent[idCount] = idCount;
                    idMap.put(p1, idCount++);
                }
                if (!idMap.containsKey(p2)) {
                    count[idCount] = 1;
                    parent[idCount] = idCount;
                    idMap.put(p2, idCount++);
                }

                int p1Id = idMap.get(p1);
                int p2Id = idMap.get(p2);
                union(p1Id, p2Id);

                System.out.println(count[find(p2Id)]);
            }
        }
    }

    private static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        // Already connected
        if (parentA == parentB) {
            return;
        }

        // Connect
        parent[parentB] = parentA;
        count[parentA] += count[parentB];
    }

    private static int find(int n) {
        if (parent[n] == n) {
            return n;
        }
        return parent[n] = find(parent[n]);
    }
}
