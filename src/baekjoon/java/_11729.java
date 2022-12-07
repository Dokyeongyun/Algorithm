package baekjoon;

import java.util.Scanner;

/*
문제
세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다. 각 원판은 반경이 큰 순서대로 쌓여있다. 이제 수도승들이 다음 규칙에 따라 첫 번째 장대에서 세 번째 장대로 옮기려 한다.

한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
이 작업을 수행하는데 필요한 이동 순서를 출력하는 프로그램을 작성하라. 단, 이동 횟수는 최소가 되어야 한다.

아래 그림은 원판이 5개인 경우의 예시이다.

입력
첫째 줄에 첫 번째 장대에 쌓인 원판의 개수 N (1 ≤ N ≤ 20)이 주어진다.

출력
첫째 줄에 옮긴 횟수 K를 출력한다.

두 번째 줄부터 수행 과정을 출력한다. 두 번째 줄부터 K개의 줄에 걸쳐 두 정수 A B를 빈칸을 사이에 두고 출력하는데, 이는 A번째 탑의 가장 위에 있는 원판을 B번째 탑의 가장 위로 옮긴다는 뜻이다.
 */
public class _11729 {

    public static int count = 0;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        // 원반 N개를 이동하는 문제는 원반 N-1개를 이동하는 문제로 세분화, ----> 원반 1개를 이동하는 문제,,
        // 분할정복!

        move(N, 1, 2, 3);

        // 첫번째 줄에 이동횟수 출력위해 insert
        sb.insert(0, count + "\n");
        System.out.println(sb);
    }

    // num개의 원판을 from으로부터 by를 거쳐 to까지 이동시키는 move 함수
    public static void move(int num, int from, int by, int to) {

        // 함수 호출마다 이동 1번이므로 count++
        count++;

        if (num == 1) {
            // 이동시킬 원반이 1개라면, from -> to로 이동시킴
            sb.append(from + " " + to + "\n");
        } else {
            // 가장 큰 원판을 제외한 num-1 개를 A->B로 이동
            move(num - 1, from, to, by);

            // 나머지 가장 큰 원판을 A->C로 이동
            sb.append(from + " " + to + "\n");

            // B에 있는 num-1개의 원판을 B->C로 이동
            move(num - 1, by, from, to);
        }
    }
}
