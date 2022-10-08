package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1717
 */
public class _1717 {

    static int[] sets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        sets = new int[n + 1];
        for (int i = 0; i < sets.length; i++) {
            sets[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch (command) {
                case 0: // Union
                    union(a, b);
                    break;
                case 1: // Find
                    bw.append(isSameSet(a, b) ? "YES" : "NO").append("\n");
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int find(int elem) {
        if (elem == sets[elem]) {
            return elem;
        }

        return sets[elem] = find(sets[elem]);
    }

    public static void union(int elem1, int elem2) {
        elem1 = find(elem1);
        elem2 = find(elem2);

        if (elem1 < elem2) {
            sets[elem2] = elem1;
        } else {
            sets[elem1] = elem2;
        }
    }

    public static boolean isSameSet(int elem1, int elem2) {
        elem1 = find(elem1);
        elem2 = find(elem2);

        return elem1 == elem2;
    }

}

