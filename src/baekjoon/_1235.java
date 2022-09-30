package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/1235
 */
public class _1235 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] stuNums = new String[N];

        for (int i = 0; i < N; i++) {
            stuNums[i] = br.readLine();
        }

        int count = 1;
        for (int i = stuNums[0].length()-1; i >= 0; i--) {
            List<String> list = new ArrayList<>();
            boolean check = false;
            for (int j = 0; j < N; j++) {
                String temp = stuNums[j].substring(i);
                if (!list.contains(temp)) {
                    list.add(temp);
                } else {
                    check = true;
                    break;
                }
            }

            if (!check) {
                break;
            } else {
                count++;
            }
        }
        System.out.println(count);
    }
}
/*
3

 */