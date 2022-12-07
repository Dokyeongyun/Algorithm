package baekjoon;

import java.io.*;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class _1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());

            if (minHeap.size() == maxHeap.size()) {
                maxHeap.add(number);
            } else {
                minHeap.add(number);
            }

            if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
                if (minHeap.peek() < maxHeap.peek()) {
                    int temp = minHeap.poll();
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(temp);
                }
            }

            bw.append(String.valueOf(maxHeap.peek())).append("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
