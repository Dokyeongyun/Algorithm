package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
문제
N×N크기의 행렬로 표현되는 종이가 있다.
종이의 각 칸에는 -1, 0, 1의 세 값 중 하나가 저장되어 있다.
우리는 이 행렬을 적절한 크기로 자르려고 하는데, 이때 다음의 규칙에 따라 자르려고 한다.

만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
(1)이 아닌 경우에는 종이를 같은 크기의 9개의 종이로 자르고, 각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.
이와 같이 종이를 잘랐을 때, -1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수, 1로만 채워진 종이의 개수를 구해내는 프로그램을 작성하시오.

입력
첫째 줄에 N(1≤N≤3^7, N은 3^k 꼴)이 주어진다. 다음 N개의 줄에는 N개의 정수로 행렬이 주어진다.

출력
첫째 줄에 -1로만 채워진 종이의 개수를, 둘째 줄에 0으로만 채워진 종이의 개수를, 셋째 줄에 1로만 채워진 종이의 개수를 출력한다.
 */
public class _1780 {

    static int[][] input;
    static int[] count = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        input = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < temp.length; j++) {
                input[i][j] = Integer.parseInt(temp[j]);
            }
        }

        check(0,0,n);

        for(int i=0; i<3; i++){
            System.out.println(count[i]);
        }
    }

    public static void check(int x, int y, int n) {

        int first = input[x][y];
        boolean c = false;

        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (input[i][j] != input[x][y]) {
                    split(x, y, n);
                    c = true;
                    break;
                }
            }
            if (c) {
                break;
            }
        }

        if (!c) {
            if (first == -1) {
                count[0]++;
            } else if (first == 0) {
                count[1]++;
            } else {
                count[2]++;
            }
        }
    }

    public static void split(int x, int y, int n) {

        int newN = n / 3;

        check(x, y, newN);
        check(x + newN, y, newN);
        check(x + (newN * 2), y, newN);

        check(x, y + newN, newN);
        check(x + newN, y + newN, newN);
        check(x + (newN * 2), y + newN, newN);

        check(x, y + (newN * 2), newN);
        check(x + newN, y + (newN * 2), newN);
        check(x + (newN * 2), y + (newN * 2), newN);
    }
}
