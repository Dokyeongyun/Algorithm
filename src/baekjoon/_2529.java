package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2529
 */
public class _2529 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static char[] arr = new char[10];
    static boolean[] visit = new boolean[10];
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) arr[i] = st.nextToken().charAt(0);

        dfs("", 0);
        Collections.sort(list);

        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));
    }

    private static void dfs(String num, int index) {
        if (index == N + 1) {
            list.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (visit[i]) continue;
            if (index == 0 || check(Character.getNumericValue(num.charAt(index - 1)), i, arr[index - 1])) {
                visit[i] = true;
                dfs(num + i, index + 1);
                visit[i] = false;
            }
        }
    }

    static boolean check(int a, int b, char c) {
        if (c == '<') {
            return a <= b;
        } else if (c == '>') {
            return a >= b;
        }
        return true;
    }
}
