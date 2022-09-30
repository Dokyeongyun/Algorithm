package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2980
 */
public class _2980 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        TrafficLight[] arr = new TrafficLight[L + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            arr[D] = new TrafficLight(D, R, G);
        }

        int index = 0;
        int time = 0;

        while (index < L) {
            time++;
            index++;

            if (arr[index] != null) {
                int temp = time % (arr[index].r + arr[index].g);

                if (temp <= arr[index].r) {
                    time += (arr[index].r - temp);
                }
            }
        }

        System.out.println(time);

    }

    static class TrafficLight {
        int d;
        int r;
        int g;

        TrafficLight(int d, int r, int g) {
            this.d = d;
            this.r = r;
            this.g = g;
        }
    }
}
