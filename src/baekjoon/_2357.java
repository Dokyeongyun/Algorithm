package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2357
 */
public class _2357 {
    static int[] numbers;
    static Pair[] segmentTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        segmentTree = new Pair[N * 4];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        makeSegmentTree(0, N - 1, 1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Pair find = findMinMaxPair(0, N - 1, 1, a-1, b-1);
            System.out.println(find.min + " " + find.max);
        }
    }

    private static Pair makeSegmentTree(int startIndex, int endIndex, int index) {
        if (startIndex == endIndex) {
            segmentTree[index] = new Pair(numbers[startIndex], numbers[startIndex]);
            return segmentTree[index];
        }
        int midIndex = (startIndex + endIndex) / 2;
        return segmentTree[index]
                = makeSegmentTree(startIndex, midIndex, index * 2)
                .compare(makeSegmentTree(midIndex + 1, endIndex, index * 2 + 1));
    }

    private static Pair findMinMaxPair(int startIndex, int endIndex,
                                       int index, int leftIndex, int rightIndex) {
        if (leftIndex > endIndex || rightIndex < startIndex) {
            return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        if (leftIndex <= startIndex && rightIndex >= endIndex) {
            return segmentTree[index];
        }

        int midIndex = (startIndex + endIndex) / 2;

        Pair left = findMinMaxPair(startIndex, midIndex, index * 2, leftIndex, rightIndex);
        Pair right = findMinMaxPair(midIndex + 1, endIndex, index * 2 + 1, leftIndex, rightIndex);
        return left.compare(right);
    }

    static class Pair {
        int min;
        int max;

        Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }

        Pair compare(Pair p) {
            int min = Math.min(this.min, p.min);
            int max = Math.max(this.max, p.max);
            return new Pair(min, max);
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", min, max);
        }
    }
}

