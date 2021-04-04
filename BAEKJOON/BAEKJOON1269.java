package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
https://www.acmicpc.net/problem/1269
 */
public class BAEKJOON1269 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static TreeSet<Integer> set = new TreeSet<>();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        insert(a);
        insert(b);

        System.out.print(set.size());
    }

    static void insert(int size) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            int element = Integer.parseInt(st.nextToken());
            if (!set.add(element)) set.remove(element);
        }
    }
}
