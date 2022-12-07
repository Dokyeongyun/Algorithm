package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2852
 */
public class _2852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int score1 = 0;
        int score2 = 0;

        int winTimeSec1 = 0;
        int winTimeSec2 = 0;

        int winTemp1 = 0;
        int winTemp2 = 0;

        int winner = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int team = Integer.parseInt(st.nextToken());
            String time = st.nextToken();
            String[] split = time.split(":");
            int minute = Integer.parseInt(split[0]);
            int second = Integer.parseInt(split[1]);
            int prevTimeSec = (minute * 60) + second;

            if (team == 1) {
                score1++;
            } else {
                score2++;
            }

            if (score1 > score2) {
                if (score1 - score2 <= 1 && winner != 1) {
                    winTemp1 = prevTimeSec;
                }
            } else if (score1 < score2) {
                if (score2 - score1 <= 1 && winner != 2) {
                    winTemp2 = prevTimeSec;
                }
            } else {
                if (team == 1) {
                    winTimeSec2 += prevTimeSec - winTemp2;
                } else {
                    winTimeSec1 += prevTimeSec - winTemp1;
                }
            }

            if (score1 > score2) {
                winner = 1;
            } else if (score1 < score2) {
                winner = 2;
            } else {
                winner = 0;
            }

            if (i == N - 1) {
                if (winner == 1) {
                    winTimeSec1 = winTimeSec1 + 48 * 60 - winTemp1;
                } else if (winner == 2) {
                    winTimeSec2 = winTimeSec2 + 48 * 60 - winTemp2;
                }
            }
        }

        if (winTimeSec1 / 60 < 10) {
            System.out.print(0);
        }
        System.out.print((winTimeSec1 / 60) + ":");
        if (winTimeSec1 % 60 < 10) {
            System.out.print(0);
        }
        System.out.println(winTimeSec1 % 60);

        if (winTimeSec2 / 60 < 10) {
            System.out.print(0);
        }
        System.out.print((winTimeSec2 / 60) + ":");
        if (winTimeSec2 % 60 < 10) {
            System.out.print(0);
        }
        System.out.println(winTimeSec2 % 60);
    }
}
