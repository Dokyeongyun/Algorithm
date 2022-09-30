package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1706
 */
public class _1706 {

    static int R, C;
    static String[][] arr;
    static boolean[][] visit;
    static List<String> words = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new String[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                arr[i][j] = split[j];
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!arr[i][j].equals("#") && !visit[i][j]) {
                    getHorizonWord(i, j);
                }
            }
        }

        visit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!arr[i][j].equals("#") && !visit[i][j]) {
                    getVerticalWord(i, j);
                }
            }
        }

        System.out.println(words);
        Collections.sort(words);
        System.out.println(words.get(0));
    }

    static void getHorizonWord(int x, int y) {
        String temp = "";

        for (int i = y; i < C; i++) {
            if (arr[x][i].equals("#")) break;
            if (visit[x][i]) break;

            temp += arr[x][i];
            visit[x][i] = true;
        }

        if (temp.length() != 1 && !words.contains(temp)) words.add(temp);
    }

    static void getVerticalWord(int x, int y) {
        String temp = "";

        for (int i = x; i < R; i++) {
            if (arr[i][y].equals("#")) break;
            if (visit[i][y]) break;

            temp += arr[i][y];
            visit[i][y] = true;
        }

        if (temp.length() != 1 && !words.contains(temp)) words.add(temp);
    }
}
