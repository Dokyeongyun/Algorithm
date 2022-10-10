package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * https://www.acmicpc.net/problem/1715
 */
public class _1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        if (queue.isEmpty()) {
            System.out.println(0);
            return;
        }

        int temp1 = 0;
        int temp2 = 0;
        int minCompareCount = 0;

        while (!queue.isEmpty()) {
            temp1 = queue.poll();
            if (!queue.isEmpty()) {
                temp2 = queue.poll();
                int sum = temp1 + temp2;
                queue.add(sum);
                minCompareCount += sum;
            }
        }

        System.out.println(minCompareCount);
    }
}
