package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BAEKJOON16937 {

    static int H, W, N;
    static List<Node> list = new ArrayList<>();
    static List<Node> tempList = new ArrayList<>();
    static int[] visited = new int[100];
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Node(r, c));
        }

        dfs(2, 0);

        System.out.print(max);
    }

    static void dfs(int toPick, int start) {

        if (toPick == 0) {
            int h1 = tempList.get(0).h;
            int w1 = tempList.get(0).w;

            int h2 = tempList.get(1).h;
            int w2 = tempList.get(1).w;

            if (check(h1, w1, h2, w2)) {
                int area = h1 * w1 + h2 * w2;
                if (max < area) max = area;
            } else {
                for (int i = 0; i < 3; i++) {
                    int a, b, c, d;
                    if (i == 0) {
                        a = w1;
                        b = h1;
                        c = h2;
                        d = w2;
                    } else if (i == 1) {
                        a = h1;
                        b = w1;
                        c = w2;
                        d = h2;
                    } else {
                        a = w1;
                        b = h1;
                        c = w2;
                        d = h2;
                    }
                    if (check(a, b, c, d)) {
                        int area = h1 * w1 + h2 * w2;
                        if (max < area) max = area;
                        return;
                    }
                }
            }
            return;
        }


        for (int i = start; i < list.size(); i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                tempList.add(list.get(i));
                dfs(toPick - 1, i);
                tempList.remove(tempList.size() - 1);
                visited[i] = 0;
            }
        }
    }


    static boolean check(int h1, int w1, int h2, int w2) {
        return h1 + h2 <= H && Math.max(w1, w2) <= W
                || Math.max(h1, h2) <= H && w1 + w2 <= W;
    }

    static class Node {
        int h, w;

        Node(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }
}
