package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/3186
 */
public class BAEKJOON3186 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        String[] line = br.readLine().split("");
        List<Integer> answers = new LinkedList<>();


        int o = 0;
        int x = 0;
        int time = 0;
        boolean isUsing = false;

        for (int i = 0; i < N; i++) {
            time++;
            int temp = Integer.parseInt(line[i]);
            if (temp == 1) {
                o++;
                x = 0;
            }
            if (temp == 0) {
                o = 0;
                x++;
            }

            if (o == K) isUsing = true;
            if (x == L && isUsing) {
                isUsing = false;
                answers.add(time);
            }
        }

        if (answers.size() == 0 && !isUsing) {
            System.out.println("NIKAD");
            return;
        }
        if (isUsing) answers.add(L - x + time);
        StringBuilder sb = new StringBuilder();
        for (Integer answer : answers) sb.append(answer).append("\n");
        System.out.println(sb);
    }
}
