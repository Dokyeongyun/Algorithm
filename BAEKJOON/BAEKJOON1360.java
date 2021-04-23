package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
https://www.acmicpc.net/problem/1360
 */
public class BAEKJOON1360 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<History> histories = new ArrayList<>();
        histories.add(new History(0, ""));

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            String value = st.nextToken();
            int sec = Integer.parseInt(st.nextToken());

            if (command.equals("type")) {
                histories.add(new History(sec, histories.get(i - 1).value + value));
            } else if (command.equals("undo")) {
                boolean check = false;
                for (int j = i - 1; j >= 0; j--) {
                    History history = histories.get(j);
                    if (history.time <= sec - Integer.parseInt(value) - 1) {
                        histories.add(new History(sec, history.value));
                        check = true;
                        break;
                    }
                }
                if(!check){
                    histories.add(new History(sec, ""));
                }
            }
        }
        System.out.println(histories.get(N).value);
    }

    static class History {
        int time;
        String value;

        History(int time, String value) {
            this.time = time;
            this.value = value;
        }

        @Override
        public String toString() {
            return "History{" +
                    "time=" + time +
                    ", value='" + value + '\'' +
                    '}';
        }
    }
}
/*
4
type a 1
type b 2
undo 2 3
undo 2 4

4
type a 1
type b 2
type c 3
undo 1 5

2
type a 2
undo 3 3
 */