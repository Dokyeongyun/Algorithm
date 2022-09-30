package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1062
 */
public class _1062 {

    static int N, K;

    static String[] words;
    static boolean[] visit;

    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < 5) {
            System.out.println(0);
            return;
        }

        if (K == 26) {
            System.out.println(N);
            return;
        }

        words = new String[N];
        visit = new boolean[26];

        visit[0] = true; // 'a'
        visit['n' - 'a'] = true; // 'c'
        visit['t' - 'a'] = true; // 't'
        visit['i' - 'a'] = true; // 'i'
        visit['c' - 'a'] = true; // 'c'

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            words[i] = temp.substring(4, temp.length() - 4);
        }

        backtracking(0, 0);
        System.out.println(max);
    }

    static void backtracking(int c, int count) {
        if (count == K - 5) {
            int temp = 0;
            for (int i = 0; i < N; i++) {
                boolean check = false;
                for (int j = 0; j < words[i].length(); j++) {
                    if (!visit[words[i].charAt(j) - 'a']) {
                        check = true;
                        break;
                    }
                }
                if (!check) temp++;
            }
            max = Math.max(temp, max);
            return;
        }
        for (int i = c; i < 26; i++) {
            if (!visit[i]) {
                visit[i] = true;
                backtracking(i, count + 1);
                visit[i] = false;
            }
        }
    }
}
