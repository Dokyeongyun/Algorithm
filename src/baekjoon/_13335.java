package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/13335
 */
public class _13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Queue<Integer> trucks = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            trucks.add(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }

        int time = 0;
        int weightSum = 0;
        while (!bridge.isEmpty()) {
            weightSum -= bridge.poll();
            if (!trucks.isEmpty()) {
                if (weightSum + trucks.peek() <= l) {
                    int newTruck = trucks.poll();
                    weightSum += newTruck;
                    bridge.add(newTruck);
                } else {
                    bridge.add(0);
                }
            }
            time++;
        }
        System.out.println(time);

    }
}
