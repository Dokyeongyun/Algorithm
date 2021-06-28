package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BAEKJOON2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Deque<int[]> dque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dque.addLast(new int[]{Integer.parseInt(st.nextToken()), i+1});
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int next = dque.peekFirst()[0];
            sb.append(dque.peekFirst()[1]).append(" ");
            dque.removeFirst();

            if (dque.isEmpty())
                break;

            if (next > 0) {
                next--;
                while (next-- > 0) {
                    dque.addLast(dque.peekFirst());
                    dque.removeFirst();
                }
            } else {
                while (next++ < 0) {
                    dque.addFirst(dque.peekLast());
                    dque.removeLast();
                }
            }
        }
        System.out.println(sb);
    }
}
