package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1976
 */
public class _1976 {

    static int[] cities;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        cities = new int[N + 1];
        for (int i = 1; i < cities.length; i++) {
            cities[i] = i;
        }

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    union(i, j);
                }
            }
        }


        boolean isConnected = true;
        st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < M; i++) {

            if (start != find(Integer.parseInt(st.nextToken()))) {
                isConnected = false;
                break;
            }
        }

        System.out.println(isConnected ? "YES" : "NO");
    }

    private static void union(int elem1, int elem2) {
        elem1 = find(elem1);
        elem2 = find(elem2);

        if (elem1 < elem2) {
            cities[elem2] = elem1;
        } else {
            cities[elem1] = elem2;
        }
    }

    private static int find(int elem) {
        if (cities[elem] == elem) {
            return elem;
        }

        return cities[elem] = find(cities[elem]);
    }
}
