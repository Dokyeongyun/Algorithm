package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1202
 */
public class _1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewelry[] jewelries = new Jewelry[N];
        int[] bags = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewelries[i] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewelries);
        Arrays.sort(bags);

        long max = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int jewelryIndex = 0;
        for (int i = 0; i < K; i++) {
            while (jewelryIndex < N && jewelries[jewelryIndex].weight <= bags[i]) {
                queue.add(jewelries[jewelryIndex].price);
                jewelryIndex++;
            }

            if (!queue.isEmpty()) {
                max += queue.poll();
            }
        }

        System.out.println(max);
    }

    static class Jewelry implements Comparable<Jewelry> {
        int weight;
        int price;

        public Jewelry(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Jewelry{" +
                    "weight=" + weight +
                    ", price=" + price +
                    '}';
        }

        @Override
        public int compareTo(Jewelry o) {
            if (this.weight == o.weight) {
                return Integer.compare(o.price, this.price);
            }
            return Integer.compare(this.weight, o.weight);
        }
    }
}
