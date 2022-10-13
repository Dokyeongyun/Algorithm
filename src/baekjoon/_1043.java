package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1043
 */
public class _1043 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] isKnowTheTruth = new boolean[N + 1];
        parent = new int[N + 1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int numberOfKnows = Integer.parseInt(st.nextToken());
        for (int i = 0; i < numberOfKnows; i++) {
            isKnowTheTruth[Integer.parseInt(st.nextToken())] = true;
        }

        List<Integer>[] partyPeople = new ArrayList[M + 1];
        for (int i = 1; i < partyPeople.length; i++) {
            partyPeople[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            String[] split = br.readLine().split(" ");

            int numberOfPartyPeople = Integer.parseInt(split[0]);

            if (numberOfPartyPeople == 1) {
                partyPeople[i].add(Integer.parseInt(split[1]));
                continue;
            }

            for (int j = 1; j < numberOfPartyPeople; j++) {
                int p1 = Integer.parseInt(split[j]);
                int p2 = Integer.parseInt(split[j + 1]);

                if (find(p1) != find(p2)) {
                    union(p1, p2);
                }

                partyPeople[i].add(p1);
                partyPeople[i].add(p2);
            }
        }

        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (isKnowTheTruth[i] && !visited[i]) {
                int parent = find(i);
                for (int j = 1; j <= N; j++) {
                    if (find(j) == parent) {
                        isKnowTheTruth[j] = true;
                        visited[j] = true;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 1; i < partyPeople.length; i++) {
            boolean flag = false;
            for (int person : partyPeople[i]) {
                if (isKnowTheTruth[person]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                count++;
            }
        }

        System.out.println(count);

    }

    private static int find(int index) {
        if (parent[index] == index) {
            return index;
        }

        return parent[index] = find(parent[index]);
    }

    private static void union(int a, int b) {
        int parentOfB = find(b);
        parent[parentOfB] = a;
    }

}