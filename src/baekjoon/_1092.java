package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/1092
 */
public class _1092 {
    static int N, M;
    static ArrayList<Integer> cranes = new ArrayList<>();
    static ArrayList<Integer> boxes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cranes.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }

        cranes.sort(Collections.reverseOrder());
        boxes.sort(Collections.reverseOrder());

        if (cranes.get(0) < boxes.get(0)) {
            System.out.println("-1");
            return;
        }

        int time = 0;
        while (boxes.size() != 0) {
            int craneIndex = 0;
            int boxIndex = 0;

            while (craneIndex < N) {
                if (boxIndex == boxes.size()) break;
                if (boxes.get(boxIndex) <= cranes.get(craneIndex)) {
                    boxes.remove(boxIndex);
                    craneIndex++;
                } else if (boxes.get(boxIndex) > cranes.get(craneIndex)) {
                    boxIndex++;
                }
            }
            time++;
        }
        System.out.println(time);
    }
}
